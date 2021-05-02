package MOA;

import java.util.HashSet;
import java.util.Set;

public class LargestNum {
    public  int largestNum(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(-nums[i]);
            if(set.contains(nums[i])) {
                res = Math.max(res, Math.abs(nums[i]));
            }
        }
        return res;
    }
}
