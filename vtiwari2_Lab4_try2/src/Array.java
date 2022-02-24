import java.util.Arrays;
public class Array {

    /** Printer- filled status , needed for commands print */
    public void printFilledArray(LList.Link[] arr){
        for(int i = 0; i < arr.length; i++){
            if(DNAList.arrFilled[i].equals(DNAList.Status.FILLED)){
                if(LList.checkIfRNA(arr[i])){ // for filled ones check type and print accordingly
                    System.out.print(i + "\t" + "RNA" + "\t");
                    LList.printNodes(arr[i]);
                } else if(LList.checkIfDNA(arr[i])){
                    System.out.print(i + "\t" + "DNA" + "\t");
                    LList.printNodes(arr[i]);
                }
            }
        }
    }

    /** Print - as specified index, needed for commands print n */
    public void printArrElement(int index, LList.Link[] arr){
        if(LList.checkIfRNA(arr[index])){
            System.out.print("RNA" + "\t");
            LList.printNodes(arr[index]);
        } else if(LList.checkIfDNA(arr[index])){
            System.out.print("DNA" + "\t");
            LList.printNodes(arr[index]);
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





