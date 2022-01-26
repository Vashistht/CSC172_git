// package dp;

public class Lab2 {
	
	public static void printArrayNonGen(Object[] objectArray) {
		for (int i = 0; i < objectArray.length; i++) {
			System.out.print(objectArray[i] + " ");
		}
	}
	
	public static void printArray(Integer[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
	}
	
	public static void printArray(Double[] doubArray) {
		for (int i = 0; i < doubArray.length; i++) {
			System.out.print(doubArray[i] + " ");
		}
	}
	
	public static void printArray(Character[] charArray) {
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i] + " ");
		}
	}
	
	public static void printArray(String[] strArray) {
		for (int i = 0; i < strArray.length; i++) {
			System.out.print(strArray[i] + " ");
		}
	}
	
	public static <T> void printArrayGen(T[] genArray) {
		for (int i = 0; i < genArray.length; i++) {
			System.out.print(genArray[i] + " ");
		}
	}
	
	public static Comparable getMax(Comparable[] compArray) {
		Comparable temp = compArray[0];
		for (int i = 0; i < compArray.length; i++) {
			if (compArray[i].compareTo(temp) > 0) {
				temp = compArray[i];
			}
		}
		return temp;
	}
	
	public static <T extends Comparable<T>> T getMaxGen(T[] genArray) {
		T temp = genArray[0];
		for (int i = 0; i < genArray.length; i++) {
			if (genArray[i].compareTo(temp) > 0) {
				temp = genArray[i];
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Double[] myArray = {7.3, 6.1, -88.1, -8.2, 4.3, 7.5};
		
		printArrayGen(myArray);
		System.out.println();
		System.out.println(getMaxGen(myArray));
	}

}
