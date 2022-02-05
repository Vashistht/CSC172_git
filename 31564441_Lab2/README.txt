
# CSC172- Lab 2
Lab-Partners: Vashisth Tiwari, Livia Betti
Email: vtiwari2@u.rochester.edu
Student ID: 31564441

## Description of the code

Lab 2 is a class with methods to print an array and get the max element of the array.

- printArrayNonGen is a method with an array of Objects as a parameter that prints the array

- printArray method use method overloading to print the array (with overloading for each type)
	- there is a printArray method that takes in Integer array.
	- there is a printArray method that takes in Double array.
	- there is a printArray method that takes in Character array.
	- there is a printArray method that takes in String array.

- printArrayGen is a method with an array that uses generics to print the array regardless of the type.

- getMax is a method that takes in a Comparable object type and returns the maximum element of the array

- getMax is a method that uses generics to support different array types and returns the maximum element of the array

- the main method declares the 4 arrays of different kinds as given in the sample output document. These can be changed by the user in case they want to print and compare some other array of these four given types. 
Then the main methods prints the arrays of different kinds using print array, the generic and the non generic methods and prints the maximum element using the generic and non generic method.


## Compile and run steps

(1) cd src
(2) javac Lab2.java
(3) java Lab2

## Output 

Printing nonGen:
H E L L O  
1 2 3 4 5  
once upon a time  
1.1 2.2 3.3 4.4  
 
Printing Type Specific:
H E L L O  
1 2 3 4 5  
once upon a time  
1.1 2.2 3.3 4.4  
 
Printing Generic:
H E L L O  
1 2 3 4 5  
once upon a time  
1.1 2.2 3.3 4.4  
 
Printing getMax (not generic):
O
5
upon
4.4
 
Printing getMax (generic):
O
5
upon
4.4


