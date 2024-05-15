import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wissen {
    public static void main(String[] args) {
        int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};//i
        int splitSize = 3;

		/* expected Output
		[0, 1, 2]
		[3, 4, 5]
		[6, 7, 8]
		[9]
		*/

        List<int[]> list = splitArray(original, splitSize);
        list.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
    }

    public static List<int[]> splitArray(int[] array, int splitSize) {

        if (array.length < splitSize)
            return List.of(array);

        int index = 0;
        List<int[]> listOfArray = new ArrayList<>();
        int tempArray[] = new int[splitSize];
        int count = 0;
        int traversedIndexed = -1;

        while (index < array.length) {


            tempArray[count++] = array[index];

            if (count == splitSize) {
                listOfArray.add(tempArray);
                count = 0;
                tempArray = new int[splitSize];
                traversedIndexed = index+1;
            }

            index++;
        }

        if (array.length % splitSize != 0) {
            int temp[] = new int[array.length - traversedIndexed ];
            int k = 0;
            for (int i = traversedIndexed; i < array.length; i++)
                temp[k++] = array[i];

            listOfArray.add(temp);
        }

        return listOfArray;

    }
}

// select max(e.salary),e.empId from Employee e  group by e.deptId
