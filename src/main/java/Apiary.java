import java.util.Arrays;

public class Apiary extends Thread {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread thread  = new Thread(runnable);
        thread.start();
        String sentence = "A example of a sentence";
        String search_pattern = "amp";

        String word = "";
        for (int i = 0; i < sentence.length(); i++) {

            char ch = sentence.charAt(i);

            if (ch != ' ') {

                word = word + ch;

            } else {
                if (word.length() >= search_pattern.length()) {
                    int k=0;
                    for (int j = 0; j < word.length(); j++) {

                        if(word.charAt(j)==search_pattern.charAt(k++) && k<word.length()){

                        }
                    }

                    if(k==search_pattern.length()){
                        System.out.println("PAttern Found");
                        break;
                    }

                }

            }
            word ="";

        }
        System.out.println("PAttern Not Found Found");

    }
}
