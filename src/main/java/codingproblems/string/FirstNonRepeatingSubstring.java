package codingproblems.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "abcaabcdbaxayz";
        int l=0,r=0;
        int maxLength =0;
        int n =  s.length();
        String maxLenghtSubstring ="";

        Map<Character,Integer> characterToIndexmap = new HashMap<>();

        while (r < n){

            if(characterToIndexmap.containsKey(s.charAt(r))){
                l = Math.max(characterToIndexmap.get(s.charAt(r))+1,l);
            }


           // maxLength = Math.max(maxLength,r-l+1);
            if(r-l+1 > maxLength){
                maxLenghtSubstring = s.substring(l,r+1);
                maxLength = r-l+1;
            }
            characterToIndexmap.put(s.charAt(r),r);
            r++;


        }

        System.out.println(maxLenghtSubstring);

    }
}
