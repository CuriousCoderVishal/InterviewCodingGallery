package secondleginterview.easylevel.subarray;
//only applicable for +ve nos and zero
public class LargestSubarrayWithSumK {
    public static void main(String[] args) {
        int a[] = {1,2,3,1,1,1,1,3,3};
        int k=6;
        int left=0,right=0,sum=0;
        int maxLength=0;
//it is Two pointer technique , where we update left or move it when currentSum exceeds the given sum k and move r till length of array.
        while (right<a.length) {

            //moving the left pointer
            while (sum>k && left<right){
                sum = sum-a[left];
                left++;
            }

            sum=sum+a[right];
            if(sum==k) {
                maxLength=Math.max(maxLength,right-left+1);
            }

            right++;
        }
        System.out.println(maxLength);

    }
}
