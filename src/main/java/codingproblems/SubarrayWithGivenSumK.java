package codingproblems;

import java.util.HashMap;

public class SubarrayWithGivenSumK {
    public static void main(String[] args) {
        int a[] = {10, 15, -5, 15, -10, 5};
        int sum = 5;
        subarray(a, sum);
    }

    private static void subarray(int[] a , int sum) {

        int start = 0;
        int end = -1;
        int currSum = 0;
        HashMap<Integer, Integer> sumToIndexMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];

            if (currSum == sum) {

                start=0;
                end =i;
                break;

            }

            if(sumToIndexMap.containsKey(currSum-sum)){
                start = sumToIndexMap.get(currSum-sum)+1;
                end =i;
                break;
            }


            sumToIndexMap.put(currSum, i);

        }

        if(end==-1)
            System.out.println("No subarray present");
        else
            System.out.println("startIndex ="+start +" endIndex="+end);

    }
}
