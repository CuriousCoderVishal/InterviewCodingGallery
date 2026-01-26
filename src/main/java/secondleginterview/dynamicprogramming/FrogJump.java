package secondleginterview.dynamicprogramming;

public class FrogJump {
    /*Given an integer array height[] where height[i] represents the height of the i-th stair,
    a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options:
    it can either jump to the (i+1)th stair or the (i+2)th stair.
    The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required
    for the frog to reach the top.

    Example:

    Input: heights[] = [20, 30, 40, 20]
    Output: 20
    Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
    jump from stair 0 to 1: cost = |30 - 20| = 10
    jump from stair 1 to 3: cost = |20-30|  = 10
    Total Cost = 10 + 10 = 20*/

    public static void main(String[] args) {
        int[] height = {20, 30, 40, 20};
        int dp[] = new int[height.length];
        System.out.println(minCost(height,height.length-1));
        System.out.println(minCostUsingMemoziation(height,height.length-1));
    }

    private static int minCostUsingMemoziation(int[] height, int index) {

        if(index == 0)
            return 0; // As going from same index to the same index energy required is zero;

        int left = minCost(height,index-1) + Math.abs(height[index]-height[index-1]);

        int right = Integer.MAX_VALUE;
        if(index>1)
            right = minCost(height,index-2) + Math.abs(height[index]-height[index-2]);


        return Math.min(left,right);


    }

    private static int minCost(int[] height,int index) {

        if(index == 0)
            return 0; // As going from same index to the same index energy required is zero;

       int left = minCost(height,index-1) + Math.abs(height[index]-height[index-1]);

       int right = Integer.MAX_VALUE;
       if(index>1)
           right = minCost(height,index-2) + Math.abs(height[index]-height[index-2]);


       return Math.min(left,right);



    }
}
