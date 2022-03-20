# CSC172- Project 2
Lab-Partners: Vashisth Tiwari, Livia Betti

Vashisth Tiwari:
Email: vtiwari2@u.rochester.edu
Student ID: 31564441
Net ID : vtiwari2

Livia Betti
Email: lbetti@u.rochester.edu
Student ID: 31568890
Net ID: lbetti

## Description of the code (HuffmanSubmit)
A program that allows the user to compress and decompress files using the  Huffman algorithm for encoding and decoding.

    - Node class
        - implements a node with character and corresponding frequency
        - Compareto: input node n, returns -1, 0, and 1 according to how the frequencies compare.
                    used to compare frequencies and organise using prirotity queues (ascending order)
        - isLeaf : checks if we have reached the end of the tree

    -  HuffmanSubmit: this class implements the Huffman interface given to us
        - createFreqFile
            - inputs: Name of inputFile, freqFile
            - FileWriter used to create the frequency file, writes on the file using BufferedWriter using ASCII codes
            - gets ASCII code of a given character and if the length of the code isn't 8 just adds on a 0 in the front
            - prints a warning if the frequency file could be written as exception handling

    - createHuffmanTree: merges small nodes till combined node (root) is generated, adds the combinednode to the priority queue

    - putCodesInHashEnc: (hashmap for encoder)
        - input: a Node node, and a String huffmanCode
        - adds in the huffmanCode in the hashmap that is huffmanCodesEnc
        - returns the modified hashmap

    - putCodesInHashDec: (hashmap for decoder)
        - input: a Node node, and a String huffmanCode
        - adds in the huffmanCode in the hashmap that is huffmanCodesEnc
        - returns the modified hashmap

    - buildFreq:
        - creates the frquency file with the format "character(in ASCII code)"  :  "frequency"

    - createHuffmanEnc: takes the frequency of a character and add to the priority queue and create the huffman tree using the createHuffmanTree method

    - createHuffmanDec: takes the frequency of a character and add to the priority queue and create the huffman tree using the createHuffmanTree method

    - createOutputEnc
        - input: Name of inputFile, output file
        - gets the huffman code for character c, pads onto the output file a false if huffmancode at index i is 0 and true if it is 1

    - traverseTree
        - input: binaryIn file and a node
        - a recursive function that returns the character in the leaf
        - if the boolean in the binary file is false (0), then returns traversetree for the left node
        and right for if true (1).

    - createOutputDec
        - input: Name of inputFile, output file
        - writes onto the output file the results of the traversetree function

    - encode: the encoder
        - input: Name of inputFile, output file, and for the frequency file
        - create the frequency file using createFreqFile function
        - takes the frequency of a character and add to the priority queue
        - return the hashmap for the huffman tree using the putCodesInHashEnc method
        - creates the output file for this process using the createOutputEnc method with the name provided by the user

    - decode: the decoder
        - input: Name of inputFile, output file, and for the frequency file
        - using the frequency file return the hashmap for the huffman tree using the putCodesInHashDec method
        - creates the output file using the createOutputDec method with the name provided by the user

    - main: calls the encode and the decode methods
        For each of the separate files you want to encode and decode you will have to change the names in the main method accordingly.
        -  huffman.encode( add the name of the file you want to compress, the name of the encoded output, name of frequency file)
        -  huffman.decode( the name of the encoded output, name of the file created after decoding, name of frequency file)


## Running the code
(1) cd src
(2) javac HuffmanSubmit.java
(3) java HuffmanSubmit

## Tests
Test results in the tests folder with screenshots
(1) tested the image ur.jpg - same output as expected
(2) tested the frequency of letter a in alice.txt using a script

## Extra credit: two frame animation for the tree. The tree was drawn for this screen so might not scale accordingly
- run the HuffmanGraphics File
(1) cd src
(2) javac HuffmanGraphics.java
(3) java HuffmanGraphics 