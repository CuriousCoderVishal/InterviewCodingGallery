public class Bottomline {
    public static void main(String[] args) {
        int a[] = {1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0};
        int sortedArray[] = new int[a.length];
        int k=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
            sortedArray[k++]= a[i];

        }

        for (int i=k+1;i<a.length;i++)
            sortedArray[i] =0;

        for (int i=0;i<sortedArray.length;i++)
            System.out.println(sortedArray[i]);

    }
}
