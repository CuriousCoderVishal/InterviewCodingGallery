package secondleginterview;

public class LargestSubarrayWithSumSmallerOrEqualToK {
    public static void main(String[] args) {
        int arr[]={2,5,1,7,10},k=14;
        // Use sliding window or two pointer

        int l=0,r=0,maxSum=Integer.MIN_VALUE,sum=0;
        int start=0,end=0;

        while (r<arr.length) {
            sum = sum + arr[r];

            if (sum>k){
                sum = sum - arr[l];
                l++;
            }


            if(sum<=k){
               // maxSum = Math.max(maxSum,sum);
               if(sum>maxSum){
                   maxSum=sum;
                   start=l;
                   end=r;
               }
            }
            r++;
        }
        //Sum of the largest subarray with sum<=k;
       System.out.println(maxSum);
        //Subarray with sum <=K
        for (int i=start; i<=end; i++) {
            System.out.println(arr[i]);
        }
    }
}
