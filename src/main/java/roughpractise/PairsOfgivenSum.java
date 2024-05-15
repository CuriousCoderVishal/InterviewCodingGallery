package roughpractise;

import java.util.HashMap;
import java.util.Map;

public class PairsOfgivenSum {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 3, 4, 5, 6, 4, 7};
        int X = 6;
        int count = 0;

        Map<Integer,Integer> integertoUseMap =  new HashMap<>();

        for (int i =0 ;i<a.length;i++){

            int n2 = X - a[i];

            if (integertoUseMap.containsKey(n2) && integertoUseMap.get(n2)!=null){

                System.out.println(a[i] +","+n2);
                integertoUseMap.put(a[i],null);
                integertoUseMap.put(n2,null);
                count++;

            }
            else
                integertoUseMap.put(a[i],a[i] );
        }
        System.out.println(count);
    }
}
