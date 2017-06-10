import com.apple.eawt.event.MagnificationEvent;

import java.util.ArrayList;

/**
 * Created by xhu on 11/24/16.
 */
public class MaximumSubarrayII {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() ==0){
            return 0;
        }

         int[] left = new int[nums.size()];
         int local = nums.get(0);
         left[0] = nums.get(0);
         int max = nums.get(0);

         for(int i = 1; i<nums.size();i++){
             if(local +nums.get(i) <nums.get(i)){
                 local= nums.get(i);
             }else{
                 local= local + nums.get(i);
             }

             max =Math.max(local,max);
             left[i] = max;
         }


         int[] right = new int[nums.size()];
         local = nums.get(nums.size()-1);
         right[nums.size()-1] =nums.get(nums.size()-1);
          max = nums.get(nums.size()-1);

        for(int i = nums.size()-2; i>=0; i--){
            if(local +nums.get(i) <nums.get(i)){
                local= nums.get(i);
            }else{
                local= local + nums.get(i);
            }

            max = Math.max(local,max);
            right[i] = max;
        }

        max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.size()-1;i++){
            max = Math.max(left[i]+right[i+1], max);
        }

        return max;

    }
}
