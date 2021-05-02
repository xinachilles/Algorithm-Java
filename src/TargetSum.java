import java.util.Arrays;

/**
 * Created by xhu on 7/9/17.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum<S){
            return 0;
        }

        int[][]ways = new int[nums.length][2*sum+1];
        for(int[] way: ways){
            Arrays.fill(way, -1);
        }

        helper(nums,0,sum,0,S,ways);
        return ways[nums.length-1][S+sum];
    }

    private int helper(int[] nums, int index, int offset,int currentSum, int S, int[][]ways){
        if(index >nums.length){
            return 0;
        }

        if(currentSum >S || currentSum <-S){
            return 0;
        }

        if(index == nums.length){
            if(S == currentSum){
                return 1;
            }else{
                return 0;
            }
        }


        if(ways[index][currentSum+offset] >=0){
            return ways[index][currentSum+offset];
        }

        ways[index][currentSum+offset] = helper(nums,index+1,offset,currentSum+nums[index],S,ways)+
                helper(nums,index+1,offset,currentSum-nums[index],S,ways);

        return ways[index][currentSum+offset];


    }


}
