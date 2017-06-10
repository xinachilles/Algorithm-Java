/**
 * Created by xhu on 5/21/17.
 */
public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        int length = getLength(root.left);

        if(k<=length){
            return kthSmallest(root.left, k-1);
        }else if(k>length+1){
            return kthSmallest(root.right, k-length-1);
        }



        return root.val;
    }

    private int getLength(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1+Math.max(getLength(root.left),getLength(root.right));
    }
}
