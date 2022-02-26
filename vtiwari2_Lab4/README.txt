# CSC172- Lab 2
Lab-Partners: Vashisth Tiwari, Livia Betti

Vashisth Tiwari:
Email: vtiwari2@u.rochester.edu
Student ID: 31564441
Net ID : vtiwari2

Livia Betti
Email: lbetti@u.rochester.edu
Student ID: 31568890
Net ID: lbetti

## Description of the code

- List Class (code from Zhupa's Lecture)
	-List interface which is implemented in LList
	-Methods for list declared (without initialization)

- LList Class (code from Zhupa's Lecture-edited)
	-Declaration of variables for linked list (head, tail, cnt) with variables for link (element, next)
	-Also has methods:
		-clipList: clips the selected sequence at starting and ending index; replaces the old sequence with the new sequence, and returns the new sequence at the desired position
		-copyList: copies the sequence at the position, and returns the head of new linked list copy
		-transcribeList: transcribes sequence in required order
		-reverseList: reverses list (code from geeksforgeeks.com)
		-deleteList: deletes list
		-checkIfRNA: returns true if RNA
		-checkIfDNA: returns true if DNA
-DNAList Class
	-Has enumerated types for type of DNA and for the status of a spot in the sequence array (empty, or filled)
	-Creates new LList (which contains individual sequences) and array (for the sequence array)
	-Imports scanner to read file
	-Reads file, using string commands to separate arguments on a line
	-Conditional statements determine which action is performed
	
		
Tests Performed:

	The tests are run on the following methods;
		insert pos DNA/RNA sequence
		remove pos
		clip pos start end
		copy pos1 pos2
		print

	-command.txt (Professor Zhupa's input); returns desired output (except for error Professor Zhupa had in one line)
	-Lab4Test_Alex.txt; returns desires output


## Running the code

(1) cd src
(2) javac DNAList.java
(3) java DNAList