public class LowestCommonAncestorDeepestLeaves {
    class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        Pair result = Helper(root);
        return result.node;


    }

    private Pair Helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }

        Pair left = Helper(root.left);
        Pair right = Helper(root.right);


        if (left.level == right.level) {
            return new Pair(left.level+1, root);
        } else {
            return left.level > right.level ? new Pair(left.level+1,left.node)
                    : new Pair(right.level+1,right.node);
        }
    }
}
