//package dp;

import java.util.Scanner;

public class Lab2 {
	/*
	 * Lab2 is a class with methods to print an array and to get the max element of an array.
	 * 
	 * Author: Livia Betti
	 * Student ID: 31568890
	 * Partner: Vashisth Tiwari
	 * 
	 * printArrayNonGen is a method with an array of Objects as a parameter that prints the array.
	 * The printArray methods use method overloading to print the array (different methods depending on the type)
	 * printArrayGen is a method that uses generics to support each array type and print the array.
	 * getMax is a method that takes a Comparable type and returns the maximum element of the array.
	 * getMaxGen is a method which uses generics to support the array type and returns the maximum element of the array.
	 */
	
	public static void printArrayNonGen(Object[] objectArray) { //Takes in an array of objects
		for (int i = 0; i < objectArray.length; i++) {
			//Iterates through elements of the array and prints them
			System.out.print(objectArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(Integer[] intArray) { //Takes in an array of Integers
		for (int i = 0; i < intArray.length; i++) {
			//Iterates through elements of the array and prints them
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(Double[] doubArray) { //Takes in an array of objects
		for (int i = 0; i < doubArray.length; i++) {
			//Iterates through elements of the array and prints them
			System.out.print(doubArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(Character[] charArray) { //Takes in an array of characters
		for (int i = 0; i < charArray.length; i++) {
			//Iterates through elements of the array and prints them
			System.out.print(charArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(String[] strArray) { //Takes in an array of strings
		for (int i = 0; i < strArray.length; i++) {
			//Iterates through elements of the array and prints them
			System.out.print(strArray[i] + " ");
		}
		System.out.println();
	}
	
	public static <T> void printArrayGen(T[] genArray) { //Uses generics to support different types of arrays
		for (int i = 0; i < genArray.length; i++) {
			//Iterates through elements of the array and prints them
			System.out.print(genArray[i] + " ");
		}
		System.out.println();
	}
	
	public static Comparable getMax(Comparable[] compArray) { //Takes in array of a Comparable type
		Comparable max = compArray[0];
		for (int i = 0; i < compArray.length; i++) {
			if (compArray[i].compareTo(max) > 0) { //Checks if element is greater than max
				max = compArray[i];
			}
		}
		return max; //Returns max value
	}
	
	public static <T extends Comparable<T>> T getMaxGen(T[] genArray) { //Uses generics to support comparable types
		T max = genArray[0];
		for (int i = 0; i < genArray.length; i++) {
			if (genArray[i].compareTo(max) > 0) { //Checks if element is greater than max
				max = genArray[i];
			}
		}
		return max; //Returns max
	}
	
	public static void main(String[] args) {
		//Example arrays (Alex said we can just print test cases)
		Integer[] array1 = {1, 2, 3, 4, 5};
		Double[] array2 = {1.1, 2.2, 3.3, 4.4};
		Character[] array3 = {'H', 'E', 'L', 'L', 'O'};
		String[] array4 = {"once", "upon", "a", "time"};
		
		printArrayNonGen(array1);
		printArrayNonGen(array2);
		printArrayNonGen(array3);
		printArrayNonGen(array4);
		
		printArray(array1);
		printArray(array2);
		printArray(array3);
		printArray(array4);
		
		printArrayGen(array1);
		printArrayGen(array2);
		printArrayGen(array3);
		printArrayGen(array4);
		
		System.out.println(getMax(array1));
		System.out.println(getMax(array2));
		System.out.println(getMax(array3));
		System.out.println(getMax(array4));
		
		System.out.println(getMaxGen(array1));
		System.out.println(getMaxGen(array2));
		System.out.println(getMaxGen(array3));
		System.out.println(getMaxGen(array4));
	}

}
