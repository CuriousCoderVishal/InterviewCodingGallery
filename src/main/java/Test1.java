import model.Employee;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Employee> employees = List.of();

        //second highest salary
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(employee -> System.out.println(employee.getSalary()));

        //male - avg salary , female - avg salary
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)))
                .forEach((s, aDouble) -> System.out.println(s+"Average Salary -"+aDouble));

        //First non repeating character
        String s = "abcaab";

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue()==1L)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));



    }
}
