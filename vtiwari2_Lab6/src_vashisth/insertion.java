public class insertion {
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

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] a = {5,2,6,1,7,8,9};
        int[] sortedA = insertSort(a);
        print(sortedA);
    }
}
