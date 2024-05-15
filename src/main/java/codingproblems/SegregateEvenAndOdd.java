package codingproblems;

import java.util.Arrays;

public class SegregateEvenAndOdd {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 6, 1, 5, 8, 10};

        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        rearrange(arr, arr.length);

        //  System.out.println("Modified Array ");
        //   System.out.println(Arrays.toString(arr));
    }

    private static void rearrange(int[] arr, int length) {

        int j = 0, i = -1;
        while (j != length) {

            if (arr[j] % 2 == 0) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
