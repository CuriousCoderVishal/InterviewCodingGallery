package codingproblems;

public class MoveZeroesToEnd {
    public static void main(String[] args) {

        int[] A = {5, 6, 0, 4, 6, 0, 9, 0, 8};
        int n = A.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] != 0) {
                swap(A, i, j);
                j++;
            }
        }

        for (int i = 0; i < A.length; i++)
            System.out.println(A[i]);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
