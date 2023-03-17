import java.util.ArrayList;

public class Main {

    /*
    cloneArray takes in an integer array; returns a copy of the integer array
    we make this function so as to not change the contents of the orginal array
     */
    public static int[][] cloneArray(int[][] array){
        int[][] tempArray = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tempArray[i][j] = array[i][j];
            }
        }
        return tempArray;
    }
    /*
    cloneArrayList takes in an integer ArrayList; returns a copy of the integer ArrayList
    we make this function so as to not change the contents of the orginal ArrayList
     */
    public static ArrayList<ArrayList<Integer>> cloneArrayList(ArrayList<ArrayList<Integer>> list) {
        ArrayList<ArrayList<Integer>> tempList2D = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> arrayList1D = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                arrayList1D.add(j, list.get(i).get(j));
            }
            tempList2D.add(arrayList1D);
        }
        return tempList2D;
    }

    public static void main(String[] args){
        // the array given in the document
        int[][] array = {{10, 15, 30, 40},{15, 5, 8, 2}, {20, 2, 4, 2},{1, 4, 5, 0}};

        // make the list from the array given in the document
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>> ();

        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> arrayList1D = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                arrayList1D.add(j, array[i][j]);
            }
            arrayList.add(arrayList1D);
        }

        // Tests
        // Task 1 array
        System.out.println("Printing the given array");
        Lab3Task1.print2Darray(array);
        System.out.println();

        // Task 1 arrayList
        System.out.println("Printing the arrayList");
        Lab3Task1.print2DList(arrayList);
        System.out.println();

        // Task 2 array
        // Left (dir 1)
        System.out.println("Using arrays");
        int[][] temparray1 = cloneArray(array);
        System.out.println("Running sum left");
        Lab3Task1.print2Darray( Lab3Task2.runningSum2DArray(temparray1, 1) );
        System.out.println();

        // Right (dir 2)
        int[][] temparray2 = cloneArray(array);
        System.out.println("Running sum right");
        Lab3Task1.print2Darray( Lab3Task2.runningSum2DArray(temparray2,2) );
        System.out.println();

        // Up (dir 3)
        int[][] temparray3 = cloneArray(array);
        System.out.println("Running sum up");
        Lab3Task1.print2Darray( Lab3Task2.runningSum2DArray(temparray3, 3) );
        System.out.println();

        // Down (dir 4)
        int[][] temparray4 = cloneArray(array);
        System.out.println("Running sum down");
        Lab3Task1.print2Darray( Lab3Task2.runningSum2DArray(temparray4, 4) );
        System.out.println();

        // Task 2 arrayList
        System.out.println("Using arrayLists");
        // Left (dir 1)
        ArrayList<ArrayList<Integer>> tempList2DLeft= cloneArrayList(arrayList);         //clonedList so as to not mess up the original arrayList
        System.out.println("Running sum left");
        Lab3Task1.print2DList(Lab3Task2.runningSum2DArrayList(tempList2DLeft, 1));
        System.out.println();

        // Right (dir 2)
        ArrayList<ArrayList<Integer>> tempList2DRight = cloneArrayList(arrayList);         //clonedList so as to not mess up the original arrayList
        System.out.println("Running sum right");
        Lab3Task1.print2DList(Lab3Task2.runningSum2DArrayList(tempList2DRight, 2));
        System.out.println();


        // Up (dir 3)
        ArrayList<ArrayList<Integer>> tempList2DUp = cloneArrayList(arrayList);          //clonedList so as to not mess up the original arrayList
        System.out.println("Running sum up");
        Lab3Task1.print2DList(Lab3Task2.runningSum2DArrayList(tempList2DUp, 3));
        System.out.println();

        // Down (dir 4)
        ArrayList<ArrayList<Integer>> tempList2DDown = cloneArrayList(arrayList);         //clonedList so as to not mess up the original arrayList
        System.out.println("Running sum down");
        Lab3Task1.print2DList(Lab3Task2.runningSum2DArrayList(tempList2DDown, 4));
        System.out.println();

        // Task 3 tests

        ArrayList<Integer> task3TestList = new ArrayList<Integer>(); // creating an arrayList to test Lab3Task3
        task3TestList.add(1);
        task3TestList.add(2);
        task3TestList.add(3);

        Lab3Task3.printArrayListBasicLoop(task3TestList); //bring using basic loop
        Lab3Task3.printArrayListEnhancedLoop(task3TestList);
        Lab3Task3.printArrayListForLoopListIterator(task3TestList);
        Lab3Task3.printArrayListWhileLoopListIterator(task3TestList);
    }
}