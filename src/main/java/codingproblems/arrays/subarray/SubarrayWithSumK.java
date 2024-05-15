package codingproblems.arrays.subarray;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int a[]  = {10,15,-5,15,-10,5};
        int currSum =0;
        int sum = 5;
        int start = 0, end = -1;

        Map<Integer,Integer> currSumToIndexMap = new HashMap<>();

        for (int i=0;i<a.length;i++){
            currSum = currSum + a[i];

            if(currSum==sum){
                start = 0;
                end = i;
                break;
            }

            if(currSumToIndexMap.containsKey(currSum-sum)){
                start = currSumToIndexMap.get(currSum-sum)+1;
                end = i;
                break;
            }

            currSumToIndexMap.put(currSum,i);
        }

        if(end == -1)
            System.out.println("No subarraay present");
        else
            System.out.println(start +" "+end);


    }
}
