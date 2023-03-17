public class merge {
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

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = { 5, 2, 6, 1, 7, 8, 9 };
        int[] sortedA = mergesort(a);
        print(sortedA);
    }
}
