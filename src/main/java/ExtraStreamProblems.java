import model.Employee;
import model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExtraStreamProblems {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(100, "Vishal", 3500000, "Java", "OSTT"),
                new Employee(80, "Mohit", 4500000, null, null),
                new Employee(200, "Abhijit", 5500000, "Analytics", "Backend"),
                new Employee(150, "Mukesh", 4500000, "Telecom", "Frontend"));


        // todo - Get Intern students(employees whose age greater than 18)

        employees.stream()
                .filter(employee -> employee
                        .getInternStudents()
                        .stream()
                        .anyMatch(student -> student.getAge() > 18))
                .forEach(employee -> System.out.println(employee.getName()));

        // todo - Produce a data map with employee ans student roll no


        employees.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> value
                        .getInternStudents()
                        .stream()
                        .mapToInt(Student::getRollId)
                        .sum()
                )));

    }
}
