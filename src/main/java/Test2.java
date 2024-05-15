import model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(100, "Vishal", 3500000, "Java", "OSTT"),
                new Employee(80, "Mohit", 4500000, null, null),
                new Employee(200, "Abhijit", 5500000, "Analytics", "Backend"),
                new Employee(150, "Mukesh", 4500000, "Telecom", "Frontend"),
                new Employee(151, "Suresh", 4503400, "Telecom", "Frontend"),
                new Employee(154, "Naresh", 2403400, "Analytics", "Frontend"),
                new Employee(144, "Linda", 4403400, "Java", "Frontend"));

      /*  employees.stream()
                .filter(employee -> employee.getId() >= 100)
                .map(employee -> {
                    int currentSalary = employee.getSalary();
                    return currentSalary + currentSalary * 0.1;
                })
                .forEach(aDouble -> System.out.println(aDouble));*/


        System.out.println(employees.stream()
                .filter(employee -> employee.getId() >= 100)
                .collect(Collectors.mapping(employee -> employee.getSalary() + employee.getSalary() * 0.1, Collectors.toList())));
             /*.stream()
                .forEach(aDouble -> System.out.println(aDouble));*/

        //print avg of salaries based on department


        employees.stream()
                .filter(employee -> null != employee.getDept())
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .forEach(stringDoubleEntry -> System.out.println(stringDoubleEntry.getKey() + "--Avg. salary---" + stringDoubleEntry.getValue()));



             /*   employees.stream()
                .filter(employee -> employee.getDept() != null)
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .forEach(stringDoubleEntry -> System.out.println(stringDoubleEntry));
*/
        //TODO: print highest frequency character
        String s = "aabbbbccdesffggggg";


        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry));

        System.out.println("Second Highest frequency character");



        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));

        System.out.println("----First Unique Character in a String----");
        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == 1L)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry));


        String sentence = "This is my world and i love it";
        //TODO: print first highest and second highest length word

        System.out.println("-----------print first highest and second highest length word------------");

        Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresent(s1 -> System.out.println(s1));

        Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(s1 -> System.out.println(s1));


        Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresent(s1 -> System.out.println(s1));

        Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(s1 -> System.out.println(s1));


    }
}
