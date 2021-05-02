import java.util.*;

public class SplitArrayEqualSum {
    public boolean splitArray(int[] nums) {
        if(nums == null || nums.length<6){
            return false;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            sums[i]+=nums[i]+sums[i-1];
        }

        for(int j =3; j<=nums.length-4;j++){
            Set<Integer> set  = new HashSet<>();
            for(int i =1; i<=j-1; i++){
                if(sums[j-1]-sums[i] == sums[i-1]){
                    set.add(sums[i-1]);
                }
            }

            for(int k = j+2; k<nums.length-2;k++){
                if(sums[nums.length-1] - sums[k] == sums[k-1]-sums[j] && set.contains(sums[k-1]-sums[j])){
                    return true;
                }
            }
        }

        return false;
    }
}
