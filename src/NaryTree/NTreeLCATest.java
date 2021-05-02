package NaryTree;

import org.junit.Test;


/**
 * Created by xhu on 4/14/17.
 */
public class NTreeLCATest {
    @Test
    public void findCommonLCA() throws Exception {

        NTreeNode root = new NTreeNode(0);

        for(int i =1; i<=3;i++){
            NTreeNode node = new NTreeNode(i);
            root.children.add(node);
        }

        for(int i =4; i<=7;i++){
            NTreeNode node = new NTreeNode(i);
            root.children.get(1).children.add(node);
        }

        for(int i =8; i<=11;i++){
            NTreeNode node = new NTreeNode(i);
            root.children.get(2).children.add(node);
        }


        NTreeLCA2 target = new NTreeLCA2();
        target.findCommonLCA(root,new NTreeNode(1),new NTreeNode(11));
    }

}