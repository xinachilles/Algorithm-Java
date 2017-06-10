import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 1/18/17.
 */
public class HouseRobberIIITest {
    @Test
    public void rob() throws Exception {
        HouseRobberIII target = new HouseRobberIII();
        TreeNode root = new TreeNode(3);
        root.left=  new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(3);
        root.right.right  = new TreeNode(1);
        target.rob(root);
    }

}