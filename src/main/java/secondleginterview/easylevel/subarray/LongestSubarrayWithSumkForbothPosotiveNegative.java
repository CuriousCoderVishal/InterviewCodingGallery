package secondleginterview.easylevel.subarray;

import java.util.HashMap;

public class LongestSubarrayWithSumkForbothPosotiveNegative {
    public static void main(String[] args) {
       // int a[]= { 1,2,3,1,1,1,1,4,2,3};
        int a[]= { 2,0,0,3};
        int k=3;
        int maxLength = 0;

        HashMap<Integer, Integer> prefixSumtoIndex = new HashMap<>();
        int prefixSum = 0;
        for(int i = 0; i <a.length; i++){
            prefixSum += a[i];

           /* Case: subarray starts at index 0
            Suppose array = {1, 2, 3}, k = 6.
            At i=2, prefixSum = 6.
            We want to check: prefixSum - k = 6 - 6 = 0.
            👉 That means: "Did we see a prefix sum 0 earlier?"
            But in our map we never inserted 0 at index -1 (before array starts).
            So prefixSumToIndex.containsKey(0) will be false, and we’ll miss this case.*/
            if(prefixSum==k){
                maxLength = Math.max(maxLength,i+1);
            }

           /* First time we see a prefix sum, store its index.
            Later if the same prefix sum appears again, don’t update.
            Earlier occurrence = longer subarray
            Later occurrence = shorter subarray*
            see example for int a[]= { 2,0,0,3};
            /
            */
            // store prefix sum index only if not present (keep earliest occurrence)
            if(!prefixSumtoIndex.containsKey(prefixSum)){
               prefixSumtoIndex.put(prefixSum,i);
            }


            if(prefixSumtoIndex.containsKey(prefixSum-k)){
                maxLength = Math.max(maxLength,i-prefixSumtoIndex.get(prefixSum-k));
            }
        }

        System.out.println(maxLength);

    }
}
