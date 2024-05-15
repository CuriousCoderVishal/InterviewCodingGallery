package codingproblems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfPairsForGivenSum {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 3,3,3, 4, 5, 6, 4, 7};
        int X = 6;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<List<Integer>> pairs = new ArrayList<>();

      /*  for (int i=0; i<a.length;i++){
            if(!frequencyMap.containsKey(a[i]))
                frequencyMap.put(a[i],1);
            else
                frequencyMap.put(a[i], frequencyMap.get(a[i])+1);
        }*/
      /*  int a[] = {1, 2, 3, 3, 4, 5, 6, 4, 7};
        int X = 6;*/

        int ts = 0;
        for (int i = 0; i < a.length; i++) {
            int n2 = X - a[i];
//Two things checked here : 1. Other pair exist or not and 2. Used or not previously.
            if (frequencyMap.containsKey(n2) && frequencyMap.get(n2) != null) {
                System.out.println(a[i] + "," + n2);
                frequencyMap.put(n2, null);
                frequencyMap.put(a[i], null);
                //   ts = ts + frequencyMap.get(n2);
            } else
                frequencyMap.put(a[i], a[i]);

           /* if(n2 == a[i])
                ts --;*/
        }

        //  System.out.println(ts/2);


    }
}
