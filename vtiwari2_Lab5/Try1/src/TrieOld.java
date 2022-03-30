import java.util.ArrayList;

public class Trie {
    public static int key;
    public String element;
    public static  Trie node;
    public Trie left;
    public Trie right;

    /** constructors for the Trie class*/
    // constructor 1
    public Trie() {
        left = right = null;
    }

    // constructor 2
    
    public Trie(int n, String val) {
        key = n;
        element = val;
        left = right = null;
    }

    // constructor 3
    public Trie(int n, String val, Trie l,  Trie r) {
        key = n;
        element = val;
        left = l;
        right = r;
    }

    /** getters and setters */
    //for element
    public String element(){
        return element;
    }
    public void setElement(String e){
         element = e;
    }

    //for key n
    public String key(){
        return key;
    }
    public void setKey(int n){
        key = n;
    }

    // for left child
    public Trie left(){
        return left;
    }
    public void setLeft(Trie s){
        left = s;
    }

    // for right child
    public Trie right(){
        return right;
    }
    public void setRight(Trie s){
        right = s;
    }

    /** Know that data will be stored in a leaf of the trie.
     method to check if its a leaf **/
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }


    /**
     1 * insert( trie, st ) inserts a string st into a non-empty trie trie. Returns either
     true or false indicating whether or not the insertion is successful.
     */
    // lets first make the function that does the insertion work
    public Trie insertString(Trie root, String input, int k) {
        for (int i = 0; i < input.length(); i++) {
            if (root == null) {
                Trie newNode = new Trie (k, input);
                root = newNode;
                System.out.println("2 new nodes");
                return root;
            } else if (input.compareTo(root.element) != 0) {
                if (input.charAt(i) == '0') {
                    root.left = insertString(root.left(), input, k);
                    System.out.println("test left");
                } else {  //(input.charAt(i) == '1')
                    root.right = insertString(root.right(), input, k);
                    System.out.println("test right");
                }
                return root;
            }
        }
        return root;
    }

    // should work
    public boolean insert(String st) {
        boolean insertBoolean = false;

        for (int i = 0; i < st.length(); i++){
            // if not 0, 1 then not valid
            if (st.charAt(i)!= '0' && st.charAt(i)!='1'){
                System.out.println("Not valid input");
                return insertBoolean;       //insertBoolean = false
            }
            else{
                insertBoolean = true;
            }
        }
        if (insertBoolean){
            insertString(node, st, key+1);
        }
        key++; // increment the key by 1
        System.out.println("1 inserted");
        return insertBoolean;
    }




    /**
     2 * trieToList( trie ) creates a list of strings in trie in increasing lexicographic
     order. You are not allowed to use any kind of sort methods to sort the list.
     */
    public AList<String> trieToList(Trie trie, AList<String> a){
        if (trie == null){
        } else if (trie.isLeaf()){
            a.append(trie.element());
        } else {
            trieToList(trie.left);
            trieToList(trie.right);
        }
        return a;
    }
    
    public AList<String> trieToList(Trie trie){
        AList<String> trieArray = new AList();
        trieToList(trie, trieArray);
        return trieArray;
    }

        /*
        - Since we know its a bst, left <0, right >= 0 for (node-element)
        // code
        String leftElement = node.left().element()
        String rightElement = node.right().element()
        if (node.element().compareTo(leftElement) >0){
            System.out.println(node.element());
            // recurse on the left side
        }else if (node.element().compareTo(leftElement) >=0){
            System.out.println(right.element());
            // recurse on the right side
        }

        */
    }

    /**
     3 * largest( trie ) returns the largest string in lexicographic order from the set of
     strings stored in trie. You can assume that trie is not empty.
     */


    /**
     4 * smallest( trie ) returns the smallest string in lexicographic order from the set
     of strings stored in trie. You may assume that trie is not empty.
     */

    /**
     5 * search( trie, st ) returns the string in trie that has the longest (and closest)
     prefix match with st as described in Section 1.2. You may assume that trie is not
     */ 
    // NOT DONE AT ALL RIP
    // all u need is the actual root (or what I called node stupidly) you dont need the Trie thing but they want it so I added it 
    public String search(Trie node, String input){
        String result;
        Trie pointer = node;
        int currentHeigth, oldMatch = 0;
        for (currentHeigth = 0; currentHeigth< input.length();currentHeigth++ ){
        }
        return result; 

    }
    /**
     6 * size( trie ) returns the number of strings stored in the trie.
     */

    /**
     7 * height( trie ) returns the height of the trie.
     */
}