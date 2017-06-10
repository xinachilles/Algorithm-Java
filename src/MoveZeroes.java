/**
 * Created by xhu on 10/23/16.
 */
public class MoveZeroes {

    /*public void moveZeroes(int[] nums)
    {
        if(nums ==null || nums.length == 0){
            return;

        }

        int start  = 0;
        int end = nums.length-1;

        while(start <end){
            while(start <end && nums[start] !=0 ){
                start++;
            }

            while (start<end && nums[end] ==0){
                end--;
            }

            if(start>=end){
                break;
            }


            nums[start]= nums[end];
            nums[end] = 0;
        }
    }*/

    // move zero

    public void moveZeroes(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return;
        }


        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                continue;
            }
            int j = 0;
            for (; j<i;j++)
            {
                if (nums[j] == 0)
                {
                    break;
                }
            }

            if (j <i && nums[j] == 0)
            {
                int temp = nums[i];
                nums[j] = temp;
                nums[i] = 0;
            }
        }
    }
}
