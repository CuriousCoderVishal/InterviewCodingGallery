import javax.persistence.criteria.CriteriaBuilder;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {
          /* Stream Terminal Operations
           • Terminal Operations collects the data for you.
           • Terminal Operations starts the whole stream pipeline.
           • Terminal Operations:
           • forEach()
           • min()
           • max()
           • reduce()
           • collect() and etc.*/

      /* TODO: Collectors.joining() method is used to concatenate elements of a stream into a single string.
                It allows you to customize the delimiter, prefix, and suffix to be used while joining the elements.*/
        List<String> fruits = List.of("apple", "banana", "cherry", "date");

        // Join elements with a comma delimiter
        String commaSeparated = fruits.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Comma separated: " + commaSeparated);

        // Join elements with a semicolon delimiter, prefix, and suffix
        String customJoined = fruits.stream()
                .collect(Collectors.joining("; ", "Fruits: ", " are delicious!"));

        System.out.println(customJoined);


        // TODO: counting() Collector returns the total number of elements as a result
        System.out.println(fruits.stream()
                .collect(Collectors.counting()));

        // TODO: The mapping() collector in Java 8's Stream API is used to transform the elements of a stream before collecting them into a collection.
     /*  TODO In Java's Stream API, the Collectors.mapping() method is used in combination with other collectors to perform
             a transformation on the elements of a stream before collecting them into a collection.
             It's particularly useful when you want to apply a mapping function to each element and then collect the results.*/
        System.out.println("The mapping() collector in Java 8's Stream API is used to : ");
        System.out.println(fruits.stream()
                .collect(Collectors.mapping(t -> t + "_GoodQuality", Collectors.toList())));

      /*   TODO : Terminal Operations – maxBy() , minBy()
                • Comparator as an input parameter and Optional as an output.
              • maxBy()
                • This collector is used in conjunction with comparator. Returns the max
                  element based on the property passed to the comparator.
              • minBy()
                • This collector is used in conjunction with comparator. Returns the
                   smallest element based on the property passed to the comparator.*/
        System.out.println(fruits.stream()
                .max(Comparator.comparing(String::length)).get());// TODO i/p - Comparator ,o/p - Optional

        System.out.println(fruits.stream()
                .min(Comparator.comparing(String::length)).get());


  /*      TODO: • summingInt() – this collector returns the sum as a result.
                averagingInt() – this collector returns the average as a result*/
        //Getting the average of strings' length
        fruits.stream()
                .map(String::length)
                .collect(Collectors.averagingInt(Integer::intValue));

        //Getting the sum of strings' length
        fruits.stream()
                .map(String::length)
                .collect(Collectors.summarizingInt(Integer::intValue));

       /* TODO: groupingBy()
            • groupingBy() collector is equivalent to the groupBy() operation in SQL.
              • Used to group the elements based on a property.
              • The output of the groupingBy() is going to be a Map<K,V>
                There are three different versions of groupingBy().
                  • groupingBy(classifier) - Groups elements of a stream into a map where keys are the result of the classifier function, and values are lists of elements that share the same key.
                  • groupingBy(classifier,downstream) -This variation allows you to specify a downstream collector for further aggregation of the grouped elements.
                  • groupingBy(classifier,supplier,downstream) -This variation allows you to specify a supplier for the map.*/


        System.out.println("Example -------- groupingBy(classifier)");

        Map<Integer, List<String>> firstLetterMap = fruits.stream()
                .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(firstLetterMap);

        Map<Integer, Long> characterLongMap = fruits.stream()
                .collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));

        System.out.println(characterLongMap);

        System.out.println("Example --------- • groupingBy(classifier,supplier,downstream) ");

        Map<Integer, List<String>> characterListMap = fruits.stream()
                .collect(Collectors.groupingBy(s -> s.length(), LinkedHashMap::new ,Collectors.toList()));
        System.out.println(characterListMap);


      /*  TODO : • partitioningBy() - collector is used to partition elements of a stream into two
                     groups based on a given predicate. It creates a map with two keys: true and false, where the true key corresponds
                    to elements that satisfy the predicate, and the false key corresponds to elements that do not..
                 • paritioningBy() accepts a predicate as an input.
                 • Return type of the collector is going to be Map<K,V>
                 • The key of the return type is going to be a Boolean.
                 • There are two different versions of partitioningBy()
                 • partitioningBy(predicate)
                 • partitioningBy(predicate,downstream) // downstream -> could be of any
                         collector example - Suppose you have a list of Person objects,
                                            and you want to partition them into two groups: adults (age >= 18)
                                            and minors (age < 18), and for each group, you want to collect their names into a list:*/


        Map<Boolean, List<String>> booleanListMap = fruits.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 4));

        System.out.println(booleanListMap.get(true));
        System.out.println(booleanListMap.get(false));

        System.out.println("------");
        Map<Boolean, List<Integer>> map = fruits.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 4, Collectors.mapping(String::length, Collectors.toList())));

        System.out.println(map);

        Map<Boolean,List<String>> mapFruits = fruits.stream()
                .collect(Collectors.partitioningBy(s -> s.length()>5));




    }
}
