/**
 * Created by xhu on 10/29/16.
 */
public class ProductArrayExceptSelf {

    // product of array excpet self

    public int[] ProductExceptSelf(int[] nums)
    {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[]  result = new int[nums.length];

        left[0] = 1;


        for (int i = 1; i < nums.length; i++)
        {
            left[i] = left[i - 1] * nums[i - 1];
            result[i] = left[i];
        }

        right[nums.length-1] =1;


        for (int i = nums.length - 2; i >= 0; i--)
        {
            right[i] = right[i+1] * nums[i + 1];
            result[i] *= right[i];
        }

        return right;
    }
}
