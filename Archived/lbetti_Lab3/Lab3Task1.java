//package dp;

import java.util.ArrayList;

public class Lab3Task1 {
	
	/*
	 * Lab 3 Task 1
	 * Author: Livia Betti
	 * Partner: Vashisth Tiwari
	 * Lab3Task2 class: Has two methods
	 * print2Darray - prints int[][] array with correct spacing
	 * print2DList - prints ArrayList<ArrayList<Integer>> with correct spacing
	 */
	
	public static void print2Darray(int[][] array) {
		String intAsString = "";
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				intAsString = Integer.toString(array[i][j]); //Converts int to String to print with correct spacing
				System.out.printf("%4s", intAsString); //Formats spacing
			}
			System.out.println();
		}
	}
	
	public static void print2DList(ArrayList<ArrayList<Integer>> list) {
		String intAsString = "";
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				intAsString = Integer.toString(list.get(i).get(j)); //Converts Integer to String to print with correct spacing
				System.out.printf("%4s", intAsString); //Formats spacing
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//System.out.println("Test method 1:");
		//Tests method 1 with array
		int[][] myArray2 = {{10, 15, 30, 40},{15, 5, 8, 2}, {20, 2, 4, 2},{1, 4, 5, 0}};
		print2Darray(myArray2);
		
		//System.out.println("Test method 2:");
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
		
		print2DList(myArray);
	}
}
