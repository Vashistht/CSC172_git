import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DNAList {

    /** Enum for DNA or RNA */
    enum Type{
        DNA,
        RNA,
    }

    /** Enum for empty or filled spots in sequence array */
    enum Status {
        EMPTY,
        FILLED,
    }

    static LList.Link[] arrLinks;
    static Status[] arrFilled;

    public static void main(String[] args) throws FileNotFoundException {
        LList lList = new LList();
        Array arr = new Array();

        String number = args[0]; // should be 20
        String filename = args[1];
        arrLinks = new LList.Link[Integer.parseInt(number)];
        arrFilled = new Status[Integer.parseInt(number)];
        Array.initArray(arrFilled);
        File testfile = new File(filename);
        Scanner scan = new Scanner(testfile);

        /** Strings are used for reading commands from the txt file and we split them into further commands
         ** using the if else statment series we use the corresponding functions that we have in LList
         */
        while(scan.hasNextLine()){
            String command = scan.nextLine();
            String[] seperateCommand = command.trim().split("\\s+"); //split by space
            //Inserting
            if(seperateCommand[0].toLowerCase().equals("insert")){
                if(Type.valueOf(seperateCommand[2]).equals(Type.DNA)){ //Type DNA
                    LList.Link sequence =
                            lList.newList(Integer.parseInt(seperateCommand[1]) , seperateCommand[3], arrLinks);
                    if(!LList.checkIfDNA(sequence)){
                        System.out.println("Error occurred while inserting");
                    } else if (LList.checkIfDNA(sequence)){
                        int pos = Integer.parseInt(seperateCommand[1]);
                        arrFilled[Integer.parseInt(seperateCommand[1])] = Status.FILLED;
                        arr.nodeArray(pos, arrFilled, sequence);
                    }
                } else if(Type.valueOf(seperateCommand[2]).equals(Type.RNA)){ // Type RNA
                    LList.Link sequence =
                            lList.newList(Integer.parseInt(seperateCommand[1]) , seperateCommand[3], arrLinks);
                    if(!LList.checkIfRNA(sequence)){
                        System.out.println("Error occurred while inserting");
                    } else if (LList.checkIfRNA(sequence)){
                        int pos = Integer.parseInt(seperateCommand[1]);
                        arrFilled[Integer.parseInt(seperateCommand[1])] = Status.FILLED;
                        arr.nodeArray(pos, arrFilled, sequence);
                    }
                }
            }
            /** Deleting sequences from sequence array */
            else if(seperateCommand[0].toLowerCase().equals("remove")){
                if(arrFilled[Integer.parseInt(seperateCommand[1])].equals(Status.FILLED)){
                    lList.deleteList(Integer.parseInt(seperateCommand[1]), arrLinks);
                } else if(arrFilled[Integer.parseInt(seperateCommand[1])].equals(Status.EMPTY)){
                    System.out.println("No sequence to remove at specified position");
                }
            }
            /** Different ways of printing sequences */
            else if(seperateCommand[0].toLowerCase().equals("print")){
                if(seperateCommand.length == 1){
                    arr.printFilledArray(arrLinks);
                } else if(seperateCommand.length == 2){
                    int pos = Integer.parseInt(seperateCommand[1]);
                    if(arrFilled[pos].equals(Status.FILLED))
                        arr.printElementArray(Integer.parseInt(seperateCommand[1]), arrLinks);
                    else if(arrFilled[pos].equals(Status.EMPTY)){
                        System.out.println("No sequence to print at specified position");
                    }
                }
                //Clipping sequences
            } else if(seperateCommand[0].toLowerCase().equals("clip")) {
                int pos = Integer.parseInt(seperateCommand[1]);
                int start =Integer.parseInt(seperateCommand[2]);
                int end = Integer.parseInt(seperateCommand[3]);
                LList.Link newHead = lList.clipList(pos, start, end, arrLinks);
                arr.nodeArray(pos, arrFilled, newHead);

                //Copying sequences
            } else if(seperateCommand[0].toLowerCase().equals("copy")){
                int pos1 = Integer.parseInt(seperateCommand[1]);
                int pos2 = Integer.parseInt(seperateCommand[2]);
                LList.Link copy = lList.copyList(pos1, arrLinks);
                arrFilled[pos2] = Status.FILLED;
                arr.nodeArray(pos2, arrFilled, copy);

                //Transcribing sequences
            } else if(seperateCommand[0].toLowerCase().equals("transcribe")){
                int pos = Integer.parseInt(seperateCommand[1]);
                if(arrFilled[pos].equals(Status.FILLED)) {
                    LList.Link transcribed = lList.transcribeList(pos, arrLinks);
                    LList.Link reversed = lList.reverseList(transcribed);
                    arr.nodeArray(pos, arrFilled, reversed);
                }else if(arrFilled[pos].equals(Status.EMPTY)){
                    System.out.println("No sequence to transcribe at specified position");
                }
            }
        }
    }
}


