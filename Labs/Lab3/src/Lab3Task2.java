import java.sql.SQLOutput;
import java.util.ArrayList;

public class Lab3Task2 {

    /*
    	- runningSum2DArray: a 4x4 two dimensional int array and an integer (1, 2, 3 or 4 for left, right, up, down respectively).
		returns: The modified array after producing the running sums according to the direction.
    */

    public static int[][] runningSum2DArray(int[][] array, int dir) {
        int[][] temparray = array;

        // 1: left
        if (dir == 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 2; j >= 0; j--) {
                    temparray[i][j] += temparray[i][j + 1];
                }
            }
        }
        // 2: right
        else if (dir == 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j<4; j++) {
                    temparray[i][j] += temparray[i][j - 1];
                }
            }
        }
        // 3: up
        else if (dir == 3) {
            for (int i = 2; i >= 0; i--) {
                for (int j = 0; j < 4; j++) {
                    temparray[i][j] += temparray[i + 1][j];
                }
            }
        }
        // 4: down
        else if (dir == 4) {
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temparray[i][j] += temparray[i - 1][j];
                }
            }
        }
        return temparray;
    }

    /*
    	- runningSum2DArrayList: a 4x4 two dimensional int arrayList and an integer (1, 2, 3 or 4 for left, right, up, down respectively).
			returns: The modified arrayList after producing the running sums according to the direction.
    */
    public static ArrayList<ArrayList<Integer>> runningSum2DArrayList(ArrayList<ArrayList<Integer>> list, int dir) {
        ArrayList<ArrayList<Integer>> tempList2D = list;
        ArrayList<Integer> tempList1D = new ArrayList<>();

        // 1: left
        if (dir == 1) {
            for (int i = 0; i < 4; i++) {
                tempList1D = tempList2D.get(i);
                for (int j = 2; j >= 0; j--) {
                    tempList1D.set(j, tempList2D.get(i).get(j + 1) + tempList2D.get(i).get(j));
                    tempList2D.set(i, tempList1D);
//                    tempList[i][j] += templist[i][j + 1];
                }
            }
        }

        // 2: right
        else if (dir == 2) {
            for (int i = 0; i < 4; i++) {
                tempList1D = tempList2D.get(i);
                for (int j = 1; j<4; j++) {
                    tempList1D.set(j, tempList2D.get(i).get(j - 1) + tempList2D.get(i).get(j));
                    tempList2D.set(i, tempList1D);
//                    temparray[i][j] += temparray[i][j - 1];
                }
            }
        }

        // 3: up
        else if (dir == 3) {
            for (int i = 2; i >= 0; i--) {
                tempList1D = tempList2D.get(i);
                for (int j = 0; j < 4; j++) {
                    tempList1D.set(j, tempList2D.get(i + 1).get(j) + tempList2D.get(i).get(j));
                    tempList2D.set(i, tempList1D);
//                    temparray[i][j] += temparray[i + 1][j];
                }
            }
        }
        // 4: down
        else if (dir == 4)
            for (int i = 1; i < 4; i++) {
                tempList1D = tempList2D.get(i);
                for (int j = 0; j < 4; j++) {
                    tempList1D.set(j, tempList2D.get(i - 1).get(j) + tempList2D.get(i).get(j));
                    tempList2D.set(i, tempList1D);
//                    temparray[i][j] += temparray[i - 1][j];
                }
            }
        return tempList2D;
    }

}