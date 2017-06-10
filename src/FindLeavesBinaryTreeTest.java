import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 1/11/17.
 */
public class FindLeavesBinaryTreeTest {
    @Test
    public void findLeaves() throws Exception {
        FindLeavesBinaryTree target = new FindLeavesBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        target.findLeaves(root);
    }

}