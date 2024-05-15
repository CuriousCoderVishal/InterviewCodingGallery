package codingproblems.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String strings[] = {"act", "cat", "tac", "job", "boj"};

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strings) {

            char characters[] = word.toCharArray();

            Arrays.sort(characters);

            String sortedWord = new String(characters);

            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord,list);
            }


        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());

        System.out.println(result);

    }
}
