package secondleginterview;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Examples {
    public static void main(String[] args) {
       List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
/*
                 integers.stream()
                .filter(i->i%2==0)
                .forEach(System.out::println);
*/

        String s = "aabbbccdesfffggggg";

        /*Print highest frequency character*/

        s.chars()
                        .mapToObj(Character::toString)
                                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                        .entrySet()
                                                .stream()
                                                        .max(Comparator.comparing(stringLongEntry -> stringLongEntry.getValue()))
                                                                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));


        System.out.println("----same value----");

        System.out.println(s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get().getKey());

        /*Print second highest frequent character*/

        s.chars()
                        .mapToObj(Character::toString)
                                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                        .entrySet()
                                                .stream()
                                                        .sorted(Comparator.comparing(Map.Entry<String,Long>::getValue).reversed())
                                                                .skip(1)
                                                                        .findFirst()
                                                                                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getValue()));






        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String,Long>::getValue).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));

        /*Print first non-repeating character*/

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue()==1)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));




    }
}
