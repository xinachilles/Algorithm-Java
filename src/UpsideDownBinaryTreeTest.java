import org.junit.Test;

import static org.junit.Assert.*;

public class UpsideDownBinaryTreeTest {

    @Test
    public void upsideDownBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        UpsideDownBinaryTree target = new UpsideDownBinaryTree();
        target.upsideDownBinaryTree(root);
    }
}