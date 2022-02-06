package dp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class project01 {
	
	public static void print2Darray(int[][] array) {
		String intAsString = "";
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] == 0) {
					System.out.printf("%-10s", "*");
				} else {
					intAsString = Integer.toString(array[i][j]);
					System.out.printf("%-10s", intAsString);
				}
			}
			System.out.print("\n" + "\n" + "\n" + "\n");
		}
	}
	
	public static int[][] createRandomArray(){
		Random rand = new Random();
		int[][] buildArray = new int[4][4];
		int[] determineIf4 = new int[2];
		int[] location1 = new int[2];
		int[] location2 = new int[2];
		
		determineIf4[0] = rand.nextInt(4);
		determineIf4[1] = rand.nextInt(4);
		
		location1[0] = rand.nextInt(4);
		location1[1] = rand.nextInt(4);
		location2[0] = rand.nextInt(4);
		location2[1] = rand.nextInt(4);
		while ((location1[0] == location2[0]) && (location1[1] == location2[1])) {
			location2[0] = rand.nextInt(4);
			location2[1] = rand.nextInt(4);
		}
		
		if (determineIf4[0] == 0) {
			buildArray[location1[0]][location1[1]] = 4;
		} else {
			buildArray[location1[0]][location1[1]] = 2;
		}
		
		if (determineIf4[1] == 0) {
			buildArray[location2[0]][location2[1]] = 4;
		} else {
			buildArray[location2[0]][location2[1]] = 2;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if ((i != location1[0]) || (j != location1[1])) {
					if ((i != location2[0]) || (j != location2[1])) {
						buildArray[i][j] = 0;
					}
				}
			}
		}
		return buildArray;
	}
	
	public static boolean placeRandomNumber(int[][] array) {
		Random rand = new Random();
		boolean canPlaceNum = false;
		int[] locationOfNum = new int[2];
		int determineIf4 = rand.nextInt(4);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] == 0) {
					canPlaceNum = true;
				}
			}
		}
		
		if (canPlaceNum == true) {
			locationOfNum[0] = rand.nextInt(4);
			locationOfNum[1] = rand.nextInt(4);
			while (array[locationOfNum[0]][locationOfNum[1]] != 0) {
				locationOfNum[0] = rand.nextInt(4);
				locationOfNum[1] = rand.nextInt(4);
			}
			if (determineIf4 == 0) {
				array[locationOfNum[0]][locationOfNum[1]] = 4;
			} else {
				array[locationOfNum[0]][locationOfNum[1]] = 2;
			}
		}
		
		return canPlaceNum;
	}
	
	public static int[][] moveInDirection(String dir, int[][] array) {		
		int[][] compressedArray = new int[4][4];
		
		switch (dir) {
		case "a":
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					compressedArray[i][j] = 0;
					for (int k = j; k < 4; k++) {
						if (compressedArray[i][j] == 0) {
							compressedArray[i][j] += array[i][k];
							array[i][k] = 0;
						} else if (array[i][k] == 0) {
							compressedArray[i][j] += array[i][k];
						} else if (compressedArray[i][j] == array[i][k]) {
							compressedArray[i][j] += array[i][k];
							array[i][k] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			break;
		case "s":
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j >= 0; j--) {
					compressedArray[i][j] = 0;
					for (int k = j; k >= 0; k--) {
						if (compressedArray[j][i] == 0) {
							compressedArray[j][i] += array[k][i];
							array[k][i] = 0;
						} else if (array[k][i] == 0) {
							compressedArray[j][i] += array[k][i];
						} else if (compressedArray[j][i] == array[k][i]) {
							compressedArray[j][i] += array[k][i];
							array[k][i] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			break;
		case "d":
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j >= 0; j--) {
					compressedArray[i][j] = 0;
					for (int k = j; k >= 0; k--) {
						if (compressedArray[i][j] == 0) {
							compressedArray[i][j] += array[i][k];
							array[i][k] = 0;
						} else if (array[i][k] == 0) {
							compressedArray[i][j] += array[i][k];
						} else if (compressedArray[i][j] == array[i][k]) {
							compressedArray[i][j] += array[i][k];
							array[i][k] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			break;
		case "w":
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					compressedArray[i][j] = 0;
					for (int k = j; k < 4; k++) {
						if (compressedArray[j][i] == 0) {
							compressedArray[j][i] += array[k][i];
							array[k][i] = 0;
						} else if (array[k][i] == 0) {
							compressedArray[j][i] += array[k][i];
						} else if (compressedArray[j][i] == array[k][i]) {
							compressedArray[j][i] += array[k][i];
							array[k][i] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
		}
		
		return compressedArray;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] myArray = createRandomArray();
		print2Darray(myArray);
		System.out.println();
		
		while (true) {
			System.out.println("Enter a dir:");
			String userInput = scan.nextLine();
			myArray = moveInDirection(userInput, myArray);
			placeRandomNumber(myArray);
			print2Darray(myArray);
		}
	}

}
