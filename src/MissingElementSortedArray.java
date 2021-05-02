public class MissingElementSortedArray {

    private int calMissingNumber(int value, int index, int n0){
        return value-(n0+index);
    }

    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        // missing[i] is the number of missing element from mums[0] to nums[i]
        int[] missing = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            missing[i] = calMissingNumber(nums[i],i,nums[0]);
        }

        //find the first missing[i] >k and return nums[i]-k-1

        int start = 0;
        int end = missing.length-1;

        while(start+1<end){
            int mid = start + (end-start)/2;
            if(missing[mid] >k){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(missing[start] > k){
            return nums[start]-k-1;
        }

        if(missing[end] > k){
            return nums[end]-k-1;
        }

        return -1;


    }
}
