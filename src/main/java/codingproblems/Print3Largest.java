package codingproblems;

public class Print3Largest {
    public static void main(String[] args) {
        int arr[] = { 12, 13, 1, 10, 34, 1 };
        int n = arr.length;
        print3largest(arr, n);
    }

    private static void print3largest(int[] arr, int n) {
         int first,second,third;
         third=second=first=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){

            if(arr[i]>first){
                third=second;
                second= first;
                first = arr[i];
            }
            else if(arr[i]>second){
                third= second;
                second=arr[i];
            }
            else if(arr[i]>third){
                third= arr[i];
            }

        }
        System.out.println("First:  " +first+"---Second--"+second+"-- Third  --"+third);
    }
}
