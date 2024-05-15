package apexon;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Action {
    public static void main(String[] args) {
     /*   List<Person> people = List.of(new Person(25, "Vishal"),
                new Person(28, "Vaibhav"),
                new Person(40, "Mukesh"),
                new Person(10, "Suresh"));


        people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .forEach(person -> System.out.println(person.getName()));*/

      /*  Check if the braces are complete(balanced):
        1) [{})(]
        2) {}*/

        String s = "[{})(]";
        System.out.println(isBalanced(s));

    }

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (stack.empty() || !((ch == ')' && stack.peek() == '(') ||
                    (ch == '}' && stack.peek() == '{') ||
                    (ch == ']' && stack.peek() == '['))) {

                return false;

            }

            else
                stack.pop();


        }
        return stack.isEmpty();
    }
}
