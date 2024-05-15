import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoxingInJava8 {
    public static void main(String[] args) {

       /* In Java 8's Stream API, the .boxed() method is used to convert a stream of primitive data types
        (like int, long, double, etc.) into a stream of their corresponding wrapper classes
        (like Integer, Long, Double, etc.).

        This is useful when you want to perform operations
        that are available for objects but not directly for primitives, as well as when you need
        to work with methods that expect object references.*/

        int arr[] = {1, 2, 3, 4, 5};

        List<Integer> integers = Arrays.stream(arr)
                .filter(i -> i % 2 == 0)
                .boxed()// Converting int primitive type to its Wrapper class Integer - as List<Integer> is needed.
                .collect(Collectors.toList());
        System.out.println(integers);

    }
}
