/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Sorting {

  public static int[] swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      return arr;
  }

  public static int[] swap(int[] arr){
      double d = (0.1)*(arr.length);
      Random rand = new Random();

      for (int i = 0; i < d; i++){
          int rand1 = rand.nextInt(arr.length);
          int rand2 = rand.nextInt(arr.length);
          arr = swap(arr, rand1, rand2);
      }
      return arr;
  }

  public static int[] bubbleSort(int[] a){
     for (int i = 0; i < a.length; i++){
          for (int j = a.length - 1; j > i; j--){
              if (a[j] < a[j-1]){
                  int temp = a[j];
                  a[j] = a[j-1];
                  a[j-1] = temp;
              }
          }
      }
      return a;
  }

  public static int[] selectionSort(int[] a){
      for (int i = 0; i < a.length; i++){
          int lowInd = i;
         for (int j = i + 1; j < a.length; j++){
              if (a[j] < a[i]){
                  lowInd = j;
              }
          }
          int temp = a[i];
          a[i] = a[lowInd];
          a[lowInd] = temp;
      }
      return a;
  }

  public static int[] insertSort(int[] a){
    for (int i = 0; i < a.length; i++){
        int j = i;
        while ((j > 0) && (a[j] < a[j-1])){
            int temp = a[j];
            a[j] = a[j-1];
            a[j-1] = temp;
            j--;
        }
    }
    return a;
  }

  public static int[] mergesort(int[] a) {
    if (a.length <= 1) {
        return a;
    }
    int mid = a.length / 2;

    int[] a1 = new int[mid];
    int[] a2 = new int[a.length - mid];

    for (int i = 0; i < mid; i++) {
        a1[i] = a[i];
    }

    for (int i = mid; i < a.length; i++) {
        a2[i - mid] = a[i];
    }

    a1 = mergesort(a1);
    a2 = mergesort(a2);

    return mergeArray(a1, a2);
  }

  public static int[] mergeArray(int[] a1, int[] a2) {
    int[] merged = new int[a1.length + a2.length];

    int i = 0;
    int j = 0;
    int s = 0;

    while ((i < a1.length) || (j < a2.length)) {
        if (i >= a1.length) {
            merged[s] = a2[j];
            j++;
            s++;
        } else if (j >= a2.length) {
            merged[s] = a1[i];
            i++;
            s++;
        } else if (a1[i] <= a2[j]) {
            merged[s] = a1[i];
            i++;
            s++;
        } else {
            merged[s] = a2[j];
            j++;
            s++;
        }
    }
    return merged;
  }

  public static int partition(int[] a, int l, int r) {
    int x = a[r];
    int i = l-1; 
    for (int j = l; j < r; j++) {
        if (a[j] <= x) {
            i++; 
            a = swap(a, i , j);
        }
    }
    return i+1;
  }

public static int[] qSort(int[] a, int l, int r) {
    int piv = (l + r) / 2;
    a = swap(a, r, piv);
    int k = partition(a, l, r);
    a = swap(a, k, r);

    if ((k - l) > 1) {
        qSort(a, l, k);
    }
    if ((r - k) > 1) {
        qSort(a, k + 1, r);
    }
    return a;
  }

  public static int[] qSort(int[] a) {
    return qSort(a, 0, a.length - 1);
  }

 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
 * @throws IOException
     */
    public static void main(String[] args) throws IOException  { 
        In in = new In(args[0]);
        
		  // Storing file input in an array
        int[] a = in.readAllInts();
        int[] b = a;
        Arrays.sort(b);
        int[] c = new int[b.length];
        for (int i = 0; i < b.length; i++){
          c[i] = b[b.length - 1 - i];
        }
        int[] d = swap(a);

        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        // c contains all integers stored in reverse order 
        // (you can have your own O(n) solution to get c from b
        // d contains almost sorted array 
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.   
       
        //TODO: 
        int num = Integer.parseInt(args[1]);
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort 
        //  * 3 = Insertion Sort 
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those. 
        // For runtime and priting, you can use the same code from Lab 4 as follows:
        
        String netID = "lbetti";
        Stopwatch timer = new Stopwatch();
        double time;
        String timeStamp;
        String arrayUsed;
        FileWriter myWriter;

        switch (num){
          case 0:
            String algorithmUsed = "Arrays.sort()";
            int[] a0 = a;
            int[] b0 = b;
            int[] c0 = c;
            int[] d0 = d;

            timer = new Stopwatch();
            Arrays.sort(a0);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "a";
            myWriter = new FileWriter("a.txt");
            for (int i = 0; i < a0.length; i++){
              myWriter.write(Integer.toString(a0[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            Arrays.sort(b0);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "b";
            myWriter = new FileWriter("b.txt");
            for (int i = 0; i < b0.length; i++){
              myWriter.write(Integer.toString(b0[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            Arrays.sort(c0);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "c";
            myWriter = new FileWriter("c.txt");
            for (int i = 0; i < c0.length; i++){
              myWriter.write(Integer.toString(c0[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            Arrays.sort(d0);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "d";
            myWriter = new FileWriter("d.txt");
            for (int i = 0; i < d0.length; i++){
              myWriter.write(Integer.toString(d0[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            break;
          case 1:
            algorithmUsed = "Bubble Sort";
            int[] a1 = a;
            int[] b1 = b;
            int[] c1 = c;
            int[] d1 = d;

            timer = new Stopwatch();
            bubbleSort(a1);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "a";
            myWriter = new FileWriter("a.txt");
            for (int i = 0; i < a1.length; i++){
              myWriter.write(Integer.toString(a1[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            bubbleSort(b1);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "b";
            myWriter = new FileWriter("b.txt");
            for (int i = 0; i < b1.length; i++){
              myWriter.write(Integer.toString(b1[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            bubbleSort(c1);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "c";
            myWriter = new FileWriter("c.txt");
            for (int i = 0; i < c1.length; i++){
              myWriter.write(Integer.toString(c1[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            bubbleSort(d1);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "d";
            myWriter = new FileWriter("d.txt");
            for (int i = 0; i < d1.length; i++){
              myWriter.write(Integer.toString(d1[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            break;
          case 2:
            algorithmUsed = "Selection Sort";
            int[] a2 = a;
            int[] b2 = b;
            int[] c2 = c;
            int[] d2 = d;

            timer = new Stopwatch();
            selectionSort(a2);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "a";
            myWriter = new FileWriter("a.txt");
            for (int i = 0; i < a2.length; i++){
              myWriter.write(Integer.toString(a2[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            selectionSort(b2);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "b";
            myWriter = new FileWriter("b.txt");
            for (int i = 0; i < b2.length; i++){
              myWriter.write(Integer.toString(b2[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            selectionSort(c2);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "c";
            myWriter = new FileWriter("c.txt");
            for (int i = 0; i < c2.length; i++){
              myWriter.write(Integer.toString(c2[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            selectionSort(d2);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "d";
            myWriter = new FileWriter("d.txt");
            for (int i = 0; i < d2.length; i++){
              myWriter.write(Integer.toString(d2[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            break;
          case 3:
            algorithmUsed = "Insertion Sort";
            int[] a3 = a;
            int[] b3 = b;
            int[] c3 = c;
            int[] d3 = d;

            timer = new Stopwatch();
            insertSort(a3);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "a";
            myWriter = new FileWriter("a.txt");
            for (int i = 0; i < a3.length; i++){
              myWriter.write(Integer.toString(a3[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            insertSort(b3);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "b";
            myWriter = new FileWriter("b.txt");
            for (int i = 0; i < b3.length; i++){
              myWriter.write(Integer.toString(b3[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            insertSort(c3);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "c";
            myWriter = new FileWriter("c.txt");
            for (int i = 0; i < c3.length; i++){
              myWriter.write(Integer.toString(c3[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            insertSort(d3);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "d";
            myWriter = new FileWriter("d.txt");
            for (int i = 0; i < d3.length; i++){
              myWriter.write(Integer.toString(d3[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            break;
          case 4:
            algorithmUsed = "Merge Sort";
            int[] a4 = a;
            int[] b4 = b;
            int[] c4 = c;
            int[] d4 = d;

            timer = new Stopwatch();
            mergesort(a4);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "a";
            myWriter = new FileWriter("a.txt");
            for (int i = 0; i < a4.length; i++){
              myWriter.write(Integer.toString(a4[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            mergesort(b4);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "b";
            myWriter = new FileWriter("b.txt");
            for (int i = 0; i < b4.length; i++){
              myWriter.write(Integer.toString(b4[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            mergesort(c4);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "c";
            myWriter = new FileWriter("c.txt");
            for (int i = 0; i < c4.length; i++){
              myWriter.write(Integer.toString(c4[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            mergesort(d4);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "d";
            myWriter = new FileWriter("d.txt");
            for (int i = 0; i < d4.length; i++){
              myWriter.write(Integer.toString(d4[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            break;
          case 5:
            algorithmUsed = "Quick Sort";
            int[] a5 = a;
            int[] b5 = b;
            int[] c5 = c;
            int[] d5 = d;

            timer = new Stopwatch();
            qSort(a5);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "a";
            myWriter = new FileWriter("a.txt");
            for (int i = 0; i < a5.length; i++){
              myWriter.write(Integer.toString(a5[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            qSort(b5);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "b";
            myWriter = new FileWriter("b.txt");
            for (int i = 0; i < b5.length; i++){
              myWriter.write(Integer.toString(b5[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            qSort(c5);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "c";
            myWriter = new FileWriter("c.txt");
            for (int i = 0; i < c5.length; i++){
              myWriter.write(Integer.toString(c5[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);

            timer = new Stopwatch();
            qSort(d5);
            time = timer.elapsedTimeMillis();
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arrayUsed = "d";
            myWriter = new FileWriter("d.txt");
            for (int i = 0; i < d5.length; i++){
              myWriter.write(Integer.toString(d5[i]));
              myWriter.write(" ");
            }
            myWriter.close();
            StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
            break;
        }
  } 
} 


