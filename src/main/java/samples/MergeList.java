package samples;

import java.util.List;
import java.util.stream.Collectors;

public class MergeList {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 56, 6, 7, 8);

        System.out.println(list.stream()
                .map(integer ->
                        (integer % 2 != 0) ? integer + 1 : integer
                )
                .collect(Collectors.averagingDouble(Integer::doubleValue)));

    }
}
