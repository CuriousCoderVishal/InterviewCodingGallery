package codingproblems;

public class SearchAnElementInSortedRotatedArray {

    public static void main(String[] args) {
        int arr[] = {20, 30, 40, 50, 60, 5, 10};
        int key = -20;

        System.out.println(binarySearch(arr, key));
    }

    private static boolean binarySearch(int[] arr, int key) {

       /* TODO : Algorithm:
                1.Find the sorted part of array by a[low]<a[mid]- left part is sorted else right part
                2.Check if the key is prestent in the sorted part accordingly set low and high value
                3.If present in soeted part apply binarySearch()- else go to the unsorted part and
                  repeat the above steps*/


        int low = 0, high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return true;

            if (arr[low] < arr[mid]) { //left part is sorted
                if (key >= arr[low] && key < arr[mid]) { //Key present in the range of left sorted part
                    high = mid - 1;
                } else
                    low = mid + 1;   // key present in the unsorted part
            } else { //Right part of array is sorted(if left part is not sorted then right part is definitely sorted)

                if (key > arr[mid] && key <= arr[high]) { //Key present in the range of right sorted part
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;

    }

}
