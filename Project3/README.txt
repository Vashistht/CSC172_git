# CSC172- Project 3
Lab-Partners: Vashisth Tiwari, Livia Betti

Vashisth Tiwari:
Email: vtiwari2@u.rochester.edu
Student ID: 31564441
Net ID : vtiwari2

Livia Betti
Email: lbetti@u.rochester.edu
Student ID: 31568890
Net ID: lbetti

## Description of the code (StopContagion)
A program that allows the user to dismantle a network given the collection influence for a given radius, degree of some node.

StopContagion
    - Graph type that stores the number of nodes and the adjacency matrix representation
    - addEdge takes integers i, j as its argument and adds an (undirected) edge between them 
    - removeEdge takes integers i, j as its argument and removes an edge between them 
    - adj takes an int Node and creates and returns an arrayList with nodes adjacent to it in the graph using the adjacency matrix representation 
    -  degree returns the number of nodes conencted to a given node Node
    - removeNode takes in an int Node and removes all the edges connected to it
    - Ball takes in an int s, Graph graph, and int r. Its function is to check for the number of nodes with a given radius of r.
        Returns an arrayList inBall with the list of nodes in a ball of radius r.
    - deltaBall is similar to ball, except that it checks the balls on the perimeters of a ball of radius r.
    - collectiveInt given a node i and radius r for a graph G, this function returns the collective influence of the node
    - max class to get the max of a given list a. To be used to extract the maximum collective influence information 
    - dismantle: a recursive method that takes in a graph, integer r, and integer numNodesRem. It dismantles numNodesRem number of nodes with the higher influence with a radius radius
    -  removeHighDeg removes the highest degree node from the graph 

## Running the code
(1) cd src 
(2) javac StopContagion.java
(3) java StopContagion (your commands, the input file)
    - r, int1, int2, inputfile
    removes the int2 number of nodes with the highest CI in file inputfile given the radius int1
    - d, int1, inputfile
    removes the int number of nodes with the highest degree in the inputfile


## Tests
The code was tested using the sample commands and files provided by Professor Zhupa
(1) java StopContagion -r 2 4 Sample_input1
(2) java StopContagion -d 4 Sample_input1
(3) java StopContagion -d 6 Sample_input2
(4) java StopContagion -r 2 6 Sample_input2

## Extra credit: 
- run the ContagionGraphics File
(1) cd src
(2) javac ContagionGraphics.java
(3) java ContagionGraphics (your commands, the input file)

