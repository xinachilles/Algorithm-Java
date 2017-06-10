/**
 * Created by xhu on 1/31/17.
 */
class Helper{
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    boolean isBinaryTree;

    public Helper(int max, int min, boolean isBinaryTree){
        this.max = max;
        this.min = min;
        this.isBinaryTree = isBinaryTree;
    }
}
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }

        Helper result = isValidBSTHelper(root);

        return result.isBinaryTree;
    }

    private Helper isValidBSTHelper(TreeNode root){
        if(root == null){
            return new Helper(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        }

        Helper left = isValidBSTHelper(root.left);
        Helper right = isValidBSTHelper(root.right);

        boolean isBST = false;

        if(left.max<root.val && root.val<right.min && left.isBinaryTree && right.isBinaryTree){
            isBST = true;
        }

        int min = left.min == Integer.MAX_VALUE ? root.val:left.min;
        int max = right.max == Integer.MIN_VALUE? root.val:right.max;

        return new Helper(max,min,isBST);
    }
}
