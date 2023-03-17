public class bubble {
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

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] a = {5,2,6,1,7,8,9};
        int[] sortedA = bubbleSort(a);
        print(sortedA);
    }
}
