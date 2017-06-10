/**
 * Created by xhu on 1/11/17.
 */
public class SumLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root ==null){
            return 0;
        }

        return sumOfLeftLeavesHelper(root,false);
    }

    private int sumOfLeftLeavesHelper(TreeNode root, boolean isLeft){
        if(root ==null){
            return 0;
        }

        if(root.left ==null && isLeft){
            return root.val;
        }

        int left = sumOfLeftLeavesHelper(root.left,true);
        int right = sumOfLeftLeavesHelper(root.right,false);

        return left+right;

    }

}
