public class selection {
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

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] a = {5,2,6,1,7,8,9};
        int[] sortedA = selectionSort(a);
        print(sortedA);
    }
}
