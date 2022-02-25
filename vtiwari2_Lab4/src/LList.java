/*
Source:
reversing the linked list: https://www.geeksforgeeks.org/reverse-a-linked-list/
*/
/** Linked list implementation */

public class LList implements List {
    private Link head;         // Pointer to list head
    private Link tail;         // Pointer to list tail
    private int cnt;        // current number of elements in the list

    /** Constructors */
    public LList() {
        head = null;
        tail = null;
    }

    /** Singly linked list node */
    class Link {
        private char element;        // Value stored in the node
        private Link next;     // pointer to what follows

        Link(char it, Link nextElement) {
            element = it;
            next = nextElement;
        }

        Link(char it){
            element = it;
        }

        Link(){
        }

        Link getNext() {
            return next;
        }  // getter for the <next> pointer

        Link setNext(Link nextElement){
            return next = nextElement;
        }

        char getElement(){
            return element;
        }

        int setElement(char it){
            return element = it;
        }

        /**
         * Generate a human-readable representation of this list's contents
         * uses toString() on the individual elements.
         */
        public String toString(){
            return element + "";
        }
    }

    public boolean isEmpty(){
        return cnt==0;
    }

    public int size(Link[] arr, int index){
        int size = 1;
        Link current = arr[index];
        while(current.next != null){
            size++;
            current = current.getNext();
        }
        return size;
    }

    /** add elements from the head */
    public void addFront(char it){
        head = new Link(it, head);
        cnt++;
    }

    /** add to that loc */
    public void append(char it) {
        Link newnode = new Link();
        newnode.element = it;
        newnode.next = null;
    }

    /** remove element from head */
    public char removeFront(){
        char it = head.getElement();
        head = head.next;
        cnt--;
        return it;
    }

    /**  add elements from the tail*/
    public void addLast(char it){
        Link newest = new Link(it, null);
        tail.setNext(newest);
        tail = newest;
    }

    /** Create new list from head and return it */
    public Link newList(int index, String input, Link[] arr){
        arr[index] = new Link(input.charAt(0));
        Link current = arr[index];
        for(int i = 1; i < input.length() ; i++){
            Link newLink = new Link(input.charAt(i));
            newLink.element = input.charAt(i);
            newLink.next = null;
            current.setNext(newLink);
            current = current.getNext();
        }
        return arr[index];
    }

//    /** print elements in list (head to tail) */
//    public void printList() {
//        Link pos = head;
//        while(pos!=null){
//            System.out.print(pos.getElement()+" ");
//            pos = pos.getNext();
//        }
//        System.out.println();
//    }

    /** prints from the given node (temp)*/
    public static void printLinks(Link temp){
        Link current = temp;
        while(current != null){
            System.out.print(current);
            current = current.getNext();
        }
        System.out.println();
    }

    /** Clips the selected sequence at starting and ending index
     ** New clipped sequence replaces old sequence
     ** returns new sequence at desired position */
    public Link clipList(int pos, int start, int end, Link[] arr){

        if(DNAList.arrFilled[pos].equals(DNAList.Status.EMPTY)){
            System.out.println("No sequence to clip at specified position");
        } else if(DNAList.arrFilled[pos].equals(DNAList.Status.FILLED)){
            if(start < 0){
                System.out.println("Invalid start index");
            } else if(start > size(arr, pos)){
                System.out.println("Start index out of bounds");
            } else if(end > size(arr, pos)){
                System.out.println("End index out of bounds");
            } else if(end < start) {
                arr[pos].setElement('\0');
            } else if((start < size(arr, pos)) && (end < size(arr, pos))){
                Link current = arr[pos];
                for(int s = start-1; s > 0; s--){
                    current = current.getNext();
                }
                Link newList = null;
                Link tail = null;
                while(current!= null && (start <= end)){
                    if(newList == null){
                        newList = new Link(current.getElement(),null);
                        tail = newList;
                    } else{
                        tail.next = new Link();
                        tail = tail.next;
                        tail.element = current.element;
                        tail.next = null;
                    }
                    start++;
                    current = current.next;
                }
                return arr[pos] = newList;
            }
        }
        return arr[pos];
    }

    /** Copies sequence at a position
     ** returns head of new linked list copy */
    public Link copyList(int pos1, Link[] arr){
        if(DNAList.arrFilled[pos1].equals(DNAList.Status.EMPTY)){
            System.out.println("No sequence to copy at specified position");
        } else if(DNAList.arrFilled[pos1].equals(DNAList.Status.FILLED)){
            Link current = arr[pos1];
            Link newList = null;
            Link tail = null;
            while(current!= null) {
                if (newList == null) {
                    newList = new Link(current.getElement(), null);
                    tail = newList;
                } else {
                    tail.next = new Link();
                    tail = tail.next;
                    tail.element = current.element;
                    tail.next = null;
                }
                current = current.next;
            }
            return newList;
        }
        return null;
    }


    /** Transcribes sequence in required order
     ** Only trascribes if the initial sequence is DNA*/
    public Link transcribeList(int pos, Link[] arr){
        if(checkIfDNA(arr[pos])){
            Link head = arr[pos];
            Link current = head;
            if(head == null || head.next == null){
                return head;
            }
            while(current != null){
                if(current.element == 'A'){
                    current.element = 'T';
                } else if (current.element == 'T'){
                    current.element = 'A';
                } else if (current.element == 'C'){
                    current.element = 'G';
                } else if (current.element == 'G'){
                    current.element = 'C';
                }
                current = current.next;
            }

            current = head;
            for(int i = 0; i < size(arr, pos); i++){
                if(current.element == 'T'){
                    current.element = 'U';
                }
                current = current.next;
            }

        } else if(!checkIfDNA(arr[pos])){
            System.out.println("Cannot Transcribe RNA");
        }
        return arr[pos];
    }

    /** reversing the list for transcription */
    public Link reverseList(Link node){
        Link current = node;
        Link prev = null;
        while(current != null){
            Link nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    /** delete the list  */
    public void deleteList(int index, Link[] arr){
        arr[index].setElement('\0');
        arr[index].setNext(null);
        DNAList.arrFilled[index] = DNAList.Status.EMPTY;
    }

    /** return true if the sequence is RNA
     ** else false based on the ACGU order for RNA*/
    public static boolean checkIfRNA(Link head){
        Link current = head;
        while((current != null)){
            if(current.getElement() == 'A'){
                current = current.getNext();
            } else if (current.getElement() == 'C'){
                current = current.getNext();
            } else if (current.getElement() == 'G'){
                current = current.getNext();
            } else if (current.getElement() == 'U'){
                current = current.getNext();
            } else {
                return false;
            }
        }
        return true;
    }

    /** return true if the sequence is DNA
     ** else false based on the ACTG order for DNA*/
    public static boolean checkIfDNA(Link head){
        Link current = head;
        while(current != null){
            if(current.getElement() == 'A'){
                current = current.getNext();
            } else if (current.getElement() == 'C'){
                current = current.getNext();
            } else if (current.getElement() == 'T'){
                current = current.getNext();
            } else if (current.getElement() == 'G'){
                current = current.getNext();
            } else {
                return false;

            }
        }
        return true;
    }


}







