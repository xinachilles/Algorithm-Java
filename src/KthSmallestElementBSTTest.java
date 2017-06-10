import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 5/21/17.
 */
public class KthSmallestElementBSTTest {
    @Test
    public void kthSmallest() throws Exception {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        KthSmallestElementBST target = new KthSmallestElementBST();
        target.kthSmallest(root,1);
    }

}