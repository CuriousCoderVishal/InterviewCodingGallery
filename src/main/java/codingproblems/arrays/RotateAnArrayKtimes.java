package codingproblems.arrays;

public class RotateAnArrayKtimes {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        int k = 4;
        rotate(a,k);

        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+",");

    }

    private static void rotate(int[] a, int k) {
        k=k % a.length;// 101 % 5 = 1 , so if you rotate array by 101 times or 1 time answer will be same

        if(k<0)
            k = k+a.length;// negative rotaion is equal to negative rotaion plus length of array
                           // exmple -1 = 4 (a.length + k i.e., 5 -1 =4).

        //Reverse First part
        reverse(a,0,a.length-k-1);

        //Reverse Second Part
         reverse(a,a.length-k,a.length-1);

        //Reverse whole array
        reverse(a,0,a.length-1);

    }

    private static void reverse(int[] a, int startIndex, int endIndex) {
       while (startIndex<endIndex){
           int temp = a[startIndex];
           a[startIndex] = a[endIndex];
           a[endIndex] = temp;

           startIndex++;
           endIndex--;
       }
    }


}
