import java.util.Arrays;

/**
 * Created by xhu on 1/18/17.
 */
public class TriangleCount {
    public int triangleCount(int[] nums){
        if(nums ==null){
            return 0;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(i == start|| i == end){
                continue;
            }

            while(start<end){
                int s = nums[start] +nums[end];
                if(s<=nums[i]){
                    start++;
                }else{
                    count+=end-start;
                    end--;
                }
            }
        }

        return count;
    }

}
