/**
 * Created by xhu on 10/23/16.
 */
public class MergeSortedArray {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int i = 0;
        int j = 0;

        while (j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                insert(nums2[j], i, nums1, m);
                i++;
                j++;
                m++;
            } else {
                i++;
            }
        }


    }

    private void insert(int n, int index, int[] nums, int length) {

        for (int i = length - 1; i >= index; i--) {
            nums[i + 1] = nums[i];
        }

        nums[index] = n;
    }
}
