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
public class TwentyFourtyEight extends JComponent implements KeyListener{
    protected int numValidMoves = 0; // tracks the number of valid moves
    protected int[][] arrayBoard = new int[4][4]; // stores the 2d array to be displayed on the board
    protected int[][] tempArray = new int[4][4];
    protected boolean sameBoard; // tracks if the 2d array is the same as the other
    protected boolean continueGame = true; // the game continue if this boolean is true
    protected boolean gameOver = false; //checks if there are no moves left
    protected boolean gameRestarted = false; //checks if user pressed restart
    protected int countRestart = 0; //Counts when user presses restart to ask for confirmation
    protected int countQuit = 0; //Counts when user presses quit to ask for confirmation

    // Constructor for the TwentyFourtyEight
    public TwentyFourtyEight() {
        super();
        addKeyListener(this); //Adds key listener
        setFocusable(true);
    }

    // the 2D array used to print the board
    public int[][] getArrayBoard() {
        return arrayBoard;
    }

    // returns int: returns of number of valid moves
    public int getNumValidMoves() {
        return numValidMoves;
    }

    // decreases valid moves by 1 (done when an action that is not a valid move is performed)
    public void decNumValidMoves() {
        numValidMoves -= 1;
    }

    /*
    print2Darray: takes in a 2D int array
    prints: the 2D array with non zero integers and * for 0
            along with a border marked by - and | to match the given formatting
    Note: this was used in our initial stages when we didn't have a graphical interface
     */
    public static void print2Darray(int[][] array) {
        String intAsString = "";

        System.out.print(" ");
        for (int i = 0; i < 15; i++) {
            System.out.print("-"); //prints boarder
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.print("|"); //prints boarder
            for (int j = 0; j < 4; j++) {
                if (j != 3) {
                    if (array[i][j] == 0) {
                        intAsString = "*";
                    } else {
                        intAsString = Integer.toString(array[i][j]);
                    }
                    System.out.printf("%-5s", intAsString); //Spaces correctly
                } else {
                    if (array[i][j] == 0) {
                        intAsString = "*"; //Places star instead of 0
                    } else {
                        intAsString = Integer.toString(array[i][j]);
                    }
                    System.out.print(intAsString);
                }
            }
            System.out.printf("%-5s", "|"); //Prints boarder
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < 15; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /*
        createRandomArray: returns 2D int array with the random 2 and or 4 and 0s
     */
    public int[][] createRandomArray(){
        Random rand = new Random();
        int[] determineIf4 = new int[2]; //Array to determine if 4 is in location 1 or 2
        int[] location1 = new int[2]; //Array of coordinates for location 1
        int[] location2 = new int[2]; //Array of coordinates for location 2

        determineIf4[0] = rand.nextInt(4);	 // creates a random int from 0 to 4
        determineIf4[1] = rand.nextInt(4);	// creates a random int from 0 to 4

        //Randomizes coordinates of locations
        location1[0] = rand.nextInt(4);
        location1[1] = rand.nextInt(4);
        location2[0] = rand.nextInt(4);
        location2[1] = rand.nextInt(4);

        //Makes sure coordinates are not the same
        while ((location1[0] == location2[0]) && (location1[1] == location2[1])) {
            location2[0] = rand.nextInt(4);
            location2[1] = rand.nextInt(4);
        }

        // for location 1 if the random it is 0 (20 percent probability) add 4
        // else add a 2 to the random array
        if (determineIf4[0] == 0) {
            arrayBoard[location1[0]][location1[1]] = 4;
        } else {
            arrayBoard[location1[0]][location1[1]] = 2;
        }

        // for location2 if the random it is 0 (20 percent probability) add 4
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
                        arrayBoard[i][j] = 0; //Sets the array board to 0 at places other than location 1 and 2
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
        int[] locationOfNum = new int[2]; //Location of random number
        int determineIf4 = rand.nextInt(4); //Determines if random number is 4
        boolean canPlaceNum = false;

        // if the (i, j) position is 0 means we can add random number 2 or 4
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrayBoard[i][j] == 0) {
                    canPlaceNum = true; //Checks if there exists a 0
                }
            }
        }

        // adds the random number (2 and 4 with P = 80% and 20% respectively)
        if (canPlaceNum == true) {
            locationOfNum[0] = rand.nextInt(4);
            locationOfNum[1] = rand.nextInt(4);

            //To make sure the random number is being place in an empty space
            while (arrayBoard[locationOfNum[0]][locationOfNum[1]] != 0) {
                locationOfNum[0] = rand.nextInt(4);
                locationOfNum[1] = rand.nextInt(4);
            }
            //Places 4 with probability 0.2, otherwise places 2.
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
    - returns the arrayboard after the move.
        - The move is made in say a direction when there is the same element adjacent (i, j+1) to the i, j element
        or when there is no non zero element between the two same integers
    */
    public int[][] moveInDirection(String dir) {
        int[][] compressedArray = new int[4][4]; //Array of summed elements
        sameBoard = true;

        //Stores copy of arrayBoard in tempArray
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tempArray[i][j] = arrayBoard[i][j];
            }
        }

        //Uses keys a,s,d,w to determine direction
        switch (dir) {
            case "a": // moving left
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        compressedArray[i][j] = 0;
                        for (int k = j; k < 4; k++) {
                            if (compressedArray[i][j] == 0) { //Adds next arrayBoard element
                                compressedArray[i][j] += arrayBoard[i][k];
                                arrayBoard[i][k] = 0;
                            } else if (arrayBoard[i][k] == 0) {
                                compressedArray[i][j] += arrayBoard[i][k];
                            } else if (compressedArray[i][j] == arrayBoard[i][k]) { //If arrayBoard element is next to same number, adds to compressedArray
                                compressedArray[i][j] += arrayBoard[i][k];
                                arrayBoard[i][k] = 0;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                numValidMoves += 1; //Increases numValidMoves
                break;
            case "s":	// moving right
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j >= 0; j--) {
                        compressedArray[j][i] = 0;
                        for (int k = j; k >= 0; k--) {
                            if (compressedArray[j][i] == 0) { //Adds next arrayBoard element
                                compressedArray[j][i] += arrayBoard[k][i];
                                arrayBoard[k][i] = 0;
                            } else if (arrayBoard[k][i] == 0) {
                                compressedArray[j][i] += arrayBoard[k][i];
                            } else if (compressedArray[j][i] == arrayBoard[k][i]) { //If arrayBoard element is next to same number, adds to compressedArray
                                compressedArray[j][i] += arrayBoard[k][i];
                                arrayBoard[k][i] = 0;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                numValidMoves += 1; //Increases numValidMoves
                break;
            case "d":	// moving right
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j >= 0; j--) {
                        compressedArray[i][j] = 0;
                        for (int k = j; k >= 0; k--) {
                            if (compressedArray[i][j] == 0) {
                                compressedArray[i][j] += arrayBoard[i][k];
                                arrayBoard[i][k] = 0;
                            } else if (arrayBoard[i][k] == 0) {
                                compressedArray[i][j] += arrayBoard[i][k];
                            } else if (compressedArray[i][j] == arrayBoard[i][k]) { //If arrayBoard element is next to same number, adds to compressedArray
                                compressedArray[i][j] += arrayBoard[i][k];
                                arrayBoard[i][k] = 0;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                numValidMoves += 1; //Increases numValidMoves
                break;
            case "w":	// moving up
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        compressedArray[j][i] = 0;
                        for (int k = j; k < 4; k++) {
                            if (compressedArray[j][i] == 0) {
                                compressedArray[j][i] += arrayBoard[k][i];
                                arrayBoard[k][i] = 0;
                            } else if (arrayBoard[k][i] == 0) {
                                compressedArray[j][i] += arrayBoard[k][i];
                            } else if (compressedArray[j][i] == arrayBoard[k][i]) { //If arrayBoard element is next to same number, adds to compressedArray
                                compressedArray[j][i] += arrayBoard[k][i];
                                arrayBoard[k][i] = 0;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                numValidMoves += 1; //Increases numValidMOves
                break;
        }

        //Sets arrayBoard to compressedArray
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrayBoard[i][j] = compressedArray[i][j];
            }
        }

        //Checks if same board to make sure valid move
        checkSameBoard();
        if (sameBoard == true) {
            decNumValidMoves();	//  if the values between the new and the old move are the same then it is not a valid move
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
                    max = arrayBoard[i][j]; //Max element found in arrayBoard
                }
            }
        }
        return max;
    }

    /*
     * resetTempArray() - Resets tempArray to be the same as arrayBoard (to store a copy)
     */
    public void resetTempArray() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tempArray[i][j] = arrayBoard[i][j];
            }
        }
    }

    /*
     * checkSameBoard() - returns true if the same board results after moving in some direction
     boolean to see if the two 2D arrays (temparray and boardArray) are the same
     done by going through all the 16 elements and their corresponding location
     */
    public boolean checkSameBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrayBoard[i][j] != tempArray[i][j]) {
                    sameBoard = false; //If there is a difference between arrayBoard and tempArray, sameBoard is false
                }
            }
        }
        return sameBoard;
    }

    /*
     *checkValidMove - checks if valid move changes gameOver to true if there are no valid moves remaining.
     * this is called when there are no empty spots on the board
     */
    public void checkValidMove() {
        gameOver = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrayBoard[i][j] == 0) { //Goes through columns to see if there are 0's
                    gameOver = false; //if two of the same element are adjacent, the game is not over
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrayBoard[i][j] == arrayBoard[i][j+1]) { //Goes through columns to see if there are adjacent elements which are the same
                    gameOver = false; //if two of the same element are adjacent, the game is not over
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrayBoard[i][j] == arrayBoard[i+1][j]) {//Goes through rows to see if there are adjacent elements which are the same
                    gameOver = false; //if two of the same element are adjacent, the game is not over
                }
            }
        }
    }

    /*
        in paintComponent, we set up the JFrame depending on the boolean values of game over, sameBoard ( for valid moves)
        quit, and reseting the board
         */
    @Override
    public void paintComponent(Graphics g){
        String intToString;
        paintRectangles(g, arrayBoard);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setFont(new Font("Dialog", Font.BOLD, 15));

        //Prints number of valid moves
        g2D.drawString("Number of Valid Moves", 5, 430);
        intToString = Integer.toString(numValidMoves);
        g2D.drawString(intToString, 190, 430);

        //Prints maxElement
        intToString = Integer.toString(getMaxElement());
        g2D.drawString("Max element:", 5, 470);
        g2D.drawString(intToString, 110, 470);
        
        checkValidMove();

        //Asks for confirmation for restart
        if (countRestart == 1) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("Are you sure you want to restart? Press r to restart.", 5, 520);
        }

        //Asks for confirmation for quit
        if (countQuit == 1) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("Are you sure you want to quit? Press q to quit.", 5, 520);
        }

        //If game over (no valid moves) then prints you lose
        if (gameOver == true) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("You lose. Press r to restart.", 5, 520);
        } else if (sameBoard == true) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("Not a valid move.", 5, 520);
            sameBoard = false;
        }

        //If use quit, prints you quit
        if (continueGame == false) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("You quit. Press r to restart", 5, 520);
        }

        //If user restarted, prints you restarted
        if (gameRestarted == true) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("You restarted.", 5, 520);
            gameRestarted = false;
        }

        //If the user reached 2048, prints you win
        if (getMaxElement() == 2048) {
            g2D.setColor(Color.BLACK);
            g2D.setFont(new Font("Dialog", Font.BOLD, 15));
            g2D.drawString("You win! Press r to play again.", 5, 520);
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

        //Paints rectangles on array board
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                roundRect = new RoundRectangle2D.Double(5 + 100*j, 5+100*i, 95, 95, 10, 10); //Creates rectangles at appropriate location
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

                //Prints numbers on rectangles
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

        //Checks conditions to continue reading user key input
        if ((continueGame == true) && (gameOver == false) && (getMaxElement() != 2048)) {
            switch (keyCode) {
                case KeyEvent.VK_UP :
                    //Resets quit and restart counts
                    countQuit = 0;
                    countRestart = 0;
                    moveInDirection("w");
                    //Makes sure move is valid before placing random number by checking if sameBoard is true
                    if (sameBoard != true) {
                        if (placeRandomNumber() == false) {
                            checkValidMove();
                        }
                    }
                    //System.out.print("Number of Valid Moves: ");
                    //System.out.println(getNumValidMoves());
                    repaint();
                    System.out.println("You pressed: UP" );
                    break;
                case KeyEvent.VK_DOWN :
                    countQuit = 0;
                    countRestart = 0;
                    moveInDirection("s");
                    //Makes sure move is valid before placing random number by checking if sameBoard is true
                    if (sameBoard != true) {
                        if (placeRandomNumber() == false) {
                            checkValidMove();
                        }
                    }
                    //System.out.print("Number of Valid Moves: ");
                    //System.out.println(getNumValidMoves());
                    repaint();
                    System.out.println("You pressed: DOWN" );
                    break;
                case KeyEvent.VK_LEFT :
                    countQuit = 0;
                    countRestart = 0;
                    moveInDirection("a");
                    //Makes sure move is valid before placing random number by checking if sameBoard is true
                    if (sameBoard != true) {
                        if (placeRandomNumber() == false) {
                            checkValidMove();
                        }
                    }
                    //System.out.print("Number of Valid Moves: ");
                    //System.out.println(getNumValidMoves());
                    repaint();
                    System.out.println("You pressed: LEFT" );
                    break;
                case KeyEvent.VK_RIGHT :
                    countQuit = 0;
                    countRestart = 0;
                    moveInDirection("d");
                    //Makes sure move is valid before placing random number by checking if sameBoard is true
                    if (sameBoard != true) {
                        if (placeRandomNumber() == false) {
                            checkValidMove();
                        }
                    }
                    //System.out.print("Number of Valid Moves: ");
                    //System.out.println(getNumValidMoves());
                    repaint();
                    System.out.println("You pressed: RIGHT" );
                    break;
                case KeyEvent.VK_R:
                    if (countRestart == 0) {
                        //Increases counter so when repainted will ask for confirmation
                        countRestart += 1;
                        repaint();
                    } else {
                        //Resets global variables
                        arrayBoard = createRandomArray();
                        gameRestarted = true;
                        numValidMoves = 0;
                        sameBoard = false;
                        gameOver = false;
                        countRestart = 0;
                        repaint();
                    }
                    System.out.println("You pressed: r" );
                    break;
                case KeyEvent.VK_Q:
                    if (countQuit == 0) {
                        //Increases counter so when repainted will ask for confirmation
                        countQuit += 1;
                        repaint();
                    } else {
                        continueGame = false;
                        countQuit = 0;
                        repaint();
                    }
                    System.out.println("You pressed: q" );
                    break;
            }
        } else if ((gameOver == true) || (continueGame == false) || (getMaxElement() == 2048)) {
            //Checks if user restarts after they quit, lose, or win
            repaint();
            if (keyCode == KeyEvent.VK_R) {
                //Resets global variables
                continueGame = true;
                numValidMoves = 0;
                gameOver = false;
                sameBoard = false;
                arrayBoard = createRandomArray();
                repaint();
                System.out.println("You pressed: r" );
            }
        }
    }

    public static void main (String[] args){
        JFrame myFrame = new JFrame();
        // JFrame setup
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("2048");

        TwentyFourtyEight myGame = new TwentyFourtyEight();
        myGame.createRandomArray();
        //(myGame.getArrayBoard());
        myFrame.add(myGame);
        myFrame.setSize(500, 600);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

    }

}