package codingproblems;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {-2, -5, 0, 7, 8, 10, 12, 15};
        int searchKey = -5;

        System.out.println(linearSearch(arr, searchKey));
    }

    private static boolean linearSearch(int[] arr, int searchKey) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchKey) {
                return true;
            }
        }
        return false;
    }
}
