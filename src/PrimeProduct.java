import java.util.ArrayList;
import java.util.List;

public class PrimeProduct {
    public List<Integer> PrimeProduct(int[] nums)
    {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return result;
        }

        PrimeProductHelper(result, nums, 1, 0);

        return result;
    }

    private void PrimeProductHelper(List<Integer> result, int[] nums, int sum, int index)
    {


        for (int i = index; i < nums.length; i++)
        {
            result.add(sum * nums[i]);
            PrimeProductHelper(result, nums, sum * nums[i], i + 1);
        }
    }
}
