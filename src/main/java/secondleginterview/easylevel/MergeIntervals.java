package secondleginterview.easylevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i :intervals){
            //First merge the intervals if (1,3) , (2,6) are overlapping as 3>2
            if(i[0]<=end){
                //Updating end of interval as start will be same as it is sorted, end will be max of second number of both comparing intervals.
                end = Math.max(i[1],end);
            }
            else{
                // If they are not overlapping add the merged to the results and update start and end.
                result.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }

        //Need to add the last interval which is not added here at last
        result.add(new int[]{start,end});

      /*
       Lists in Java don’t directly return primitive arrays.toArray(T[] arr) converts the list into a real array of type T[].
       Here, we want a 2D primitive array (int[][]) as the final result.
       Passing new int[merged.size()][] tells Java exactly:
👉     “I want an array of type int[][] with the correct size.”*/

        int finalResult[][] = result.toArray(new int[result.size()][]);

        for (int i = 0; i < finalResult.length; i++) {
            System.out.println(Arrays.toString(finalResult[i]));
        }

    }
}
