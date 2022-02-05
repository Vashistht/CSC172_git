// Author: Vashisth Tiwari
// Lab-Partners: Livia Bettij
//Email: vtiwari2@u.rochester.edu
//Student ID: 31564441

public class Lab2 {

    /* printArrayNonGen is a method with an array of Objects as a parameter
     that prints the array
     */
    public static void printArrayNonGen(Object[] objectArray){
        for (int i=0; i< objectArray.length; i++){
            System.out.print(objectArray[i] + " ");
        }
        System.out.println(" ");
    }
    /*
    printArray method use method overloading
    prints the array (with overloading for each type)
    */
    // takes in Integer array
    public static void printArray(Integer[] intArray){
        for (int i=0; i< intArray.length; i++){
            System.out.print(intArray[i] + " ");
        }
        System.out.println(" ");
    }
    // takes in Double array
    public static void printArray(Double[] doubArray){
        for (int i=0; i< doubArray.length; i++){
            System.out.print(doubArray[i] + " ");
        }
        System.out.println(" ");
    }
    // takes in Character array
    public static void printArray(Character[] charArray){
        for (int i=0; i< charArray.length; i++){
            System.out.print(charArray[i] + " ");
        }
        System.out.println(" ");
    }

    // takes in String array
    public static void printArray(String[] strArray){
        for (int i=0; i< strArray.length; i++){
            System.out.print(strArray[i] + " ");
        }
        System.out.println(" ");
    }
    /*
    printArrayGen is a method with an array that uses generics
    prints the array regardless of the type.
     */
    public static <T> void printArrayGen(T[] genArray){
        for (int i=0; i< genArray.length; i++){
            System.out.print(genArray[i] + " ");
        }
        System.out.println(" ");
    }
    /*
    getMax is a method that takes in a Comparable object type
    returns the maximum element of the array
     */
    public static Comparable getMax(Comparable [] anArray){
        Comparable temp = anArray[0];
        for (int i=0; i< anArray.length; i++){
            if (temp.compareTo(anArray[i]) < 0){
                temp =  anArray[i];
            }
        }
//        System.out.println(" ");
        return temp;
    }
    /*
    getMax is a method that uses generics to support different array type
   returns the maximum element of the array
   */
    public static < T extends Comparable> T getMaxGen(T[] anArraygen){
        T temp = anArraygen[0];
        for (int i=0; i< anArraygen.length; i++){
            if (temp.compareTo(anArraygen[i]) < 0){
                temp =  anArraygen[i];
            }
        }
        return temp;
    }
    /*
    - the main method declares the 4 arrays of different kinds as given in the sample output document.
    - These can be changed by the user in case they want different array for these data types
    - Then the main methods prints the arrays of different kinds using print array,
     the generic and the non generic methods
    - prints the maximum element using the generic and non generic method.
     */
    public static void main(String[] args) {
        Integer [] intArray = {1, 2, 3, 4, 5 };
        Double [] doubArray = {1.1, 2.2, 3.3, 4.4};
        Character [] charArray = {'H','E','L', 'L', 'O' };
        String [] strArray = {"once", "upon", "a", "time" };
        System.out.println("Printing nonGen:");
        printArrayNonGen(charArray);
        printArrayNonGen(intArray);
        printArrayNonGen(strArray);
        printArrayNonGen(doubArray);
        System.out.println(" ");

        System.out.println("Printing Type Specific:");
        printArray(charArray);
        printArray(intArray);
        printArray(strArray);
        printArray(doubArray);
        System.out.println(" ");

        System.out.println("Printing Generic:");
        printArrayGen(charArray);
        printArrayGen(intArray);
        printArrayGen(strArray);
        printArrayGen(doubArray);
        System.out.println(" ");

        System.out.println("Printing getMax (not generic):");
        System.out.println( getMax(charArray) );
        System.out.println( getMax(intArray) );
        System.out.println( getMax(strArray) );
        System.out.println( getMax(doubArray) );
        System.out.println(" ");

        System.out.println("Printing getMax (generic):");
        System.out.println( getMaxGen(charArray) );
        System.out.println( getMaxGen(intArray) );
        System.out.println( getMaxGen(strArray) );
        System.out.println( getMaxGen(doubArray) );

    }
}
