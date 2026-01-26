package RealTimeStreamProblems;

import model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingProblemsInJava8 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee(100, "Vishal", 3500000, "Finance", "ODTT"),
                new Employee(80, "Mohit", 4500000, "HR", "ODTT"),
                new Employee(200, "Abhijit", 5500000, "Analytics", "ODTT"),
                new Employee(150, "Mukesh", 4500000, "Telecom", "ODTT"));

        //TODO: sort employees base on salary than id(if salaries are same)
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getId).reversed())
                .forEach(employee -> System.out.println(employee.getName() + " Salary-->" + employee.getSalary() + " ID :" + employee.getId()));

        Map<Employee, Integer> employeeAgeMap = Map.of(new Employee(100, "Vishal", 3500000, "Finance", "ODTT"), 350,
                new Employee(80, "Mohit", 4500000, "HR", "ODTT"), 250,
                new Employee(200, "Abhijit", 5500000, "Analytics", "ODTT"), 450,
                new Employee(150, "Mukesh", 4500000, "Telecom", "ODTT"), 650);

        // TODO: sort keys based on employee salary
        System.out.println("sort keys based on employee salary");

        employeeAgeMap.entrySet().stream()
                        .sorted(Comparator.comparing((Map.Entry<Employee,Integer> employeeIntegerEntry) -> employeeIntegerEntry.getKey().getSalary()).reversed())
                                .forEach(employeeIntegerEntry -> System.out.println(employeeIntegerEntry.getKey().getSalary()));


        employeeAgeMap.entrySet()
                .stream()
                //   .sorted(Comparator.comparing(employeeIntegerEntry -> employeeIntegerEntry.getKey().getSalary()))
                // .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(employeeIntegerEntry -> System.out.println(employeeIntegerEntry.getKey().getName()));

        // TODO: sort values
        employeeAgeMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                //.sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(employeeIntegerEntry -> System.out.println(employeeIntegerEntry.getKey()));

        //TODO: print highest frequency character
        String s = "aabbbccdesffggggg";

        System.out.println("print highest frequency character");

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));


        System.out.println("Print second highest frequency character");

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));


                /* s.chars()
                 .mapToObj(Character::toString)
                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                 .entrySet()
                 .stream()
                 //  .filter(stringLongEntry -> stringLongEntry.getValue()==1L)
                 .max(Comparator.comparing(Map.Entry::getValue))
                 //.findFirst()
                 .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));
 */

        System.out.println(s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(stringLongEntry -> stringLongEntry.getKey())
                .orElse("no repeating characters "));

        System.out.println("First non repeating character");

        s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue()==1L)
                .findFirst()
                .ifPresent(stringLongEntry -> System.out.println(stringLongEntry.getKey()));


                List < List < String >> lists = List.of(List.of("MainHoNaa,Border,Gadar"), List.of("Avengers", "Batman", "Joker"));
        //TODO: print list of all movies - Use of Flatmap

        List<String> movies = lists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(movies);


        String sentence = "This is my world and i love it";
        //TODO: print first highest and second highest length word

        System.out.println("-----------print first highest and second highest length word------------");

        /*Arrays.stream(sentence.split(" "))
                        .max(Comparator.comparing(String::length))
                                .ifPresent(s1 -> System.out.println(s1));*/




       /* Arrays.stream(sentence.split(" "))
                .collect(Collectors.toMap(String::toString,String::length))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()) );*/
        //TODO: Without using map

        Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresent(s1 -> System.out.println(s1));

        System.out.println("-----------Print SecondHighest---------------");

      /*  Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length))
                .skip(1)
                .findFirst()
                .ifPresent(s1 -> System.out.println(s1));*/


        Arrays.stream(sentence.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(s1 -> System.out.println(s1));


    }
}
