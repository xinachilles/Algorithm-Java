public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <end) {
            int mid = start + (end - start) / 2;
            boolean even = (end-mid)%2 == 0;
            if (nums[mid] == nums[mid - 1]) {
                    // if right side has even number ( not inclusive mid point),signal number should be
                    // in the left side
                    if(even) {
                        end = mid - 2; // skip the duplicate one
                    } else {
                        // the single point is in the right side
                        start = mid + 1;
                    }
                } else if(nums[mid] == nums[mid+1]) {
                    // mid point equal to the right side

                    if (even) {
                        //right side has even number, since right side has the duplicate number
                        //the signal number should in the right side
                        start = mid + 2; // skip the duplicate number
                    } else {
                        end = mid - 1;
                    }
                }
            }

        return nums[start];


    }


}
