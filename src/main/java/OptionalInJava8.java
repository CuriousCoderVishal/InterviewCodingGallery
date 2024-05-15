import model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalInJava8 {

    /* TODO: 3 ways to create Optional in java8:
             1. empty()
             2.Of()
             3.OfNullable()*/
    public static void main(String[] args) {

        Employee employee = new Employee(1, "Vishal", 4000000, null,"OSTT");

        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        // Optional<String> dept = Optional.of(employee.getDept());//TODO- can't have parameter which returns null value - throws exception
        //  System.out.println(dept);

        Optional<String> dept1 = Optional.ofNullable(employee.getDept());
        System.out.println(dept1);

        //TODO:Some operations

        Optional<String> dept2 = Optional.ofNullable(employee.getDept());
          /*TODO: The below statement will throw no such element exception as getDept() returns null
                                                     so need to check null before any further operations.*/
        //    System.out.println(dept2.get());
        //TODO- First solution
        if (dept2.isPresent()) {
            System.out.println(dept2.get());
        }

        //TODO Second Solution(if dept is not there and we need to return some default dept value)
        System.out.println(dept2.orElse("Bench"));

        //TODO - If you want to throw an excaeption if dept is not present
        //System.out.println(dept2.orElseThrow(() -> new IllegalArgumentException("no DEPARTMENT FOUND")));

        //TODO - orElseGet(Supplier<T> ) - if we want else block , takes supplier parameter
        System.out.println(dept2.map(String::toUpperCase).orElseGet(() -> "default dept....."));


        //TODO - Optional using stream apis:

        List<Employee> employees = Arrays.asList(new Employee(100, "Vishal", 3500000, "Java","OSTT"),
                new Employee(80, "Mohit", 4500000, null,null),
                new Employee(200, "Abhijit", 5500000, "Analytics","Backend"),
                new Employee(150, "Mukesh", 4500000, "Telecom","Frontend"));

        //Get details of employee having cost centre Frontend

        System.out.println(employees.stream()
                .filter(employee1 -> "Frontend".equals(employee1.getCostCentre()))//.orElseGet(() -> null  )))
                .map(Employee::getName)
                .findAny().orElse("no cost center present with the given value"));


    }
}
