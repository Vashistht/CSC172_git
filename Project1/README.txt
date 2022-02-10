Project 01
Lab Partners: Livia Betti (lbetti), Vashisth Tiwari (vtiwari2)
Livia Betti:
Student ID: 31568890
Email: lbetti@u.rochester.edu

Vashisth Tiwari:
Student ID:31564441
Email: vtiwari2@u.rochester.edu

This is the read me file for the 2048 game. The logic of our 2048 code is as follows:


Note: Empty spaces in the JFrame correspond to 0 on the 2d arrayBoard
    1. First display the board with two random numbers (2 or 4 with 80 and 20 percent probability respectively) using the createRandomArray method
    2. User inputs a direction using the arrow keys
    3. moveInDirection will make the move where there is the same element adjacent (i, j+1) to the i, j element
       or when there is no non-zero element between the two same integers.
        - This move is stored in compressedArray which is local to the moveInDirection method.
        - Using the checkSameBoard check if the array board before the move was made the same as the compressedArray
            (i) if checkSameBoard is true that means no valid move was made
                - place random number if 0s are available
                - if no space is available, check the game checkValidMove to see if there are same numbers left that can be joined together
                - if both of these conditions are not filled that means the game is over.
                - print the high score, and the dialogue box to press r to reset
            (ii) if false then increment the number of valid moves by 1
                - repaint the JFrame using new arrayboard where the numbers have been combined


Description of methods used in the TwentyFourtyEight class
   - createRandomArray: returns 2D int array with the random 2 and/ or 4 and 0s
   - moveInDirection: takes in a string dir correspond to direction
         - returns the array board after the move.
         - The move is made in say a direction when there is the same element adjacent (i, j+1) to the i, j element
         or when there is no non-zero element between the two same integers
   - getMaxElement returns the maximum element in the (2d int array) arrayBoard
   - checkSameBoard: boolean to see if the two 2D arrays (tempArray and boardArray) are the same
         - done by going through all the 16 elements and their corresponding location
   - paintComponent: we set up the strings to be displayed in the JFrame depending on the boolean values of game over, sameBoard ( for valid moves)
   quit, and restarting the board
   - paintRectangles: takes in the 2D array, sets the background color if the entries are 0
                      sets the colors for 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, and 2048.
                      
The graphics of the board (rectangles, using colors, printing text) was done as an additional feature.



Compile steps
- javac TwentyFourtyEight.java && java TwentyFourtyEight.java

