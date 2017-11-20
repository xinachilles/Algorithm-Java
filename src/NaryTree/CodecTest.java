package NaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 6/23/17.
 */
public class CodecTest {
    @Test
    public void serialize() throws Exception {

        Codec target = new Codec();
        NTreeNode root = new NTreeNode(1);
        root.children.add(new NTreeNode(2));
        root.children.add(new NTreeNode(3));
        root.children.add(new NTreeNode(4));

        root.children.get(0).children.add(new NTreeNode(5));
        root.children.get(2).children.add(new NTreeNode(6));

        String result =  target.serialize(root);

        NTreeNode test=  target.deserialize(result);

    }

}