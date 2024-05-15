package codingproblems;

import java.util.HashSet;

public class MiisingNumber {
    public static void main(String[] args) {
        int a[] ={2,1,3,7,5,4};

        int n= a.length,target;
       /* int sum = n *(n+1)/2;

        for (int i=0;i<a.length;i++){
            sum = sum - a[i];
        }
        System.out.println(sum);*/

        HashSet<Integer> integers = new HashSet<>();

        for (int num :a){
          integers.add(num);
        }

        for (int i = 1 ;i<=a.length+1;i++){
            if(!integers.contains(i)) {
                System.out.println(i);
                break;
            }
        }


    }
}
