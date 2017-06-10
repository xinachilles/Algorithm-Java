import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 1/9/17.
 */
public class CountUnivalueSubtrees {
    //do inorder traversal the tree, if all node of substree have the same value return 1
    int count = 0;

    public int countUnivalSubtress(TreeNode root) {
        if (root == null) {
            return 0;
        }


        helper(root);
        return count;
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)) {
            count++;
            return true;
        } else {
            return false;
        }

    }

}
