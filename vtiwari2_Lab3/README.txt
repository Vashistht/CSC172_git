
# CSC172- Lab 2
Lab-Partners: Vashisth Tiwari, Livia Betti
Email: vtiwari2@u.rochester.edu
Student ID: 31564441
Net ID : vtiwari2

## Description of the code

- Lab3Task1 class
	- print2Darray method: takes in a 2D array and prints the formatted 2D array 
	- print2DList method: takes in a 2D arrayList and prints a formatted arrayLit

- Lab3Task2 class
	- runningSum2DArray: a 4x4 two dimensional int array and an integer (1, 2, 3 or 4 for left, right, up, down respectively).  
			returns: The modified array after producing the running sums according to the direction.

	- runningSum2DArrayList: a 4x4 two dimensional int arrayList and an integer (1, 2, 3 or 4 for left, right, up, down respectively).  
			returns: The modified arrayList after producing the running sums according to the direction.

- Lab3Task3 class
	- printArrayListBasicLoop: takes in 1D integer arrayList 
				prints the arrayList using basic for loop

	- printArrayListEnhancedLoop: takes in 1D integer arrayList 
				prints the arrayList using enhanced loop 

	- printArrayListForLoopListIterator: takes in 1D integer arrayList 
				prints the arrayList using basic for loop with iterator

	- printArrayListWhileLoopListIterator: takes in 1D integer arrayList 
				prints the arrayList using basic while loop with iterator

- Main class
	(Alex said we want to print the running some of the original array and not running sum after each direction, so I first made cloning functions so that we do not change the content of the original array)

	- cloneArray: takes in an integer array; returns a copy of the integer array
    we make this function so as to not change the contents of the orginal array
	
	- cloneArrayList: takes in an integer ArrayList; returns a copy of the integer ArrayList
    we make this function so as to not change the contents of the orginal ArrayList

	- main: first we initialize the given 2 D (4x4) array in the document description.
		using this we create the arrayList from the array
		
	TESTS

	(1) Tests task 1:
		- tests for the print2Darray and print2DList methods to see if they print the array and the arrayList initialized within the main class.
	
	(2) Tests task 2
		- creates the clone of the original array (new instance) using cloneArray method and then returns the running some in the given direction in accordance with the runningSum2DArray function. We do the same for all the four directions corresponding to 1, 2, 3, 4. Note that the running sum is given in reference to the original array.

		- creates the clone of the original arrayList (new instance) using cloneArrayList method and then returns the running some in the given direction in accordance with the runningSum2DArray function. We do the same for all the four directions corresponding to 1, 2, 3, 4. Note that the running sum is given in reference to the original arrayList.
	
	(3) Tests task 3
		- creates a sample arrayList with elements 1, 2, 3 to test the methods from Lab3Task3 class.
		- Then we print the arrayList using the four different methods printArrayListBasicLoop, printArrayListEnhancedLoop, printArrayListForLoopListIterator, and printArrayListWhileLoopListIterator


## Running the code

(1) cd src
(2) javac Main.java
(3) java Main

## tests
	(1) Lab3Task1.ans tests the print functions (for array and arrayList) and has the outputs from Lab3Task1 class.
	(2) Lab3Task2.ans tests the runningsum functions (for array and arrayList) and has the outputs from Lab3Task2 class.
	(3) Lab3Task3.ans tests the print functions for arrayList using different methods and has the outputs from Lab3Task3 class.

