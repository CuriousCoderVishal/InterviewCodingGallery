package codingproblems;

public class  BinarySearch {
    public static void main(String[] args) {
        int arr[] = {-2,-5,0,7,8,10,12,15};
        int searchKey = -5;
        System.out.println(binarySearch(arr,searchKey));
    }

    //Time complexity - O(log n)
    private static boolean binarySearch(int[] arr, int searchKey) {

        int start =0 , end = arr.length-1;

        while (start<=end){

            int mid = (start+end)/2;

            if (arr[mid]==searchKey){
                return true;
            }
            else if (searchKey>arr[mid]){
                start = mid +1;
            }
            else
                end = mid-1;

        }

        return false;
    }
}
