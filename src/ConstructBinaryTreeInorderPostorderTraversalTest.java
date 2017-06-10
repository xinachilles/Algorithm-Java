import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 11/17/16.
 */
public class ConstructBinaryTreeInorderPostorderTraversalTest {
    @Test
    public void buildTree() throws Exception {
        ConstructBinaryTreeInorderPostorderTraversal target  = new ConstructBinaryTreeInorderPostorderTraversal();
        target.buildTree(new int []{2,1}, new int[]{2,1});
    }

}