import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer,Integer> maps = new HashMap<>();
        maps.put(0,1);
        int sum = 0;
        int count = 0;

        for(int n:nums){
            sum = sum +n;
            if(maps.containsKey(k-sum)){
                count +=maps.get(k-sum);
            }

            maps.put(sum, maps.getOrDefault(sum,0)+1);

        }

        return count;


    }
}
