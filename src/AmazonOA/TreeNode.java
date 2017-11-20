package AmazonOA;

/**
 * Created by xhu on 4/15/17.
 */
public class TreeNode implements Comparable<TreeNode>{
    TreeNode left;
    TreeNode right;
    int val;

    public int compareTo(TreeNode m)
    {
        return this.val - m.val;
    }

    public  TreeNode(int val){
        this.val  = val;
    }

}
