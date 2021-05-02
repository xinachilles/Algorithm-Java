package MOA;

public class MinCost {

    public int getMinCost(String s, int[] nums) {
        if(s == null || s.length() ==0 || nums == null || nums.length ==0){
            return 0;
        }



        int res = 0;
        int sum = nums[0], max = nums[0];
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                res += sum - max;
                sum = nums[i];
                max = nums[i];
            }else {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            }
        }
        res += sum - max;
        return res;
    }

}
