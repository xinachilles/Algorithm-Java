import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }

        String[] snums = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            snums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(snums,(a,b)->((b+a).compareTo(a+b)));

        if( snums[0].equals("0")) {
            return "0";
        }

        String result = "";
        for(String s: snums){
            result = result+s;
        }

        return  result;

    }
}
