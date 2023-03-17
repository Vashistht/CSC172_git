Lab 5
Lab Partners: Vashisth Tiwari (vtiwari2), Livia Betti (lbetti)

Vashisth Tiwari:
Student ID: 31564441
Email: vtiwari2@u.rochester.edu

Livia Betti:
Student ID: 31568890
Email: lbetti@u.rochester.edu

We have two classes: the Trie class and the Lab5 class.

The Trie class has a subclass Node, which has variables left, right, and element.
The left variable represents a pointer to the left child, the right variable represents a pointer to the right child.
The element is the string element that the Node has.
The Node class also has a method isLeaf to see when the node is a leaf.

For the overall trie class, we have instance variable root, representing the root of the trie.
The constructor for the trie class creates a root node. 

insert:
The insert function calls the insertRecurse functions, starting at 0 (representing the root).

insertRecurse:
The insertRecurse function operates recursively on the index of the string we are trying to insert. We have two bases cases:
  -if the node is a leaf and is empty, then the insertRecurse function adds the desired string to this location.
  -if the node is a leaf, but is not empty, then we have 2 subcases:
    -if the leaf has the same element as we are trying to insert, then we return false and the insert is not successful
    -if the leaf has a different element, then we continue comparing the characters in the strings of the one we are trying to insert and the element of the leaf node. 
        We call insertRecurse to add this string recursively.
  -if the node is not a leaf node, we move to the left if the character at this index is 0, and to the right if the character at this index is 1.

-trieToList:
The trieToList(Node node, ArrayList<String> a) function recursively adds the nodes of the trie to a. This starts by looking at the left children, then the right children of each node.
The trieToList(Trie trie) function constructs an ArrayList trieArray and opperates trieToList(trie.root, trieArray) to insert the elements of the trie into trieArray.

-print:
The print function prints the elements of an ArrayList. This is used to print the elements of the trieArray

-largest:
The largest function returns the last element of the arraylist created from the trie. This is the largest string in lexicographic order from the trie.

-smallest:
The smallest function returns the first element of the arraylist created from the trie. This is the smallest string in lexicographic order from the trie.

search:
The search function calls searchRecurse, starting at 0 (which represents the root).
This finds the longest prefix match with a given string.

searchRecurse:
The searchRecurse function looks for a given string, operating recursively on the index of characters in that string.
We have base cases:
  -if the node is null, null is returned (this string is not found)
  -if the node is a leaf, then the longest prefix match with the provided string is found and the element of this leaf is returned.
-if the length of this string is < the index of a character, we continue search, calling this function on index i+1.
-if the character at index i is 0, we call searchRecurse on the left child; 
-if the character at index i is 1, we call searchRecurse on the right child;

size:
The size function returns the number of strings stored in the trie by using trieToList and returning the size of the arrayList

height:
The height function calls heighRecurse, starting at 0 (representing the root).

heightRecurse:
The heightRecurse function operates recursively on the depth of the tree. We have base case:
-if n is null, then the depth is return.
Otherwise, the max of the heigh of the left and right subtries are taken.

Lab5 class:
The Lab5 class has the main method that scans the input in the command line.
The main method first constructs a trie on which to operate. At first, this is just a trie with a root node (that is empty).
The main method has cases, calling search, insert, largest, smallest, trieToList on the trie, depending on the commands in the command file.
The results are printed out.

How to run?

javac Lab5.java -Xlint
java Lab5 commands.txt