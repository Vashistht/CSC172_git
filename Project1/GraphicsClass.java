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


public class GraphicsClass extends JComponent implements KeyListener{
    private JPanel viewPanel = new JPanel();
    private JButton buttonArray[][] ;
    
    protected int numValidMoves = 0;
	protected int[][] arrayBoard = new int[4][4];
	protected int[][] tempArray = new int[4][4];
	protected boolean sameBoard;
	protected boolean continueGame = true;
	
	public GraphicsClass() {
		super();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public int[][] getArrayBoard() {
		return arrayBoard;
	}
	
	public int getNumValidMoves() {
		return numValidMoves;
	}
	
	public void decNumValidMoves() {
		numValidMoves -= 1;
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
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arrayBoard[i][j] != tempArray[i][j]) {
					sameBoard = false;
				}
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

	@Override
	public void paintComponent(Graphics g){
	    paintRectangles(g, arrayBoard);
    }
    
    public void paintRectangles(Graphics g, int[][] array) {
    	RoundRectangle2D roundRect;
    	Graphics2D g2D = (Graphics2D) g;
    	String intToString;
    	
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			roundRect = new RoundRectangle2D.Double(5 + 100*j, 5+100*i, 95, 95, 10, 10);
    			switch (arrayBoard[i][j]) {
    			case 2:
    				g2D.setColor(Color.LIGHT_GRAY);
    				break;
    			case 4:
    				g2D.setColor(Color.pink);
    				break;
    			case 8:
    				g2D.setColor(Color.GREEN);
    				break;
    			default:
    				g2D.setColor(Color.WHITE);
    			}
    			g2D.fill(roundRect);
    			g2D.setColor(Color.BLACK);
    			g2D.setFont(new Font("Dialog", Font.BOLD, 40));
    			intToString = Integer.toString(arrayBoard[i][j]);
    			g2D.drawString(intToString, 5+100*j +45, 5+100*i +45);
    		}
    	}
    }


    @Override
    public void keyTyped(KeyEvent e){
        System.out.println("You typed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e){
        System.out.println("You released: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e){
    	int keyCode = e.getKeyCode();
    	if (continueGame == true) {
			switch (keyCode) {
			case KeyEvent.VK_UP :
				moveInDirection("w");
				if (sameBoard == true) {
					decNumValidMoves();
					System.out.println("Not a valid move.");
				} else {
					placeRandomNumber();
				}
				System.out.print("Number of Valid Moves: ");
				System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_DOWN :
				moveInDirection("s");
				if (sameBoard == true) {
					decNumValidMoves();
					System.out.println("Not a valid move.");
				} else {
					placeRandomNumber();
				}
				System.out.print("Number of Valid Moves: ");
				System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_LEFT :
				moveInDirection("a");
				if (sameBoard == true) {
					decNumValidMoves();
					System.out.println("Not a valid move.");
				} else {
					placeRandomNumber();
				}
				System.out.print("Number of Valid Moves: ");
				System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_RIGHT :
				moveInDirection("d");
				if (sameBoard == true) {
					decNumValidMoves();
					System.out.println("Not a valid move.");
				} else {
					placeRandomNumber();
				}
				System.out.print("Number of Valid Moves: ");
				System.out.println(getNumValidMoves());
				repaint();
				break;
			case KeyEvent.VK_R:
				arrayBoard = createRandomArray();
				repaint();
				break;
			case KeyEvent.VK_Q:
				continueGame = false;
				break;
			}
		}
    	
        System.out.println("You pressed: " + e.getKeyChar());
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
		myFrame.setSize(400,400);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

    }

}
