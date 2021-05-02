public class UpsideDownBinaryTree {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        if (newRoot == null) {
            return null;
        }

        newRoot.right = root;
        newRoot.left = root.right;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}
