//package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lab3Task2 {
	/*
	 * Lab 3 Task 2
	 * Author: Livia Betti
	 * Partner: Vashisth Tiwari
	 * Lab3Task2: class with two methods
	 * runningSum2DArray - creates array of running sum in specified direction
	 * runningSum2DArrayList - creates 2D ArrayList of running sum in specified direction
	 */
	
	public static int[][] runningSum2DArray(int[][] array, int dir){
		int[][] runningSumArray = new int[4][4]; //new array that will contain sums
		int runningSum;
		
		if (dir == 1) { //Left
			for (int i = 0; i < 4; i++) { //Fixes row
				runningSum = 0;
				for (int j = 0; j < 4; j++) {
					runningSum += array[i][3-j]; //Adds from right to left
					runningSumArray[i][3-j] = runningSum;
				}
			}
		} else if (dir == 2) { //Right
			for (int i = 0; i < 4; i++) { //Fixes row
				runningSum = 0;
				for (int j = 0; j < 4; j++) {
					runningSum += array[i][j]; //Adds from left to right
					runningSumArray[i][j] = runningSum;
				}
			}
		} else if (dir == 3) { //Up
			for (int i = 0; i < 4; i++) { //Fixes column
				runningSum = 0;
				for (int j = 0; j < 4; j++) {
					runningSum += array[3-j][i]; //Adds from bottom to top
					runningSumArray[3-j][i] = runningSum;
				}
			}
		} else if (dir == 4) { //Down
			for (int i = 0; i < 4; i++) { //Fixes column
				runningSum = 0;
				for (int j = 0; j < 4; j++) {
					runningSum += array[j][i]; //Adds from top to bottom
					runningSumArray[j][i] = runningSum;
				}
			}
		}
		return runningSumArray;
	}
	
	public static ArrayList<ArrayList< Integer > > runningSum2DArrayList(ArrayList<ArrayList< Integer > > list, int dir){
		ArrayList<ArrayList< Integer > > runningSumArray = new ArrayList<ArrayList< Integer > >(); //New ArrayList will contain sums
		
		if (dir == 1) { //Left
			for (int i = 0; i < list.size(); i++) { //Fixes row
				ArrayList<Integer> row = new ArrayList<Integer>();
				for (int j = 0; j < list.get(i).size(); j++) { //Fixes column
					Integer runningSum = 0;
					for (int k = j; k < list.get(i).size(); k++) {
						runningSum += list.get(i).get(k); //Adds to running sum
					}
					row.add(runningSum); //Adds running sum to row
				}
				runningSumArray.add(row); //Adds row to ArrayList
			}
		} else if (dir == 2) { //Right
			for (int i = 0; i < list.size(); i++) { //Fixes row
				ArrayList<Integer> row = new ArrayList<Integer>();;
				for (int j = 0; j < list.get(i).size(); j++) { //Fixes column
					Integer runningSum = 0;
					for (int k = 0; k <= j; k++) {
						runningSum += list.get(i).get(k); //Adds to running sum
					}
					row.add(runningSum); //Adds running sum to row
				}
				runningSumArray.add(row); //Adds row to ArrayList
			}
		} else if (dir == 3) { //Up
			for (int i = 0; i < list.size(); i++) { //Fixes column
				ArrayList<Integer> row = new ArrayList<Integer>();;
				for (int j = 0; j < list.get(i).size(); j++) { //Fixes row
					Integer runningSum = 0;
					for (int k = i; k < list.size(); k++) {
						runningSum += list.get(k).get(j); //Adds to running sum
					}
					row.add(runningSum); //Adds runningSum to row
				}
				runningSumArray.add(row); //Adds row to ArrayList
			}
		} else if (dir == 4) { //Down
			for (int i = 0; i < list.size(); i++) { //Fixes column
				ArrayList<Integer> row = new ArrayList<Integer>();;
				for (int j = 0; j < list.get(i).size(); j++) { //Fixes row
					Integer runningSum = 0;
					for (int k = 0; k <= i; k++) {
						runningSum += list.get(k).get(j); //Adds to running sum
					}
					row.add(runningSum); //Adds runningSum to row
				}
				runningSumArray.add(row); //Adds row to ArrayList
			}
		}
		return runningSumArray;
	}
	
	public static void main(String[] args) {
		//System.out.println("Test method 1:");
		//Tests method 1 with array
		int[][] myArray2 = {{10, 15, 30, 40},{15, 5, 8, 2}, {20, 2, 4, 2},{1, 4, 5, 0}};
		Lab3Task1.print2Darray(runningSum2DArray(myArray2, 2));
		
		
		//System.out.println("Test method 2:")
		//Tests method 2 with ArrayList
		//Creating ArrayList<ArrayList<Integer>> to test print2DList method
		ArrayList<ArrayList<Integer>> myArray = new ArrayList<ArrayList<Integer>>();;
		
		//a1, a2, a3 represent rows
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		ArrayList<Integer> a4 = new ArrayList<Integer>();

		//Adding elements to rows
        a1.add(1);
        a1.add(2);
		a1.add(3);
		a1.add(4);

		a2.add(5);
		a2.add(6);
		a2.add(7);
		a2.add(8);

		a3.add(9);
        a3.add(10);
		a3.add(11);
        a3.add(12);
		        
		a4.add(13);
		a4.add(14);
		a4.add(15);
        a4.add(16);
				
		//Adding rows to 2D ArrayList
		myArray.add(a1);
		myArray.add(a2);
		myArray.add(a3);
		myArray.add(a4);
		
		//System.out.println("Running Sum Left");
		Lab3Task1.print2DList(runningSum2DArrayList(myArray, 1)); //Change number to change direction
		//System.out.println("Running Sum Right");
		Lab3Task1.print2DList(runningSum2DArrayList(myArray, 2)); 
		//System.out.println("Running Sum Up");
		Lab3Task1.print2DList(runningSum2DArrayList(myArray, 3)); 
		//System.out.println("Running Sum Down");
		Lab3Task1.print2DList(runningSum2DArrayList(myArray, 4)); 
	}

}
