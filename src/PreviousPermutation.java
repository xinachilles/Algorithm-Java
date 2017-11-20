import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 7/17/17.
 */
public class PreviousPermutation {
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        // write your code
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(nums == null || nums.size() == 0){
            return new ArrayList<Integer>();
        }

        int i = nums.size()-2;
        while(i>=0 && nums.get(i+1)<=nums.get(i)){
            i--;
        }

        if(i>=0){
            int j = i;
            while(j<nums.size() && nums.get(j) >= nums.get(i)){
                j++;
            }

            swap(nums,i,j);
        }

        reverse(i+1,nums.size()-1,nums);
        return result;

    }

    public void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }

    public void reverse(int i, int j, ArrayList<Integer> nums) {
        int start = i;
        int end = j;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
