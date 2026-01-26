package secondleginterview.easylevel;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
       int arr[] = {1, 1, 2, 1, 3, 5, 1,2,2,2,2,2,2,2};

       HashMap<Integer, Integer> fmap = new HashMap<>();

       for (int i = 0; i < arr.length; i++) {
          // System.out.println(arr[i]);
           fmap.put(arr[i],fmap.getOrDefault(arr[i],0)+1);

           if (fmap.get(arr[i])> arr.length/2){
               System.out.println(arr[i]);
               break;
           }


       }

       // Approach 2
       for(Map.Entry<Integer, Integer> entry : fmap.entrySet()){
           if(entry.getValue() > arr.length/2){

               System.out.println(entry.getKey());
               break;
           }
       }



 //Approach 3
     fmap.entrySet()
             .stream()
             .filter(e -> e.getValue() > arr.length/2)
             .findFirst()
             .ifPresent(e -> System.out.println(e.getKey()));


    }
}
