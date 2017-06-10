import java.util.HashSet;

/**
 * Created by xhu on 10/23/16.
 */
public class ContainsDuplicate {
    //217
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        for (int n : nums) {
            if (set.contains(n)) {
                return false;
            }

            set.add(n);
        }

        return true;
    }


}
