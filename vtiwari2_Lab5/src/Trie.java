public class Trie <Key, E> {
    public static int key;
    public String element;
    public static  <Integer, String> node;
    public <Key, String> left;
    public <Key, String> right;

    /** constructors for the Trie class*/
    // constructor 1
    public Trie(int n, String val) {
        key = n;
        element = val;
        left = right = null;
    }

    // constructor 2
    public Trie() {
        left = right = null;
    }

    // constructor 3
    public Trie(int n, String val, Trie<Key, String> l,  Trie<Key, String> r) {
        key = n;
        element = val;
        left = l;
        right = r
    }

    /** getters and setters */
    //for element
    public String element(){
        return element
    }
    public void setElement(String e){
         element = e;
    }

    //for key n
    public String key(){
        return key
    }
    public void setKey(int n){
        key = n;
    }

    // for left child
    public Trie<Key, String> left(){
        return left
    }
    public void setLeft(Trie<Key, String> l){
        left = l;
    }

    // for right child
    public Trie<Key, String> right(){
        return right
    }
    public void setRight(Trie<Key, String> r){
        right = r;
    }

    /** Know that data will be stored in a leaf of the trie.
     method to check if its a leaf **/
    public boolean isLeaf() {
        left = null && right = null;
    }


    /**
     1 * insert( trie, st ) inserts a string st into a non-empty trie trie. Returns either
     true or false indicating whether or not the insertion is successful.
     */
    // not finished need to actually insert the string
    public boolean insert(String st) {
        boolean insertBoolean = false;
        for (int i = 0; i = st.length()-1; i++){
            // if not 0, 1 then not valid
            if (st.charAt(i)!= '0' && st.charAt(i)!='1'){
                System.out.println("Not valid input");
//                insertBoolean = false
                return insertBoolean;
            }
            else{
                insertBoolean = true;
            }
        }
        


    }




    /**
     2 * trieToList( trie ) creates a list of strings in trie in increasing lexicographic
     order. You are not allowed to use any kind of sort methods to sort the list.
     */

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

    /**
     6 * size( trie ) returns the number of strings stored in the trie.
     */

    /**
     7 * height( trie ) returns the height of the trie.
     */
    insert( trie, st )
}