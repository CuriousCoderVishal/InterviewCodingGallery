package secondleginterview;

public class RecursionNtimes {

    public static void main(String[] args) {
        int n =6;
         printNameNtimes(n);
    }

    private static void printNameNtimes(int n) {
        if(n==0) {
            return;
        }
        System.out.println("Vishal");

        printNameNtimes(n-1);

    }


}
