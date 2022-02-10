//package dp;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import java.awt.Rectangle;


/*
This is the implementation of the 2048 game with graphics.
The keys to move in a direction correspond to the arrow keys in the keyboard.
The game ends when no more random numbers can be added or when the player has reached the score of 2048
 */
public class GraphicsClass extends JComponent implements KeyListener{
    private JPanel viewPanel = new JPanel();
    private JButton buttonArray[][] ;
    
    protected int numValidMoves = 0; // tracks the number of valid moves
	protected int[][] arrayBoard = new int[4][4]; // stores the 2d array to be displayed on the board
	protected int[][] tempArray = new int[4][4];
	protected boolean sameBoard; // tracks if the 2d array is the same as the other
	protected boolean continueGame = true; // the game continue if this boolean is true
	protected boolean gameOver = false;
	protected boolean gameRestarted = false;

	// Constructor for the GraphicsClass
	public GraphicsClass() {
		super();
		addKeyListener(this);
		setFocusable(true);
	}

	// the 2D array used to print the board
	public int[][] getArrayBoard() {
		return arrayBoard;
	}

	// int: keeps track of number of valid moves
	public int getNumValidMoves() {
		return numValidMoves;
	}

	// int: decreases valid moves by 1 (done when an action that is not a valid move is performed)
	public void decNumValidMoves() {
		numValidMoves -= 1;
	}

	/*
	print2Darray: takes in a 2D int array
	prints: the 2D array with non zero integers and * for 0
			along with a border marked by - and | to match the given formatting
	 */
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

	/*
	createRandomArray: returns 2D int array with
	add more
 	*/
	public int[][] createRandomArray(){
		Random rand = new Random();
		int[] determineIf4 = new int[2];
		int[] location1 = new int[2];
		int[] location2 = new int[2];
		
		determineIf4[0] = rand.nextInt(4);	 // creates a random int from 0 to 4
		determineIf4[1] = rand.nextInt(4);	// creates a random int from 0 to 4
		
		location1[0] = rand.nextInt(4);
		location1[1] = rand.nextInt(4);
		location2[0] = rand.nextInt(4);
		location2[1] = rand.nextInt(4);

		while ((location1[0] == location2[0]) && (location1[1] == location2[1])) {
			location2[0] = rand.nextInt(4);
			location2[1] = rand.nextInt(4);
		}

		// for location 1 if the random it is 0 (20 percent prob) add 4
		// else add a 2 to the random array
		if (determineIf4[0] == 0) {
			arrayBoard[location1[0]][location1[1]] = 4;
		} else {
			arrayBoard[location1[0]][location1[1]] = 2;
		}

		// for location2 if the random it is 0 (20 percent prob) add 4
		// else add a 2 to the random array
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

	/*
	placeRandomNumber: returns a boolean canPlaceNum
	false when we cannot add any more random numbers true when there is space to add random numbers
	 */
	public boolean placeRandomNumber() {
		Random rand = new Random();
		int[] locationOfNum = new int[2];
		int determineIf4 = rand.nextInt(4);
		boolean canPlaceNum = false;

		// if the (i, j) position is 0 means we can add random number 2 or 4
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arrayBoard[i][j] == 0) {
					canPlaceNum = true;
				}
			}
		}

		// adds the random number (2 and 4 with P = 80% and 20% respectively)
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

	/*
	moveInDirection: takes in a string dir correspond to direction
	returns 2D int arrayboard after the move
	- add more
	*/
	public int[][] moveInDirection(String dir) {		
		int[][] compressedArray = new int[4][4];
		sameBoard = true;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tempArray[i][j] = arrayBoard[i][j];
			}
		}
		
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


		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arrayBoard[i][j] = compressedArray[i][j];
			}
		}
		
		checkSameBoard();
		if (sameBoard == true) {
			decNumValidMoves();
		}
		return arrayBoard;
	}

	/*
	getMaxElement returns the maximum element in the (2d int array) arrayBoard
	 */
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
	
	public void resetTempArray() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tempArray[i][j] = arrayBoard[i][j];
			}
		}
	}
	
	public boolean checkSameBoard() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arrayBoard[i][j] != tempArray[i][j]) {
					sameBoard = false;
				}
			}
		}
		return sameBoard;
	}
	
	public void checkValidMove() {
		gameOver = true;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (arrayBoard[i][j] == arrayBoard[i][j+1]) {
					gameOver = false;
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (arrayBoard[i][j] == arrayBoard[i+1][j]) {
					gameOver = false;
				}
			}
		}
	}


	@Override
	public void paintComponent(Graphics g){
	    String intToString;
	    paintRectangles(g, arrayBoard);
	    
	    Graphics2D g2D = (Graphics2D) g;
	    g2D.setColor(Color.BLACK);
		g2D.setFont(new Font("Dialog", Font.BOLD, 15));
		g2D.drawString("Number of Valid Moves", 5, 430);
		intToString = Integer.toString(numValidMoves);
		g2D.drawString(intToString, 190, 430);
		
		if (gameOver == true) {
			g2D.setColor(Color.BLACK);
			g2D.setFont(new Font("Dialog", Font.BOLD, 15));
			g2D.drawString("You lose. Press r to restart", 5, 470);
		} else if (sameBoard == true) {
			g2D.setColor(Color.BLACK);
			g2D.setFont(new Font("Dialog", Font.BOLD, 15));
			g2D.drawString("Not a valid move.", 5, 470);
			sameBoard = false;
		}
		
		if (continueGame == false) {
			g2D.setColor(Color.BLACK);
			g2D.setFont(new Font("Dialog", Font.BOLD, 15));
			g2D.drawString("You quit. Press r to restart", 5, 470);
		}
		
		if (gameRestarted == true) {
			g2D.setColor(Color.BLACK);
			g2D.setFont(new Font("Dialog", Font.BOLD, 15));
			g2D.drawString("You restarted. Press r to restart", 5, 470);
			gameRestarted = false;
		}
    }

	/*
	- takes in a g, a Graphics object and 2d array
	- sets the colors and fonts of the rectangles used to show the 4 x 4 grid on the JFrame
	 */
    public void paintRectangles(Graphics g, int[][] array) {
    	RoundRectangle2D roundRect;
    	Graphics2D g2D = (Graphics2D) g;
    	String intToString;
    	
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			roundRect = new RoundRectangle2D.Double(5 + 100*j, 5+100*i, 95, 95, 10, 10);
    			switch (arrayBoard[i][j]) {
    			case 0:
    				g2D.setColor(new Color(243, 230, 212 ));
    				break;
    			case 2:
    				g2D.setColor(new Color(255, 247, 185));
    				break;
    			case 4:
    				g2D.setColor(new Color(255, 208, 128));
    				break;
    			case 8:
    				g2D.setColor(new Color(255, 125, 113));
    				break;
    			case 16:
    				g2D.setColor(new Color(153, 212, 255));
    				break;
    			case 32:
    				g2D.setColor(new Color(156, 234, 160));
    				break;
    			case 64:
    				g2D.setColor(new Color(197, 156, 234));
    				break;
    			case 128:
    				g2D.setColor(new Color(234, 156, 196 ));
    				break;
    			case 256:
    				g2D.setColor(new Color(213, 234, 156));
    				break;
    			case 512:
    				g2D.setColor(new Color(234, 156, 164));
    				break;
    			case 1024:
    				g2D.setColor(new Color(231, 228, 141 ));
    				break;
    			case 2048:
    				g2D.setColor(new Color(141, 231, 229 ));
    				break;
    			}
    			g2D.fill(roundRect);
    			g2D.setColor(Color.BLACK);
    			if (arrayBoard[i][j] != 0) {
    				g2D.setFont(new Font("Dialog", Font.BOLD, 20));
        			intToString = Integer.toString(arrayBoard[i][j]);
        			g2D.drawString(intToString, 5+100*j +45, 5+100*i +45);
    			}
    		}
    	}
    }


    @Override
    public void keyTyped(KeyEvent e){
//        System.out.println("You typed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e){
//        System.out.println("You released: " + e.getKeyChar());
    }


	/*
	- executes the move in moveinDirection method based of the keyboard arrow keys
	- if the board is the same as before, i.e, no valid move is made it prints "no valid move"
	- prints the key pressed by the user
	 */
    @Override
    public void keyPressed(KeyEvent e){
    	int keyCode = e.getKeyCode();
    	if ((continueGame == true) && (gameOver == false)) {
			switch (keyCode) {
			case KeyEvent.VK_UP :
				moveInDirection("w");
				if (placeRandomNumber() == false) {
					checkValidMove();
				}
				//System.out.print("Number of Valid Moves: ");
				//System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_DOWN :
				moveInDirection("s");
				if (placeRandomNumber() == false) {
					checkValidMove();
				}
				//System.out.print("Number of Valid Moves: ");
				//System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_LEFT :
				moveInDirection("a");
				if (placeRandomNumber() == false) {
					checkValidMove();
				}
				//System.out.print("Number of Valid Moves: ");
				//System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_RIGHT :
				moveInDirection("d");
				if (placeRandomNumber() == false) {
					checkValidMove();
				}
				//System.out.print("Number of Valid Moves: ");
				//System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_R:
				arrayBoard = createRandomArray();
				gameRestarted = true;
				numValidMoves = 0;
				sameBoard = false;
				gameOver = false;
				repaint();
				break;
			case KeyEvent.VK_Q:
				continueGame = false;
				repaint();
				break;
			}
    		} else if ((gameOver == true) || (continueGame == false)) {
    			repaint();
				if (keyCode == KeyEvent.VK_R) {
					continueGame = true;
					numValidMoves = 0;
					gameOver = false;
					sameBoard = false;
					arrayBoard = createRandomArray();
					repaint();
				}
		}
    	
        //System.out.println("You pressed: " + e.getKeyChar());
    }

    public static void main (String[] args){
    	JFrame myFrame = new JFrame();
        // JFrame setup
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("2048");
    	
    	GraphicsClass myGame = new GraphicsClass();
		myGame.createRandomArray();
		print2Darray(myGame.getArrayBoard());
		myFrame.add(myGame);
		myFrame.setSize(550, 600);
//		myFrame.setPreferredSize( new Dimension(400, 400) );
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

    }

}