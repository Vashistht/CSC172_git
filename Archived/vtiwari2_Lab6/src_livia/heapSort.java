public class heapSort {

    public static Integer[] heapsort(Integer[] a){
        MaxHeap<Integer> H = new MaxHeap(a, a.length, a.length);
        int n = a.length;
        for (int i = 0; i < a.length; i++){
            a[--n] = H.removemax();
        }
        return a;
    }

    public static void print(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 5, 2, 6, 1, 7, 8, 9 };
        Integer[] sortedA = heapsort(a);
        print(sortedA);
    }
}
