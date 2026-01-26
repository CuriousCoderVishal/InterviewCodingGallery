package secondleginterview;

public class MinLengthGreaterOrEqualtarget {
    public static void main(String[] args) {
        int[] nums = {2,1,5,4,3,2};
        int target = 7;
        int left =0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum =0;

        while (right < nums.length) {
            windowSum += nums[right];

            while (windowSum >= target){
                windowSum = windowSum - nums[left];
                minLength = Math.min(minLength,right-left+1);
                left++;
            }

            right++;
        }

        System.out.println(minLength);

    }
}
