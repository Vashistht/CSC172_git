/** List ADT */
public interface List {

    public int size(LList.Node[] arr, int index);
    /** Remove all contents from the list */
    public void clear();
    /** Insert an element at the current location.  */
    public void insert(char item);
    /** Append an element at the end of the list.  */
    public void append(char item);
    /** Remove and return the current element. */
    public remove();
    /** Set the current position to the start of the list */
    public void moveToStart();
    /** Set the current position to the end of the list */
    public void moveToEnd();
    /** Move the current position one step left. */
    public void prev();
    /** Move the current position one step right.*/
    public void next();
    /** @return The number of elements in the list. */
    public int length();
    /** @return The position of the current element. */
    public int currPos();
    /** Set current position.
     @param pos The position to make current. */
    public void moveToPos(int pos);
    /** @return The current element. */
    public char getValue();


//    /** Singly linked list node */
//    class Link<E> {
//        private E element; // Value for this node
//        private Link<E> next; // Pointer to next node in list
//        // Constructors
//        Link(E it, Link<E> nextval)
//        { element = it; next = nextval; }
//        Link(Link<E> nextval) { next = nextval; }
//        Link<E> next() { return next; } // Return next field
//        Link<E> setNext(Link<E> nextval) // Set next field
//        { return next = nextval; } // Return element field
//        E element() { return element; } // Set element field
//        E setElement(E it) { return element = it; }
//    }
}