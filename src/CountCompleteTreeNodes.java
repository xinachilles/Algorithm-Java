import apple.laf.JRSUIUtils;

/**
 * Created by xhu on 2/25/17.
 */
public class CountCompleteTreeNodes {

//count complete tree

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Length(root.left);
        int right = Length(root.right);

        if (left == right) {
            return 1 << left + countNodes(root.right);
        } else {
            return 1 << right + countNodes(root.left);
        }
    }

    private int Length(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Length(root.left) + 1;
    }
}
