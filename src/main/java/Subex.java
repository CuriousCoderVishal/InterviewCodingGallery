import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Subex {
    public static void main(String[] args) {

        List<Integer> list = List.of(4, 4, 1, 5, 5, 5, 5, 7, 7, 7, 2, 2, 2);

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).thenComparing(Map.Entry::getKey).reversed())
                .forEach(integerLongEntry -> System.out.println(integerLongEntry.getKey() + "--Frequency: " + integerLongEntry.getValue()));

    }
}
