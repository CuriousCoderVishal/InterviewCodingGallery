package codingproblems;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcaacxyzkolp";

        System.out.println(lengthOftheLongestSubstring(s));
    }

    private static int lengthOftheLongestSubstring(String s) {

        int l = 0, r = 0, n = s.length(), maxLength = 0;

        HashMap<Character, Integer> charaterToIndexMap = new HashMap<Character,Integer>();

        while (r < n) {

            if (charaterToIndexMap.containsKey(s.charAt(r))) {
                l = Math.max(charaterToIndexMap.get(s.charAt(r)) + 1, l);
            }
            maxLength = Math.max(r - l + 1, maxLength);
            charaterToIndexMap.put(s.charAt(r), r);
            r++;
        }

        return maxLength;

    }
}
