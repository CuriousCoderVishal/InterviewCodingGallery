import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mockfinal {
    public static void main(String[] args) {

      /*  Runnable runnable = () -> {
          System.out.println("This is new thread");
        };

         Thread t1= new Thread(runnable);
         t1.start();

         Given a string, find the words with the maximum number of vowels.
         "The quick brown fox jumps right over the little lazy dog."
       */

        String sentence = "the quick brown fox jumps right over the little lazy dog";

        Arrays.stream(sentence.split(" "))
                .distinct()
                .collect(Collectors.toMap(Function.identity(), s -> getNoOfVowels(s)))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
                //    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
               // .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
               // .max(Comparator.comparing(Map.Entry::getValue))
                .skip(1)
                .findFirst()
                .ifPresent(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));
      /*  sentence.chars()
                .mapToObj(Character::toString)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((s, aLong) -> System.out.println(s+"-->"+aLong));*/

      /*  String s = "my name is vishal and i am a software engineer";

        Arrays.stream(s.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresent(s1 -> System.out.println(s1));*/

        List<Student> students = Arrays.asList(
                new Student("Alice", "Math", 85),
                new Student("Bob", "Math", 92),
                new Student("Bob", "Math", 92),
                new Student("Charlie", "Math", 78),
                new Student("Alice", "Science", 90),
                new Student("Bob", "Science", 88),
                new Student("Charlie", "Science", 82),
                new Student("Alice", "English", 78),
                new Student("Bob", "English", 95),
                new Student("Charlie", "English", 85));


        AtomicInteger rank = new AtomicInteger(1);
        students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getMarks)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(stringDoubleEntry -> System.out.println("Student name-" + stringDoubleEntry.getKey() + ", Average Marks-" + stringDoubleEntry.getValue()
                        + ",Rank: " + rank.getAndIncrement()));


    }

    public static int getNoOfVowels(String s) {
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++;
        }
        return count;
    }
}

class Student {
    String name;
    String subject;
    int marks;

    public Student(String name, String subject, int marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
