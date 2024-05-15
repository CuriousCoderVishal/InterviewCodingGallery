package codingproblems.arrays.subarray;

public class KadanesAlgorithm_MaxSumOfSubarray {

    public static void main(String[] args) {
       // int a[]= {-5,4,6,-3,4,-1};
        int a[]= {-5,-4,6,-3,4,-1};

        int currSum = 0;
        int maxSum = 0;
        int ansStart = -1 , ansEnd = -1;

        for (int i=0;i<a.length;i++){

            if(currSum == 0)
                ansStart = i;

            currSum = currSum + a[i];

            if(currSum>maxSum) {
                maxSum = currSum;
                ansEnd = i;
            }

            if (currSum < 0)
                currSum = 0;
        }

        System.out.println(maxSum);
        System.out.println(ansStart+","+ansEnd);
    }

}
