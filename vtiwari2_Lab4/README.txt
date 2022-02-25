- Okay so output on lines 14 and 17 are different.
- Zhupa's Line 14 is wrong
    because for start index less than 0, “Start index is out of bounds” for start beyond end of sequence,
    in this case the print pos is 0 so it cannot be “Start index is out of bounds”
    It has to be Invalid start index

- Line 17 he is not printing anything after 1. checked with ta and the sequence is correct in the output

Compile Instructions
(1) cd src
(2) javac *.java
(3) java DNAList 20 command.txt

Input
Lab4Test_Alex.txt or command.txt

Output (Agrees with the output Lab TA Alex sent)

Error occurred while inserting
Error occurred while inserting
0	DNA	AATTCCGGAATTCCGG
2	RNA	UAGACAUGGAUU
4	DNA	AATTCCGGAATTCCGG
No sequence to remove at specified position
0	DNA	AATTCCGGAATTCCGG
2	RNA	UAGACAUGGAUU
DNA	AATTCCGGAATTCCGG
RNA	UAGACAUGGAUU
No sequence to print at specified position
DNA	AATTCCGG
End index out of bounds
Invalid start index
No sequence to clip at specified position
Start index out of bounds
0	DNA	AATTCCGG
1	DNA	TACAGACAT
2	RNA	UAGACAUGGAUU
No sequence to copy at specified position
0	DNA	AATTCCGG
1	DNA	AATTCCGG
2	RNA	UAGACAUGGAUU
Cannot Transcribe RNA
No sequence to transcribe at specified position
RNA	CCGGAAUU