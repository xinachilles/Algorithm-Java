package NaryTree;

import org.junit.Test;

/**
 * Created by xhu on 4/14/17.
 */
public class NTreeLCATest {
    @Test
    public void findCommonLCA() throws Exception {
        NTreeLCA target = new NTreeLCA();
        NTreeNode root = new NTreeNode(0);

        for(int i =1; i<=3;i++){
            NTreeNode node = new NTreeNode(i);
            root.children.add(node);
        }

        for(int i =4; i<=7;i++){
            NTreeNode node = new NTreeNode(i);
            root.children.get(0).children.add(node);
        }

        for(int i =8; i<=11;i++){
            NTreeNode node = new NTreeNode(i);
            root.children.get(1).children.add(node);
        }


        // NTreeNode result = target.findCommonLCA(root, root,root.children.get(1).children.get( 1 ));
           NTreeTransfer target2 = new NTreeTransfer();
           NTreeNode root2 = target2.Transfer(root,3);
    }

}