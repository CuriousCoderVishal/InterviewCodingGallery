package secondleginterview;

import java.util.HashMap;

public class PemutationString {
    public static void main(String[] args) {
        String s = "aabb";
        s = s.toLowerCase();

        System.out.println(s.substring(1,3)+"-----");

        HashMap<Character,Integer> fmap = new HashMap<>();
        fmap.put(s.charAt(0),fmap.getOrDefault(s.charAt(0),0)+1);

        for (char c:s.toCharArray()){
            if(fmap.containsKey(c)){
                fmap.put(c,fmap.get(c)+1);
            }
            else
                fmap.put(c,1);
        }

        generatePermutation(1,s.length(),fmap,"");
    }

    private static void generatePermutation(int currentSpot, int totalSpot, HashMap<Character, Integer> fmap, String characterSoFar) {

        if(currentSpot > totalSpot){
            System.out.println(characterSoFar);
            return;
        }

        for (char c: fmap.keySet()){
            if(fmap.get(c)>0){
                fmap.put(c,fmap.get(c)-1);
                generatePermutation(currentSpot+1,totalSpot,fmap,characterSoFar+c);
                fmap.put(c,fmap.get(c)+1);
            }
        }

    }
}
