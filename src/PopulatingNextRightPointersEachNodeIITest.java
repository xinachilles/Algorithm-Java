import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 10/9/16.
 */
public class PopulatingNextRightPointersEachNodeIITest {
    @Test
    public void connect() throws Exception {
            PopulatingNextRightPointersEachNodeII target = new PopulatingNextRightPointersEachNodeII();
            TreeLinkNode root = new TreeLinkNode(1);
            root.left = new TreeLinkNode(2);
            root.right = new TreeLinkNode(3);

            root.left.left = new TreeLinkNode(4);
            root.right.right = new TreeLinkNode(5);

            target.connect(root);
    }

}