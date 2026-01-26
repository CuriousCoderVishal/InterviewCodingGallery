package secondleginterview;

import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstring {
    public static void main(String[] args) {
        String str = "abcabcbbzxyze";
        int n=str.length();
        int r;
        int l=r=0;
        int max=0;
        int start=0,end=0;

        Map<Character,Integer> map=new HashMap<>();

        while (r<n){
            if(map.containsKey(str.charAt(r))){
                l= Math.max(map.get(str.charAt(r)) + 1,l);
            }
            //max= Math.max(max,r-l+1);
            if(r-l+1>max){
                max=r-l+1;
                start=l;
                end=r;
            }
            map.put(str.charAt(r),r);
            r++;
        }
        System.out.println(max);
        System.out.println(str.substring(start,end+1));

    }
}
