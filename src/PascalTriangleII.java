import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class PascalTriangleII {
    // pascal triangel

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }

        Integer[] nums = new Integer[rowIndex + 1];
        nums[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            int col = i + 1;

            for (int j = col - 2; j >= 1; j--) {
                int num = nums[j] + nums[j - 1];


                nums[j] = num;
            }

            nums[0] = 1;
            nums[col - 1] = 1;
        }

        return Arrays.asList(nums);
    }


}


