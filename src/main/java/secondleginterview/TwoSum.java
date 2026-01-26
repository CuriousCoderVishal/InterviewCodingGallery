package secondleginterview;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,7};
        int target = 6;

        Map<Integer,Integer> map = new HashMap<>();

       for (int i = 0; i < arr.length; i++) {
           if(map.containsKey(target-arr[i])){
               System.out.println(arr[i]+" "+map.get(target-arr[i]));
           }
           map.put(arr[i],i);
       }

    }
}
