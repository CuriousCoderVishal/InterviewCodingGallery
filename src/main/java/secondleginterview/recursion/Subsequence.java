package secondleginterview.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        int a[] = {3,1,2};
        List<Integer> list = new ArrayList<>();
        printSubsequence(0,a.length,a,list);
    }

    private static void printSubsequence(int i, int n, int[] a,List<Integer> list) {

        if(i>=n){
            System.out.println(list);
            return;
        }

        list.add(a[i]);
        printSubsequence(i+1,n,a,list);
        list.remove(list.size()-1);
        printSubsequence(i+1,n,a,list);


    }
}
