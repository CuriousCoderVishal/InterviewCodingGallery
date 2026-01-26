package secondleginterview.easylevel;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutReapeatinCharacters {
    public static void main(String[] args) {
       // String input =  "cadbzabcd";
        String input =  "aabcdefa";

        int l=0,r=0;

        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;

        while (r < input.length()){

            if(map.containsKey(input.charAt(r))){
                // "cadbzabcd"; ; here c has two position when l is at z and c comes , we need the max previous c position and current l position to update l value
                l= Math.max(map.get(input.charAt(r))+1,l);
            }

            if(r-l+1>maxLength){
                maxLength = r-l+1;
                startIndex = l;
                endIndex = r;
            }
            map.put(input.charAt(r),r);
            r++;
        }
        System.out.println(maxLength);
        System.out.println(startIndex);
        System.out.println(endIndex);
        System.out.println(input.substring(startIndex,endIndex+1));

    }
}
