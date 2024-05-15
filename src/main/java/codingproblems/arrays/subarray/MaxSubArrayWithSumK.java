package codingproblems.arrays.subarray;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithSumK {
    public static void main(String[] args) {

        int a[]  = {10,15,-5,15,-10,5,1,1,3};
        int currSum =0;
        int sum = 5;
        int start = 0, end = -1;
        int maxLength = 0;
        int maxStartIndex = 0, maxEndIndex =0;

        Map<Integer,Integer> currSumToIndexMap = new HashMap<>();

        for (int i =0 ;i<a.length;i++){
            currSum = currSum + a[i];


            if(currSum==sum){
                start = 0;
                end = i;
            }

            if(currSumToIndexMap.containsKey(currSum-sum)){
                start = currSumToIndexMap.get(currSum-sum) +1;
                end = i;
            }

            if(end - start +1 > maxLength){
                maxLength = end- start +1;
                maxStartIndex = start;
                maxEndIndex = end;
            }

            currSumToIndexMap.put(currSum,i);
        }

        System.out.println(maxStartIndex+","+maxEndIndex);
    }
}
