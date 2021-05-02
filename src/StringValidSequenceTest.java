import org.junit.Test;

import static org.junit.Assert.*;

public class StringValidSequenceTest {

    @Test
    public void isValidSequence() {
        StringValidSequence test = new StringValidSequence();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(4);

        test.isValidSequence(root,new int[]{8});
    }
}