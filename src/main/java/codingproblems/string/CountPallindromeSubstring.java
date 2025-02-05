package codingproblems.string;

public class CountPallindromeSubstring {
    public static void main(String[] args) {
        String s = "abccbc";

        Boolean dp[][] = new Boolean[s.length()][s.length()];

        int count = 0;
        String maxString ="";
        int maxLength =0;

        //we will traverse diagnol wise

        for (int g = 0; g < s.length(); g++) {

            for (int i = 0, j = g; j < dp.length; i++, j++) {

                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }

                }

              /*  if (dp[i][j]){
                    count++;
                }*/

               // For longest pallindrom Substring
               if(dp[i][j]){

                   maxLength = g+1;
                   maxString = s.substring(i,j+1);

               }

            }
        }


        System.out.println(count);
        System.out.println("Maximum length paalindrom:   "+maxLength);
        System.out.println("Maximum  pallindrom:  "+maxString);

    }
}
