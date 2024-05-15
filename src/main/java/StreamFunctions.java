import java.util.List;
import java.util.stream.Collectors;

public class StreamFunctions {
    public static void main(String[] args) {
        List<Integer> integers = List.of(4,5,3,2,7,6,8);

        //Use of limit()
        System.out.println(integers.stream()
                .filter(integer -> integer%2==0)
                .limit(2)
                .collect(Collectors.toList()));

        //Use of skip()
        System.out.println(integers.stream()
                .filter(integer -> integer%2!=0)
                .skip(2)
                .collect(Collectors.toList()));

        //Use of anyMatch() - if any element matches the predicate condition
        System.out.println("--------Example of AnyMatch------");
        System.out.println(integers.stream()
                .anyMatch(integer -> integer%5==0));//Takes Predicate parameters
        //TODO - Real Time example
      /*  TODO - Get Intern students(employees whose age greater than 18)
            employees.stream()
                .filter(employee -> employee
                        .getInternStudents()
                        .stream()
                        .anyMatch(student -> student.getAge()>18))
                .forEach(employee -> System.out.println(employee.getName()));*/


        //Use of allMatch() - if all elements matches the predicate condition
        System.out.println(integers.stream()
                .allMatch(integer -> integer>0));// all elements are postive

        //Use of noneMatch() - if all elements doesn't  match the predicate condition
        System.out.println(integers.stream()
                .noneMatch(integer -> integer<0));// none of the elements are negative

        //findFirst() -method returns the first element in the stream ,
        //             If no element matches the condition, it returns an empty Optional.
        //             It is deterministic and always returns the first element encountered in the stream's encounter order.
        //        TODO :     It is typically used with ordered streams or when order matters.

        System.out.println(integers.stream()
                .filter(integer -> integer%2==0)
                .findFirst()
                .orElse(-1));

     /* findAny():
        The findAny() method returns any element in the stream that satisfies the given condition (predicate), if any. If no element matches the condition, it returns an empty Optional.
       TODO It is ** non-deterministic ** and might return different elements each time it is called, especially when used with parallel streams. It is optimized for parallel processing.
        It is typically used when you ** don't care about the order of elements ** and just need any element that matches the condition.*/

        System.out.println(integers.stream()
                .filter(integer -> integer%2!=0)
                .findAny()
                .orElse(-1));

       /* TODO:Streams API Short Circuit
       TODO: functions - All these functions does not have to iterate the whole stream
                     to evaluate the result
           - limit()
           -findFirst()
            findAny()
           -anyMatch()
            allMatch()
             noneMatch()*/

       /* TODO: Stateful functions  - rely on order or history of elements - Maintains internal state .
            • distinct()
            • sorted()
            • skip()
            • limit()
            Example - public static List<String> printUniqueStudentActivities() {
                        List<String> studentActivities = StudentDataBase.getAllStudents() .stream()
                        .map(Student::getActivities)
                        .flatMap(List::stream)
                        .distinct() // needs the state of the previously processed elements .sorted()
                         // needs the state of the previously processed elements
                         .collect(toList()); return studentActivities;

        • TODO:Stateless functions - doesn't  rely on order or history of elements - Doesn't Maintains internal state
           • map()
           • filter(), etc.,

           Example - private static List<String> namesUpperCase(List<Student> names){
                 List<String> namesUpperCase = names.stream() //Stream<Student>
                 .map(Student::getName) //Stream<String> - stateless
                 .map(String::toUpperCase) // Stream<String> -> UpperCase - stateless
                 .collect(toList()); // returns List - stateless
                 return namesUpperCase
                  */

       /* Stream Terminal Operations
           • Terminal Operations collects the data for you.
           • Terminal Operations starts the whole stream pipeline.
           • Terminal Operations:
           • forEach()
           • min()
           • max()
           • reduce()
           • collect() and etc.*/

      /* TODO: Collectors.joining() method is used to concatenate elements of a stream into a single string.
                It allows you to customize the delimiter, prefix, and suffix to be used while joining the elements.*/
        List<String> fruits = List.of("apple", "banana", "cherry", "date");

        // Join elements with a comma delimiter
        String commaSeparated = fruits.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Comma separated: " + commaSeparated);

        // Join elements with a semicolon delimiter, prefix, and suffix
        String customJoined = fruits.stream()
                .collect(Collectors.joining("; ", "Fruits: ", " are delicious!"));

        System.out.println(customJoined);



    }
}
