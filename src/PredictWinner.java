import java.util.Arrays;

public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return getScore(nums,0, nums.length-1,sum)>=sum/2;
    }

    private int getScore(int[] nums, int l, int r,int sum ){
        if(l == r){
            return nums[l];
        }
        return Math.max(nums[l]+sum-getScore(nums,l+1, r,sum),nums[r]+sum-getScore(nums,l,r-1,sum));
    }
}
