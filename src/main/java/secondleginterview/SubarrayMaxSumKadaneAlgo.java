package secondleginterview;

public class SubarrayMaxSumKadaneAlgo {
    public static void main(String[] args) {
        int arr[] ={-2,1,-3,4,-1,2,1,-5,4};//{-2,1,-3,4,-1,2,1,-5,4};
        //max sum =6;
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];

            maxSum = Math.max(sum,maxSum);

            if(sum<0)
                sum=0;

        }
        System.out.println(maxSum);
    }
}
