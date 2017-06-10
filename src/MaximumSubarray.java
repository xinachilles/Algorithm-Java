import com.sun.tools.corba.se.idl.InterfaceGen;

/**
 * Created by xhu on 10/23/16.
 */
public class MaximumSubarray {
    // maxmum subarry
    public int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length ==0)
        {
            return 0;
        }

        //maximum subarry for array 0...i equal to sum of  0...i - the min  subbary 0..i-1

        int min = 0;
        int max = Integer.MIN_VALUE;
        int subarray = 0;
        for (int i = 0; i < nums.length; i++)
        {
            subarray = nums[i] + subarray;
            max = Math.max(max, subarray - min);
            min = Math.min(min, subarray);

        }

        return max;
    }
}
