public class BottomlineString {
    public static void main(String[] args) {
        String s = "abvvgbhffghyhh";
        //String s = "ayhh";
        int frequency = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            char currentCharacter = s.charAt(i);

            if (currentCharacter == s.charAt(i + 1)) {
                frequency++;
            }

            if (frequency > 0) {
                System.out.println(currentCharacter + "--frequency:" + (frequency + 1));
                frequency = 0;
            }
        }
    }
}

