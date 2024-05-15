import java.util.*;
import java.util.concurrent.SynchronousQueue;

class Sample4 {

    public static void main(String[] args) {
        int a[] = {25, 52, 88, 41, 14, 69};
        int arr[] = {2, 9, 4, 3, 6};
        int target = 5;

        Map<Integer,Integer> map = new HashMap<>();
       /* Arrays.stream(a)
                .sorted(Comparator.comparing())*/


        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(target-arr[i])){
                System.out.println();
            }



        }

    }
}