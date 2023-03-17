//package dp;

import java.util.ArrayList;
import java.util.Iterator;

public class Lab3Task3 {
	/*
	 * Lab 3 Task 1
	 * Author: Livia Betti
	 * Partner: Vashisth Tiwari
	 * Lab3Task3 - iterating ArrayList in different ways
	 */

	public static void printArrayListBasicLoop(ArrayList<Integer> al) { //Basic for loop
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
	
	public static void printArrayListEnhancedLoop(ArrayList<Integer> al) { //Enhanced for loop
		for (Integer integerEl : al) {
			System.out.println(integerEl); //Idea from https://memorynotfound.com/iterate-arraylist-java/
		}
	}
	
	public static void printArrayListForLoopListIterator(ArrayList<Integer> al) { //Basic for loop with iterator
		for (Iterator<Integer> it = al.iterator(); it.hasNext();) {
			System.out.println(it.next()); //Code from https://memorynotfound.com/iterate-arraylist-java/
		}
	}
	
	public static void printArrayListWhileLoopListIterator(ArrayList<Integer> al) { //Basic while loop with iterator
		Iterator<Integer> it = al.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()); //Code from https://memorynotfound.com/iterate-arraylist-java/
		}
	}
	
	public static void main(String[] args) {
		//Creates ArrayList to test methods
		ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
		
        printArrayListBasicLoop(a1);
        printArrayListEnhancedLoop(a1);
        printArrayListForLoopListIterator(a1);
        printArrayListWhileLoopListIterator(a1);
	}
}
