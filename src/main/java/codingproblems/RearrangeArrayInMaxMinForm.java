package codingproblems;

import java.util.Arrays;

public class RearrangeArrayInMaxMinForm {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println("Original Array ");
        System.out.println(Arrays.toString(arr));

        int temp[] = rearrange(arr, arr.length);

        System.out.println("Modified Array ");
        System.out.println(Arrays.toString(temp));

    }

    private static int[] rearrange(int[] arr, int length) {

        int temp[] = new int[length];
        int start = 0, end = length - 1;
        int index = 0;
        boolean flag = true;
        while (start <= end) {

            if (flag) {
                temp[index++] = arr[end--];
            } else {
                temp[index++] = arr[start++];
            }

            flag = !flag;

        }
        return temp;
    }
}
