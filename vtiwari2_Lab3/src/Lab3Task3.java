import java.util.ArrayList;
import java.util.Iterator;

public class Lab3Task3 {
    // Using basic while / for loop
    public static void printArrayListBasicLoop(ArrayList<Integer> al) {
        for (int i = 0; i < al.size(); i++) {
                System.out.print(al.get(i) + " ");
            }
        System.out.println();
        }

    // Using enhanced for loop (:)
    public static void printArrayListEnhancedLoop(ArrayList<Integer> al) {
        for (Integer number: al) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Using basic for loop with iterator
    public static void printArrayListForLoopListIterator(ArrayList<Integer> al) {
        for (Iterator<Integer> it = al.iterator(); it.hasNext(); ) {
            Integer number = it.next();
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Using basic while loop with iterator
    public static void printArrayListWhileLoopListIterator(ArrayList<Integer> al) {
        Iterator<Integer> it = al.iterator();
        while (it.hasNext()) {
            Integer number = it.next();
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
