import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/25/17.
 */
public class SerializeDeserializeBSTTest {
    @Test
    public void serialize() throws Exception {
            SerializeDeserializeBST  target =  new SerializeDeserializeBST();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);
            root.left.right = new TreeNode(2);
            target.serialize(root);

            target.deserialize(target.serialize(root));
    }

}