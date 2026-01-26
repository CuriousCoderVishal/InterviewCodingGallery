package RealTimeStreamProblems;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingProbPractise {
    public static void main(String[] args) {
        String s = "aabbbccdesffggggg";

        System.out.println("---------Print highest frequency character--------");

        s.chars()// it returns IntStream that is integers values which are ASCII codes
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));

        System.out.println("-------------Print second highest frequency character--------");

        s.chars()
                        .mapToObj(Character::toString)
                                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                        .entrySet()
                                                .stream()
                                                        .sorted(Comparator.comparing(Map.Entry<String,Long>::getValue).reversed())
                                                                .skip(1)
                                                                        .findFirst()
                                                                                .ifPresent(System.out::println);









        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
                /*Type Inference Issue:(Can't determine typw)
                Why using Map.Entry<String, Long>::getValue :
                If your stream is not explicitly declared with a generic type, the compiler defaults to Object.
                For example, if you call .entrySet().stream() on a Map that is declared without generics,
                the resulting stream’s element type will be Object.

                 Incorrect Generic Type:
                    The method reference or lambda e -> e.getKey() expects that e is an instance of a class that has a getKey() method (typically Map.Entry<K,V>). If e is inferred as an Object, the compiler cannot find the method.

                */
                /*Type Inference Issue:
                When chaining the .reversed() method,
                the compiler sometimes struggles with type inference.
                It might incorrectly try to resolve Map.Entry::getKey
                as if it were static (which isn’t allowed because getKey() must be called on an instance).*/
                .skip(1)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));


        System.out.println("--------------First non repeating character------------");

        s.chars()
                        .mapToObj(Character::toString)
                                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                        .entrySet()
                                                .stream()
                                                        .filter(stringLongEntry -> stringLongEntry.getValue()==1)
                                                                .findFirst()
                                                                        .ifPresent(System.out::println);







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
