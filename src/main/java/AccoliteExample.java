import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccoliteExample {
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,6,2,3,4,1,2,3};

     /*   Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(integerLongEntry -> System.out.println(integerLongEntry.getKey()+"---->"+ integerLongEntry.getValue()));
*/
        Map<Boolean, List<Integer>> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.partitioningBy(integer -> integer % 2 == 0));

        System.out.println("Sum of odd-"+map.get(true).stream().mapToDouble(Integer::intValue).sum());
        System.out.println("Sum of even-"+map.get(false).stream().mapToDouble(Integer::intValue).sum());

    }
    //Ou
}
