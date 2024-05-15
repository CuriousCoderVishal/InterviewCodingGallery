import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingProbPractise {
    public static void main(String[] args) {
        String s = "aabbbccdesffggggg";

        System.out.println("---------Print highest frequency character--------");

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));

        System.out.println("-------------Print second highest frequency character--------");

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));


        System.out.println("--------------First non repeating character------------");

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == 1L)
                .findFirst()
                .ifPresent(System.out::println);


    }
}
