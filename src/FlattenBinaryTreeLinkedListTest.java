import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/26/17.
 */
public class FlattenBinaryTreeLinkedListTest {
    @Test
    public void flatten() throws Exception {
        FlattenBinaryTreeLinkedList target = new FlattenBinaryTreeLinkedList();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        target.flatten(root);
    }

}