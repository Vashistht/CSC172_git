import java.util.Arrays;
public class Array {

    /** Print - as specified index, needed for commands "print n" for n an int */
    public void printElementArray(int index, LList.Link[] array){
        if(LList.checkIfRNA(array[index])){
            System.out.print("RNA" + "\t");
            LList.printLinks(array[index]);
        } else if(LList.checkIfDNA(array[index])){
            System.out.print("DNA" + "\t");
            LList.printLinks(array[index]);
        }
    }

    /** Printer- filled status , needed for command "print" */
    public void printFilledArray(LList.Link[] array){
        for(int i = 0; i < array.length; i++){
            if(DNAList.arrFilled[i].equals(DNAList.Status.FILLED)){
                if(LList.checkIfRNA(array[i])){ // for filled ones check type and print accordingly
                    System.out.print(i + "\t" + "RNA" + "\t");
                    LList.printLinks(array[i]);
                } else if(LList.checkIfDNA(array[i])){
                    System.out.print(i + "\t" + "DNA" + "\t");
                    LList.printLinks(array[i]);
                }
            }
        }
    }

    /** checks if filled or empty and stores the sequence */
    public void nodeArray(int pos, DNAList.Status[] filled, LList.Link head){
        if(filled[pos].equals(DNAList.Status.EMPTY)){
            DNAList.arrLinks[pos] = head;
        } else if(filled[pos].equals(DNAList.Status.FILLED)) {
            if (LList.checkIfDNA(head) || LList.checkIfRNA(head)) {
                DNAList.arrLinks[pos] = head;
            }
        }
    }

    /** Initializes with EMPTY enum */
    public static void initArray(DNAList.Status[] filled){
        Arrays.fill(filled, DNAList.Status.EMPTY);
    }
}