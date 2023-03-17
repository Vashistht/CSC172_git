import java.util.ArrayList;

public class Lab3Task1 {
    //Printing method for array
    public static void print2Darray(int[][] array){
        for (int i=0; i< array.length; i++){
            for (int j=0; j< array[i].length; j++){
                System.out.printf("%-10s", array[i][j]);
            }
            System.out.println();
        }
    }

    //Print method for list
    public static void print2DList(ArrayList<ArrayList<Integer>> list) {
        for (int i=0; i< list.size(); i++){
            for (int j=0; j< list.get(i).size(); j++){ // what do i do here!
                System.out.printf("%-10s", list.get(i).get(j));
            }
            System.out.println();
        }
    }
}
