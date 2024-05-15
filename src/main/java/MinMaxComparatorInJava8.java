import model.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxComparatorInJava8 {
    public static void main(String[] args) {

        // list of students
        List<Student> students = Arrays.asList(
                new Student(1, "Viraj", 17),
                new Student(2, "Krishnanand", 18),
                new Student(3, "Rishi", 16),
                new Student(4, "Suresh", 23),
                new Student(5, "Aditya", 21)
        );

        // TODO get student with minimum and max age from list of students

        Student maxAgestudent = students.stream()
                .max(Comparator.comparing(Student::getAge))
                .get();

        System.out.println(maxAgestudent);

        Student minAgestudent = students.stream()
                .max(Comparator.comparing(Student::getAge))
                .get();

        System.out.println(minAgestudent);


        // list of LocalDate
        List<LocalDate> localDates = Arrays.asList(
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(5),
                LocalDate.now().plusMonths(1),
                LocalDate.now().minusMonths(1)
        );

        //TODO get minimum LocalDate
        localDates
                .stream()
                .min(Comparator.comparing(LocalDate::toEpochDay))
               /* TODO-The toEpochDay() method is used in the LocalDate class of Java's java.time package
                     to get the number of days since January 1, 1970 (the Unix epoch) for a given date.
                     It represents a LocalDate in a simplified form as a single long value.*/
                .ifPresent(System.out::println);



        // get minimum LocalDate
        Optional<LocalDate> maxLocalDate = localDates
                .stream()
                .max(Comparator.comparing(LocalDate::toEpochDay));

        // print to console only if present
        maxLocalDate.ifPresent(
                date -> System.out.println("2. The Maximum LoclaDate is = "
                        + date));

    }
}
