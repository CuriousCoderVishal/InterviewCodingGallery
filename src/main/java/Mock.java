import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class   Mock {
    public static void main(String[] args) {

        String input ="I am interested to grow in my organization";

      input.chars()
              .mapToObj(Character::toString)
              .filter(s -> !s.equals(" "))
              .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
              .entrySet()
              .stream()
              .filter(stringLongEntry -> stringLongEntry.getValue()==1L)
              .findFirst()
              .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));

    }
}
