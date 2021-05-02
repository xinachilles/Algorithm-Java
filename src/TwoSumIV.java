public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        if( findTarget(root, root, k-root.val)){
            return true;
        }

        return false;
    }

    private boolean findTarget(TreeNode root, TreeNode current, int k){
            return false;
    }

    private boolean findValue(TreeNode root, TreeNode original, int target){
        if(root == null){
            return false;
        }

        if(root.val == target ){
            if(root != original){
                return true;
            }else{
                return false;
            }
        }

        if(target <root.val){
            return findTarget(root.left, original, target);
        }else{
            return findTarget(root.right,original,target);
        }
    }
}
