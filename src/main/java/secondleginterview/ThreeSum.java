package secondleginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = {-3,-3,-2,0,1,2,3,3};
        int target = 0;
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
             findPairs(i,arr,target,lists);

        }

    }

    private static void findPairs(int i, int[] arr,int target,List<List<Integer>> lists) {


         List<Integer> temporaryList = new ArrayList<>();
         int left=i+1,right=arr.length-1;
         while(left<right){
            if(arr[left]+arr[right] == target-arr[i]){
              /*  temporaryList.add(arr[i] );
                temporaryList.add(arr[left]);
                temporaryList.add(arr[right]);
                lists.add(temporaryList);*/
                System.out.println(arr[i]+","+arr[left]+","+arr[right]);
            }

            while (left<right && arr[left]==arr[left+1]){
                left++;
            }
            while (left<right && arr[right]==arr[right-1]){
                right--;
            }

            if(arr[left]+arr[right]<target-arr[i]){
                left++;
            }
            else
                right--;

         }
    }
}
