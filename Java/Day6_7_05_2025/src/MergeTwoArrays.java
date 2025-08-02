// Q1. Merge Two Arrays
public class MergeTwoArrays {
    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] c = new int[a.length + b.length];
        int i;
        for (i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            c[i++] = b[j];
        }
        for (int num : c) {
            System.out.print(num + " ");
        }
    }
}