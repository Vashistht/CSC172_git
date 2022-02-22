import java.io.File;
import java.lang.reflect.Array;
import java.util.Scanner;

public class DNAList {
//    static array of notes
// enumeration RNA, DNA
//    enumeration if the list is filled

    LList linkedList = new LList();
    Array arr = new Array();

    Scanner s = new Scanner(commands);

    while(s.hasNextLine())

    {
        String command = s.nextLine();
        String[] commandParsed= command.trim().split("\\s+");

//        insert pos type sequence (Insert sequence to position pos in the sequence array
//         insert = commandParsed[0], pos=commandParsed[1], type = commandParsed[2], sequence = commandParsed[3]
        /*
         if (commandParsed[0].toLowerCase().equals("insert")){
            if commandSeparated[2] == "DNA"{
                nodelist = newlist (Integer.parseInt( commandParsed[1]) , commandParsed[3])
                (1) i
         */


        while(s.hasNextLine()){
        String command = s.nextLine();
        String[] commandSeparated = command.trim().split("\\s+");
        //Inserting a sequence
        if(commandSeparated[0].toLowerCase().equals("insert")){
            if(Type.valueOf(commandSeparated[2]).equals(Type.DNA)){ //of Type DNA
                LinkedList.Node sequence =
                        linkedList.newList(Integer.parseInt(commandSeparated[1]) , commandSeparated[3], nodeArr);
                if(!LinkedList.checkNodesDNA(sequence)){
                    System.out.println("Error occurred while inserting");
                } else if (LinkedList.checkNodesDNA(sequence)){
                    int pos = Integer.parseInt(commandSeparated[1]);
                    filledArr[Integer.parseInt(commandSeparated[1])] = Filled.FILLED;
                    arr.nodeArray(pos, filledArr, sequence);
                }
            } else if(Type.valueOf(commandSeparated[2]).equals(Type.RNA)){ //of Type RNA
                LinkedList.Node sequence =
                        linkedList.newList(Integer.parseInt(commandSeparated[1]) , commandSeparated[3], nodeArr);
                if(!LinkedList.checkNodesRNA(sequence)){
                    System.out.println("Error occurred while inserting");
                } else if (LinkedList.checkNodesRNA(sequence)){
                    int pos = Integer.parseInt(commandSeparated[1]);
                    filledArr[Integer.parseInt(commandSeparated[1])] = Filled.FILLED;
                    arr.nodeArray(pos, filledArr, sequence);
                }
            }
            //Deleting sequences from sequence array
        } else if(commandSeparated[0].toLowerCase().equals("remove")){
            if(filledArr[Integer.parseInt(commandSeparated[1])].equals(Filled.FILLED)){
                linkedList.deleteList(Integer.parseInt(commandSeparated[1]), nodeArr);
            } else if(filledArr[Integer.parseInt(commandSeparated[1])].equals(Filled.EMPTY)){
                System.out.println("No sequence to remove at specified position");
            }
            //Different ways of printing sequences
        } else if(commandSeparated[0].toLowerCase().equals("print")){
            if(commandSeparated.length == 1){
                arr.printArray(nodeArr);
            } else if(commandSeparated.length == 2){
                int pos = Integer.parseInt(commandSeparated[1]);
                if(filledArr[pos].equals(Filled.FILLED))
                    arr.printArrElement(Integer.parseInt(commandSeparated[1]), nodeArr);
                else if(filledArr[pos].equals(Filled.EMPTY)){
                    System.out.println("No sequence to print at specified position");
                }
            }
            //Clipping sequences
        } else if(commandSeparated[0].toLowerCase().equals("clip")) {
            int pos = Integer.parseInt(commandSeparated[1]);
            int start =Integer.parseInt(commandSeparated[2]);
            int end = Integer.parseInt(commandSeparated[3]);
            LinkedList.Node newHead = linkedList.clipList(pos, start, end, nodeArr);
            arr.nodeArray(pos, filledArr, newHead);
            //Copying sequences
        } else if(commandSeparated[0].toLowerCase().equals("copy")){
            int pos1 = Integer.parseInt(commandSeparated[1]);
            int pos2 = Integer.parseInt(commandSeparated[2]);
            LinkedList.Node copy = linkedList.copyList(pos1, nodeArr);
            filledArr[pos2] = Filled.FILLED;
            arr.nodeArray(pos2, filledArr, copy);
            //Transcribing sequences
        } else if(commandSeparated[0].toLowerCase().equals("transcribe")){
            int pos = Integer.parseInt(commandSeparated[1]);
            if(filledArr[pos].equals(Filled.FILLED)) {
                LinkedList.Node transcribed = linkedList.transcribeList(pos, nodeArr);
                LinkedList.Node reversed = linkedList.reverseList(transcribed);
                arr.nodeArray(pos, filledArr, reversed);
            }else if(filledArr[pos].equals(Filled.EMPTY)){
                System.out.println("No sequence to transcribe at specified position");
}
