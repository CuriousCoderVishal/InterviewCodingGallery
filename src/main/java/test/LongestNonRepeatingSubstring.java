package test;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "abcaacxyzkolp";

        System.out.println(lengthOftheLongestSubstring(s));
    }

    private static int lengthOftheLongestSubstring(String s) {

        int l=0,r=0,maxLength=0;

        HashMap<Character,Integer> characterToIndexMap = new HashMap<>();

        while (r<s.length()){

            if(characterToIndexMap.containsKey(s.charAt(r))){
                l = Math.max(characterToIndexMap.get(s.charAt(r))+1,l);
            }


            maxLength = Math.max(maxLength,r-l+1);
            characterToIndexMap.put(s.charAt(r),r);

            r++;
        }

        return maxLength;

    }


}
