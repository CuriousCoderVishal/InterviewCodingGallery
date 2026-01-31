package secondleginterview;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String brackets = "[{}]({}{}})";

        if(isBalanced(brackets))
            System.out.println("Brackets are Balanced");
        else
            System.out.println("Brackets are not Balanced");

    }
    //
    //Whenever we are traversing the string, we need to check if we encounter a closing bracket
    //                                    1. It has an opening counterpart in stack , means stack is not empty
    //                                    2. if there is opening counterpart, The closing counterpart matches the same or not else return false
    //                                    3. Above two condition statisfies then pop
    //                                    4. Lastly after coming out of the loop , need to check every opening has closing counterpart.
    //                                       means stack is empty at last , then it's balanced
  /*  private static boolean isBalanced(String brackets) {

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<brackets.length(); i++) {
            if(brackets.charAt(i)=='(' || brackets.charAt(i)=='{' || brackets.charAt(i)=='['){
                stack.push(brackets.charAt(i));
            }
            else if(stack.isEmpty() || !((brackets.charAt(i)==')' && stack.peek()=='(') || (brackets.charAt(i)=='}' && stack.peek()=='{') || (brackets.charAt(i)==']' && stack.peek()=='[')) ){
                return false;
            }
            else
                stack.pop();
        }
         return stack.isEmpty();

    }*/

    private static boolean isBalanced(String brackets) {

      Stack<Character> stack = new Stack<>();

      for(int i=0;i<brackets.length();i++){

          if(brackets.charAt(i)=='{'||brackets.charAt(i)=='[' || brackets.charAt(i)=='('){
          stack.push(brackets.charAt(i));
          }
          else if(stack.isEmpty() || !((brackets.charAt(i)==')'&& stack.peek()=='(') || (brackets.charAt(i)=='}' && stack.peek()=='{') ||
                  (brackets.charAt(i)==']' && stack.peek()=='['))){

              return false;

          }
          else

              stack.pop();

      }

      return stack.isEmpty();

    }

}
