import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 1/12/17.
 */
public class PathSumIIITest {
    @Test

    //[1,-2,-3, 1,3, -2,null,-1]
    public void pathSum() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(-2);
        root.left.left.left= new TreeNode(-1);

        PathSumIII target = new PathSumIII();
        target.pathSum(root,3);
    }

}