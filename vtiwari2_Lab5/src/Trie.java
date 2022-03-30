
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trie {

	static class Node {
		Node left;
		Node right;
		String element;

		public Node() { 
			left = right = null;
			this.element = null;
		}

		public boolean isLeaf() {
			return (left == null && right == null);
		}
		
		public Node(String element) {
			this.element = element;
			left = right = null; 
		}
	}

	public Node root;

	public Trie() { 
		root = new Node();
	}
	
	/**
     1 * insert( trie, str ) inserts a string str into a non-empty trie trie. Returns either
     true or false indicating whether or not the insertion is successful.
    */

	public static boolean insert(Trie trie, String str) {
		return insertRecurse(trie.root, str, 0); // returns a bool depending on true or false from insertRecurse method define
	}

	// (initially this was insertRecurse feel free to rename to insert I had it so I can debug 
	private static boolean insertRecurse(Node node, String str, int i) {

		// Case 1: when empty (leaf and with element null) just add it 
		if (node.element == null && node.isLeaf()) {
			node.element = str;
			return true;
		}

		//case 2: Leaf has a element
		if (node.isLeaf()) {
			// 2.1: same element as the string to be added, then insertion is not successful
			if (str.equals(node.element)) {
				return false;
			} 
			// 2.2 if not the same then we need to add the node, and move it down
			else {
				if (node.element.charAt(i) == '0') {
					// if the node at some depth as string 0, it should be the left node
					node.left = new Node(node.element); 
				} else {
					// if the node at some depth as string 1, it should be the right node
					node.right = new Node(node.element);
				}
				node.element = null; // remove current node element
				// add string recursively
				if (str.charAt(i) == '0') {
					if (node.left == null) node.left = new Node();
					return insertRecurse(node.left, str, i + 1); // call recursive function with new depth being i + 1
				} else {
					if (node.right == null) node.right = new Node();
					return insertRecurse(node.right, str, i + 1);
				}
			}
		} else {
			// not leaf node
			if (str.charAt(i) == '0') {
				if (node.left == null) node.left = new Node();
				return insertRecurse(node.left, str, i + 1); 
			} else {
				if (node.right == null) node.right = new Node();
				return insertRecurse(node.right, str, i + 1);
			}
		}
	}

	/**
     2 * trieToList( trie ) creates a list of strings in trie in increasing lexicographic
     order. You are not allowed to use any kind of sort methods to sort the list.
    */

	// Liv's function: changed Alist to ArrayList, append to add
	// modified so it fits with the node class
	private static void trieToList(Node node, ArrayList<String> a) {
		if (node == null) {
		}else if (node.isLeaf()) {
			a.add(node.element);
		} else {
			trieToList(node.left, a);
			trieToList(node.right, a);
		}
	}

	public static ArrayList<String> trieToList(Trie trie) {
		ArrayList<String> trieArray = new ArrayList();
		trieToList(trie.root, trieArray);
		return trieArray;
	}

	public static void print(ArrayList<String> list){
		for (int i = 0; i < list.size(); i++) { 
				System.out.print(list.get(i) + " "); 
			}   
			System.out.println(); 
			}

	/**
     3 * largest( trie ) returns the largest string in lexicographic order from the set of
     strings stored in trie. You can assume that trie is not empty.
    */
	public static String largest(Trie trie) {
		ArrayList<String> list = new ArrayList<String>();
		trieToList(trie.root, list);
		return list.get(list.size()-1);
	}

	/**
     4 * smallest( trie ) returns the smallest string in lexicographic order from the set
     of strings stored in trie. You may assume that trie is not empty.
    */
	public static String smallest(Trie trie) {
		ArrayList<String> list = new ArrayList<String>();
		trieToList(trie.root, list);
		return list.get(0);
	}

	/**
     5 * search( trie, str ) returns the string in trie that has the longest (and strClosest)
     prefix match with str as described in Section 1.2. You may assume that trie is not
    */ 

	public static String search(Trie trie, String str) {
		return searchRecurse(trie.root, str, 0);
	}

	public static String searchRecurse(Node r, String str, int i) { //depth i
		if (r == null) return null;  //base case

		if (r.isLeaf()) return r.element; // if nodes a leaf you return that element (no more to explore)

		if (str.length() - 1 < i) return searchRecurse(r.right, str, i + 1); //search till the end of the string

		if (str.charAt(i) == '0') {
			String strClosest = searchRecurse(r.left, str, i + 1); // if 0 at i then go left with level i+1
			if (strClosest == null) { // if not try other side
				strClosest = searchRecurse(r.right, str, i + 1);
			}
			return strClosest;
		} else { // if 0 at i then go right with level i+1
			String strClosest = searchRecurse(r.right, str, i + 1);
			if (strClosest == null) { // if not try other side
				strClosest = searchRecurse(r.left, str, i + 1);
			}
			return strClosest;
		}
	}

	/**
     6 * size( trie ) returns the number of strings stored in the trie.
     */
	public static int size(Trie trie) {
		ArrayList<String> list = new ArrayList<String>();
		trieToList(trie.root, list);
		return list.size();
	}

	/**
     7 * height( trie ) returns the height of the trie.
    */
	public static int height(Trie trie) {
		return heightRecurse(trie.root, 0);
	}
	private static int heightRecurse(Node n, int depth) {
		if (n == null) return depth;
		return Math.max(
			heightRecurse(n.left, depth + 1),
			heightRecurse(n.right, depth + 1));
	}


	public static void main(String[] args) throws Exception {


		Trie trie = new Trie();
		File commands = new File(args[0]);
		try (Scanner strings = new Scanner(commands)) {
			while (strings.hasNextLine()) {
				String commandSingle = strings.nextLine();
				/** split when one or many white spaces and add them as elements of the list
				// first element decides the action,
				// second (if present) where that action would take place 
				*/
				String[] commandsSeparated = commandSingle.trim().split("\\s+"); 

				if (commandsSeparated[0].equals("insert")){
					insert(trie, commandsSeparated[1]);
				}
			   		   
				else if (commandsSeparated[0].equals("search")){
					System.out.println(search(trie, commandsSeparated[1]));
				}
			   
				else if (commandsSeparated[0].equals("height")){
					System.out.println(height(trie)); 
				}

			   
				else if (commandsSeparated[0].equals("size")){
					System.out.println(size(trie));
				}
			   
				else if (commandsSeparated[0].equals("largest")){
					System.out.println(largest(trie)); 
				}
				else if (commandsSeparated[0].equals("smallest")){
					System.out.println(smallest(trie)); 
				}
				else if (commandsSeparated[0].equals("print")){
					print(trieToList(trie));
				}
			   
			}
		}
		catch (FileNotFoundException e) {
            System.out.printf("Sorry, your file was not found", e);  
        }
	}
}
