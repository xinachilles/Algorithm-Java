/**
 * Created by xhu on 3/3/17.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] maxZero = new int[nums.length];
        int[] maxOne = new int[nums.length];

        if(nums[0] == 0){
            maxZero[0] = 1;
        }else{
            maxOne[0]= 1;
        }

        for(int i = 1; i<nums.length; i++){
            maxZero[i] = maxZero[i-1];
            maxOne[i] = maxOne[i-1];
            if(nums[i] == 0){
                maxZero[i] = maxZero[i-1]+1;
            }else{
                maxOne[i] = maxOne[i-1]+1;
            }
        }

        int max = Integer.MIN_VALUE;
        int local = 0;
        for(int i = 1; i<nums.length; i = i+2){
            if(maxOne[i] == maxZero[i-1] || maxZero[i]==maxOne[i-1]){
                local = local+2;
            }else{
                local = 0;
            }

            max = Math.max(local,max);
        }

        return max;



    }
}
