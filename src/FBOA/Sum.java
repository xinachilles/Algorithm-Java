package FBOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 7/9/17.
 */
public class Sum {

    public List<List<Integer>> CombinationSum(int[] nums,int target){
        if(nums == null || nums.length == 0){
            return null;
        }

       List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,target,0,result,new ArrayList<Integer>());
            return  result;

    }

    private void helper(int[] nums,int sum, int target, int index,List<List<Integer>> result, List<Integer> solution){


        if(sum == target){
            if(solution.size()>0){
                result.add(new ArrayList<>(solution));
            }

            return;
        }

        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1] ){
                continue;
            }

            if(sum +nums[i] > target){
                return;
            }

            solution.add(nums[i]);
            helper(nums,sum+nums[i],target,i,result,solution);
            solution.remove(solution.size()-1);
        }
    }
}
