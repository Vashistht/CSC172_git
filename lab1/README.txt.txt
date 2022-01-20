# CSC172- Lab 1
Lab-Partners: Vashisth Tiwari, Livia Betti
Email: vtiwari2@u.rochester.edu

## Description of the code

In this lab, we implement a main method that implements two methods: isAnangram and isRotation.

- isAnagram: a static class that returns a boolean
    - It takes in two strings and returns true or false for isAnagram
    - returns true if it is an anagram and false if it is not 

- isRotation: a static class that returns a boolean
    - It takes in two strings and returns true or false for isRotation
    - returns true if it is a rotation and false if it is not

The main functions asks for two strings (string 1 and string 2) from the user, and then prints if the two strings are anagrams and rotation or not.
It then asks you to continue the program or press "quit" to terminate the program.


## Compile and run steps
(1) cd into src folder
(2) javac Lab1.java
(3) java Lab1
(4) Enter string 1
(5) Enter string 2
Returns: whether the things are anagrams or rotations
(6) OPTIONAL: press quit to terminate the program


### Sample Output
Enter String 1: QweRty 
Enter String 2: QweRtY
QweRty and QweRtY are anagrams: false
QweRty and QweRtY are rotations: false
Press quit to quit, enter to continue: 

Enter String 1: qwe_123_omorw3
Enter String 2: 3123_owrmoq_we
qwe_123_omorw3 and 3123_owrmoq_we are anagrams: true
qwe_123_omorw3 and 3123_owrmoq_we are rotations: false
Press quit to quit, enter to continue: quit
