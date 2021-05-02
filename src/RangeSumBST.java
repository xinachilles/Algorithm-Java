public class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {

        Helper(root,L,R);
        return sum;
    }

    private void Helper(TreeNode root, int L, int R){
        if(root == null){
            return;
        }
        if (root.val>=L && root.val<=R){
            sum += root.val;
        }
        // if root.val <L no need go to root.left
        if(root.val>=L ){
            Helper(root.left, L,R);
        }

        // if roo.val >R no need got to right
        if(root.val<=R){
            Helper(root.right,L,R);
        }

    }
}
