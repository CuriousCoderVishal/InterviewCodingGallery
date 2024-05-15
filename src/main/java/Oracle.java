/*
import java.beans.JavaBean;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Oracle {
    public static void main(String[] args) {
        List<Integer> integers = List.of();

        integers.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(integerLongEntry -> integerLongEntry.getValue()>5)
                .forEach(integerLongEntry -> System.out.println(integerLongEntry.getKey()+" ---> "+integerLongEntry.getValue()));
    }
    //Assignment
    // AssName personId
   */
/*     Java     1
        C++      1
        Java     2
        python   4*//*


//Person - personId , name
//Assignment - AssName personId

//name of the people count of Assignment of each person

// Select a.PersonId ,p.name , COUNT(a.AssName) AS Number Of Assignments from Person p , Assignment a where p.personId = a.personId
// GROUP BY a.personID;

*/
