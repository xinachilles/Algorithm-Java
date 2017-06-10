import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/4/17.
 */
public class ClosestBinarySearchTreeValueIITest {
    @Test
    public void closestKValues() throws Exception {
        ClosestBinarySearchTreeValueII target = new ClosestBinarySearchTreeValueII();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        target.closestKValues(root,2147483647.0,1);
    }

}