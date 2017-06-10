import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 2/26/17.
 */
public class VerifyPreorderSerializationBinaryTreeTest {
    @Test
    public void isValidSerializatio() throws Exception {
        VerifyPreorderSerializationBinaryTree target = new VerifyPreorderSerializationBinaryTree();
        target.isValidSerializatio("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

}