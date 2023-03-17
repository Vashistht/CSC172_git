public class qsort {

    public static int partition(int[] a, int l, int r) {
        int x = a[r];
        int i = l-1; 
        for (int j = l; j < r; j++) {
            if (a[j] <= x) {
                i++; 
                DSutil.swap(a, i , j);
            }
        }
        return i+1;
    }

    public static int[] qSort(int[] a, int l, int r) {
        int piv = (l + r) / 2;
        DSutil.swap(a, r, piv);
        int k = partition(a, l, r);
        DSutil.swap(a, k, r);

        if ((k - l) > 1) {
            qSort(a, l, k);
        }
        if ((r - k) > 1) {
            qSort(a, k + 1, r);
        }
        return a;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 5, 2, 6, 1, 7, 8, 9 };
        int[] sortedA = qSort(a, 0, a.length - 1);
        print(sortedA);
    }
}
