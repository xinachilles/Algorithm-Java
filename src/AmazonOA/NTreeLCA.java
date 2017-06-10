package AmazonOA;

/**
 * Created by xhu on 4/14/17.
 */
public class NTreeLCA {
    boolean isFindFirst = false;
    boolean isFindSecond = false;

    public NTreeNode findCommonLCA(NTreeNode root, NTreeNode node1, NTreeNode node2){
        NTreeNode result= findCommonLCAHelper(root, node1,node2);

        if(isFindFirst && isFindSecond){
            return result;
        }else{
            return null;
        }
    }
    private NTreeNode findCommonLCAHelper(NTreeNode root, NTreeNode node1, NTreeNode node2){
        if(root ==null ){
            return null;
        }

        if(root == node1){
            isFindFirst = true;
        }

        if(root == node2){
            isFindSecond = true;

        }


        NTreeNode temp = null;
        int count = 0;

        for(NTreeNode c : root.children){
            NTreeNode result = findCommonLCAHelper(c, node1,node2);
            if(result != null){
                count++;
                temp = result;
            }

        }

        if(count == 2 || root == node1 || root == node2){
            return  root;
        }

        return  temp;

    }
}
