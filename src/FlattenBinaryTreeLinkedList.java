/**
 * Created by xhu on 2/26/17.
 */
public class FlattenBinaryTreeLinkedList {
   /* public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = flattenHelper(root.left);
        TreeNode rightTail = flattenHelper(root.right);

        if(leftTail !=null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = temp;
        }

        if (rightTail != null) {
            return rightTail;
        }

        if (leftTail != null) {
            return leftTail;
        }

        return root;
    }*/

    public void flatten(TreeNode root){
        if(root ==null){
            return;
        }

        TreeNode current = root;

        while(current !=null){
            TreeNode right = current.right;
            TreeNode leftRightTail = current.left;

            while(leftRightTail!=null && leftRightTail.right !=null){
                leftRightTail = leftRightTail.right;
            }

            current.right = current.left;
            current.left = null;

            leftRightTail.right = right;

            current = current.right;
        }

    }

}
