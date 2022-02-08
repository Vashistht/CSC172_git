package dp;

import java.util.Random;
import java.util.Scanner;

public class project01 {
	private int numValidMoves = 0;
	private int[][] arrayBoard = new int[4][4];
	
	public int[][] getArrayBoard() {
		return arrayBoard;
	}
	
	public int getNumValidMoves() {
		return numValidMoves;
	}
	
	public static void print2Darray(int[][] array) {
		String intAsString = "";
		
		System.out.print(" ");
		for (int i = 0; i < 15; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			System.out.print("|");
			for (int j = 0; j < 4; j++) {
				if (j != 3) {
					if (array[i][j] == 0) {
						intAsString = "*";
					} else {
						intAsString = Integer.toString(array[i][j]);
					}
					System.out.printf("%-5s", intAsString);
				} else {
					if (array[i][j] == 0) {
						intAsString = "*";
					} else {
						intAsString = Integer.toString(array[i][j]);
					}
					System.out.print(intAsString);
				}
			}
			System.out.printf("%-5s", "|");
			System.out.println();
		}
		System.out.print(" ");
		for (int i = 0; i < 15; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public int[][] createRandomArray(){
		Random rand = new Random();
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
			arrayBoard[location1[0]][location1[1]] = 4;
		} else {
			arrayBoard[location1[0]][location1[1]] = 2;
		}
		
		if (determineIf4[1] == 0) {
			arrayBoard[location2[0]][location2[1]] = 4;
		} else {
			arrayBoard[location2[0]][location2[1]] = 2;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if ((i != location1[0]) || (j != location1[1])) {
					if ((i != location2[0]) || (j != location2[1])) {
						arrayBoard[i][j] = 0;
					}
				}
			}
		}
		return arrayBoard;
	}
	
	public boolean placeRandomNumber() {
		Random rand = new Random();
		boolean canPlaceNum = false;
		int[] locationOfNum = new int[2];
		int determineIf4 = rand.nextInt(4);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arrayBoard[i][j] == 0) {
					canPlaceNum = true;
				}
			}
		}
		
		if (canPlaceNum == true) {
			locationOfNum[0] = rand.nextInt(4);
			locationOfNum[1] = rand.nextInt(4);
			while (arrayBoard[locationOfNum[0]][locationOfNum[1]] != 0) {
				locationOfNum[0] = rand.nextInt(4);
				locationOfNum[1] = rand.nextInt(4);
			}
			if (determineIf4 == 0) {
				arrayBoard[locationOfNum[0]][locationOfNum[1]] = 4;
			} else {
				arrayBoard[locationOfNum[0]][locationOfNum[1]] = 2;
			}
		}
		
		return canPlaceNum;
	}
	
	public int[][] moveInDirection(String dir) {		
		int[][] compressedArray = new int[4][4];
		
		switch (dir) {
		case "a":
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					compressedArray[i][j] = 0;
					for (int k = j; k < 4; k++) {
						if (compressedArray[i][j] == 0) {
							compressedArray[i][j] += arrayBoard[i][k];
							arrayBoard[i][k] = 0;
						} else if (arrayBoard[i][k] == 0) {
							compressedArray[i][j] += arrayBoard[i][k];
						} else if (compressedArray[i][j] == arrayBoard[i][k]) {
							compressedArray[i][j] += arrayBoard[i][k];
							arrayBoard[i][k] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			numValidMoves += 1;
			break;
		case "s":
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j >= 0; j--) {
					compressedArray[j][i] = 0;
					for (int k = j; k >= 0; k--) {
						if (compressedArray[j][i] == 0) {
							compressedArray[j][i] += arrayBoard[k][i];
							arrayBoard[k][i] = 0;
						} else if (arrayBoard[k][i] == 0) {
							compressedArray[j][i] += arrayBoard[k][i];
						} else if (compressedArray[j][i] == arrayBoard[k][i]) {
							compressedArray[j][i] += arrayBoard[k][i];
							arrayBoard[k][i] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			numValidMoves += 1;
			break;
		case "d":
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j >= 0; j--) {
					compressedArray[i][j] = 0;
					for (int k = j; k >= 0; k--) {
						if (compressedArray[i][j] == 0) {
							compressedArray[i][j] += arrayBoard[i][k];
							arrayBoard[i][k] = 0;
						} else if (arrayBoard[i][k] == 0) {
							compressedArray[i][j] += arrayBoard[i][k];
						} else if (compressedArray[i][j] == arrayBoard[i][k]) {
							compressedArray[i][j] += arrayBoard[i][k];
							arrayBoard[i][k] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			numValidMoves += 1;
			break;
		case "w":
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					compressedArray[j][i] = 0;
					for (int k = j; k < 4; k++) {
						if (compressedArray[j][i] == 0) {
							compressedArray[j][i] += arrayBoard[k][i];
							arrayBoard[k][i] = 0;
						} else if (arrayBoard[k][i] == 0) {
							compressedArray[j][i] += arrayBoard[k][i];
						} else if (compressedArray[j][i] == arrayBoard[k][i]) {
							compressedArray[j][i] += arrayBoard[k][i];
							arrayBoard[k][i] = 0;
							break;
						} else {
							break;
						}
					}
				}
			}
			numValidMoves += 1;
			break;
		}
		//checkIfSameBoard(arrayBoard, compressedArray);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arrayBoard[i][j] = compressedArray[i][j];
			}
		}
		
		return arrayBoard;
	}
	
	public int getMaxElement() {
	    int max = 0;
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            if (arrayBoard[i][j] > max) {
	                max = arrayBoard[i][j];
	            }
	        }
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		project01 myGame = new project01();
		boolean continueGame = true;
		
		myGame.createRandomArray();
		print2Darray(myGame.getArrayBoard());
		System.out.println();
		
		while (continueGame == true) {
			System.out.println("Enter a dir:");
			String userInput = scan.nextLine();
			switch (userInput) {
			case ("r"):
				myGame.createRandomArray();
				print2Darray(myGame.getArrayBoard());
				break;
			case ("q"):
				System.out.println("You quit.");
				continueGame = false;
				break;
			case ("a"):
			case ("s"):
			case ("d"):
			case ("w"):
				myGame.moveInDirection(userInput);
				myGame.placeRandomNumber();
				print2Darray(myGame.getArrayBoard());
				System.out.print("Number of Valid Moves: ");
				System.out.println(myGame.getNumValidMoves());
				//System.out.print("Max Number:");
				//System.out.println(myGame.getMaxElement());
				break;
			default:
				System.out.println("Not a Valid Move.");
			}	
			if (myGame.getMaxElement() == 16 ) {
				System.out.println("You won!");
				continueGame = false;
			}
		}
	}

}
