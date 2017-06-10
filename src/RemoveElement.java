/**
 * Created by xhu on 10/19/16.
 */
public class RemoveElement {
    //27

    /*public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {

            return nums[0] == val ? 0 : 1;
        }

        int nonValIndex = 0;
        int valIndex = nums.length - 1;

        while (nonValIndex < valIndex) {
            if (nums[nonValIndex] != val) {
                nonValIndex++;
                continue;
            }

            if (nums[valIndex] == val) {
                valIndex--;
                continue;
            }


            nums[nonValIndex] = nums[valIndex];
            nums[valIndex] = val;

            nonValIndex++;
            valIndex--;
        }


        return nonValIndex + 1;

    }*/

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int index = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }

        return index+1;

    }
}
