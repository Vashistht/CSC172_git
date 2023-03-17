public class counting {
    public static int[] countingSort(int[] a){
        int max = findMax(a);
        int[] C = new int[max + 1];
        int[] B = new int[a.length];

        for (int i = 0; i < a.length; i++){
            C[a[i]]++;
        }

        for(int j = 1; j < max + 1; j++){
            C[j] = C[j] + C[j - 1];
        }

        for (int i = a.length - 1; i >= 0; i--){
            B[C[a[i]] - 1] = a[i];
            C[a[i]]--;
        }
        return B;
    }

    public static int findMax(int[] a){
        int max = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 5, 2, 6, 1, 7, 8, 9 };
        int[] sortedA = countingSort(a);
        print(sortedA);
    }
}
