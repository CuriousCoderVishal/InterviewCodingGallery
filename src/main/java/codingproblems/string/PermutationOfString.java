package codingproblems.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "aabb";

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (!frequencyMap.containsKey(c)) {
                frequencyMap.put(c, 1);
            } else {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            }

        }

        generatePermutation(1,s.length(),frequencyMap,"");


    }

    private static void generatePermutation(int cs, int ts, Map<Character, Integer> frequencyMap, String asf) {

        if(cs>ts){
            System.out.println(asf);
            return;
        }


        for (char ch : frequencyMap.keySet()){

            if(frequencyMap.get(ch) > 0){

                frequencyMap.put(ch,frequencyMap.get(ch)-1);
                generatePermutation(cs+1,ts,frequencyMap,asf+ch);
                frequencyMap.put(ch,frequencyMap.get(ch)+1);

            }

        }


    }


}
