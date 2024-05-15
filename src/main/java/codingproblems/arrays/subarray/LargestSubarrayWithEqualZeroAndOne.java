/*
package codingproblems.arrays.subarray;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqualZeroAndOne {
    public static void main(String[] args) {
        int a[] =  {1,1,0,1,1,0,0};
        int currSum =0;
        int start =0,end =-1;

        Map<Integer,Integer> freqMap = new HashMap<>();

        for (int i=0 ; i <a.length;i++){
            if(a[i]==0)
                a[i]=-1;
        }

        for (int i =0 ;i<a.length;i++){

            currSum = currSum + a[i];

            if(currSum == 0){
                start = 0;
                end = i;
                break;
            }

            if()






            freqMap.put(currSum,i);




        }




    }

}
*/
