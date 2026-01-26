package secondleginterview.recursion;

import java.util.ArrayList;
import java.util.List;

public class Peermutation {
    public static void main(String[] args) {
        int a[] = {1,2,3};

        permute(0,a);
    }

    private static void permute(int index, int[] a) {

        if(index == a.length){

            List<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < a.length; i++) {
                list.add(a[i]);
            }

            System.out.println(list);

            return;
        }

        for(int i = index; i < a.length; i++){
            swap(index,i,a);
            permute(index+1,a);
            swap(index,i,a);

        }
    }

    private static void swap(int i, int j, int[] a) {
       int temp = a[i];
       a[i]=a[j];
       a[j]=temp;
    }
}
