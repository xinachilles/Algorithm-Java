/**
 * Created by xhu on 11/6/16.
 */
public class ConstructBinaryTreeInorderPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }


    private TreeNode buildTreeHelper(int[] inorder, int startInorder, int endInorder,
                                     int[] postorder, int startPostorder, int endPostorder) {
        if (startInorder > endInorder || startPostorder > endPostorder) {
            return null;
        }

        TreeNode head = new TreeNode(postorder[endPostorder]);
        int index = findIndex(postorder[endPostorder], inorder, startInorder, endInorder);

        if (index == -1) return null;

        int lengthOfleft = index - startPostorder;


        head.left = buildTreeHelper(inorder, startInorder, index - 1, postorder, startPostorder, startPostorder + lengthOfleft-1);
        head.right = buildTreeHelper(inorder, index + 1, endInorder, postorder, startPostorder + lengthOfleft, endPostorder - 1);
        return head;
    }

    private int findIndex(int num, int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                return i;
            }
        }

        return -1;
    }

}
