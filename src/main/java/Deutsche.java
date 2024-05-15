import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Deutsche {
    public static void main(String[] args) {
        String s = "({[[})}}}}}}";

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

     List<String> stringList =   list.stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> String.valueOf(integer))
                .collect(Collectors.toList());

     //  System.out.println(checkBalanced(s));
    }
    private static boolean checkBalanced(String s) {// stack =  {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.empty() || !(ch == '}' && stack.peek() == '{' || ch == ')' && stack.peek() == '(' || ch == ']' && stack.peek() == '[')) {
                    return false;
                } else
                    stack.pop();
            }
        }

        return stack.empty() ? true : false;


    }
}
