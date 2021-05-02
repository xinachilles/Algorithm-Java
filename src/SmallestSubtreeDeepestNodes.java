public class SmallestSubtreeDeepestNodes {
    private class Info{
        int deep;
        TreeNode node;
        public Info(TreeNode node, int deep){
            this.node = node;
            this.deep = deep;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Info result = Helper(root);
        return result.node;
    }

    private Info Helper(TreeNode root){
        if(root == null){
            return new Info(null,0);
        }

        Info left = Helper(root.left);
        Info right = Helper(root.right);

        return new Info( left.deep==right.deep?root:( left.deep>right.deep?left.node:right.node),
                Math.max(left.deep,right.deep)+1);
    }
}
