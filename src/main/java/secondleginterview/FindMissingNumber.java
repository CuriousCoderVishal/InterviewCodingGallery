package secondleginterview;

public class FindMissingNumber {
    public static void main(String[] args) {
        int arr[]={1,3,4,5,6};

        //Using XOR , Example of behaviour : 2^2 = 0 , 2^0 = 2

        int Xor1 = 0, Xor2 = 0;
        for (int i=0;i<arr.length;i++){
            Xor1 = Xor1 ^ arr[i];
            Xor2 = Xor2 ^ (i+1);
        }

        System.out.println(Xor1^Xor2);

    }
}
