package SegmentTree;

/**
 * Created by xhu on 12/20/16.
 */
public class NumArray {
    BuildSegmentTree segmentTree;
    /*int[] subSum = null;
    public SegmentTree.NumArray(int[] nums) {

        if(nums == null || nums.length ==0){
            return;
        }

        subSum  = new int[nums.length];
        int sum = 0;
        for(int i = 0; i<nums.length;i++){
            sum = sum+nums[i];
            subSum[i] = sum;
        }

    }

    public int sumRange(int i, int j) {
        if(i==0){
            return subSum[j];
        }else {
            return subSum[j] - subSum[i - 1];
        }
        }

    }*/

    public NumArray(int[] nums) {
        segmentTree = new BuildSegmentTree(nums);


    }

    public void update(int i, int val) {
        segmentTree.updae(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);

    }
}

