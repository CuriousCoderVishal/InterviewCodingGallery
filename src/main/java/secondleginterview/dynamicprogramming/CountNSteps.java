package secondleginterview.dynamicprogramming;

public class CountNSteps {

/*    A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
    The task is to implement a method to count how many possible ways the child can run up the stairs.

    Examples:

    Input: 4
    Output: 7
    Explanation: There are seven ways: {1, 1, 1, 1}, {1, 2, 1}, {2, 1, 1}, {1, 1, 2}, {2, 2}, {3, 1}, {1, 3}.

    Input: 3
    Output: 4
    Explanation: There are four ways: {1, 1, 1}, {1, 2}, {2, 1}, {3}.*/
    public static void main(String[] args) {


        int steps = 4;
        int dp[] = new int[steps+1];
      //  System.out.println(countWays(steps));
      //  System.out.println(countWaysUsingmemoziation(steps,dp));
        System.out.println(countWaysUsingTabulation(steps,dp));

    }

    private static int countWaysUsingTabulation(int index, int[] dp) {
        //In Tabulation , we go from bottom to Top
        //Step 0. create a dp array with zero base indexing so size will be n, dp[n]
        //Step 1. Look for the base case and assing the value to dp[0]
        //Step 2. Looks for index >  =1 , what are we doing and run a for loop from 1 to n-1

         dp[0] = 1;
         dp[1] = 1;
         dp[2] = 2;
        for (int i = 3; i <= index; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[index];
    }

    private static int countWaysUsingmemoziation(int index,int dp[] ) {


        if(index == 0)
            return 1; //One way to go from zero to zero is jump there itself


        if(dp[index] != 0)
            return dp[index];

        int fs =  countWays(index - 1);

        int secondStep =  0;
        if(index >1)
            secondStep =  countWays(index-2);


        int thirdStep = 0;
        if(index >2)
            thirdStep =  countWays(index-3);

        dp[index] = fs + secondStep + thirdStep;

        return dp[index];
        // T.C : O(N), SC : O(N) + O(N) [Recursion + array]
    }

    private static int countWays(int index) {
        // Note : Recursion is top down, so we are at nth index so we go down fron n to n-1,n-2....
        //1. Represent the problem in terms of index , so the steps are 0,1,2,3...n
        //2. Do all the stuffs mentioned like hopping 1 step, 2 step and 3 step
        //3. For count Sum od all possible stuffs.

        if(index == 0)
            return 1; //One way to go from zero to zero is jump there itself

       int fs =  countWays(index - 1);

       int secondStep =  0;
        if(index >1)
        secondStep =  countWays(index-2);


       int thirdStep = 0;
       if(index >2)
       thirdStep =  countWays(index-3);

       return fs + secondStep + thirdStep;
     // T.c : O(N)
        // S.c : 2^N
    }

    //Using memoziation : overlapping subproblems memoized
    // 1. we will create an array of size dp[n+1], look at the parameters that are changing here index so dp[n]
    // 2.



}
