public class BinaryTreeLongestConsecutiveSequenceII {
    public class Pair{

        int increase;// the logest increase path from current node to his child, current node should less than child node
        int decreaase; // the longest decrease path from current node to his child. current node should greater than child node

        public Pair(int increase, int decrease){
            this.increase = increase;
            this.decreaase = decrease;
        }

    }
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        help(root);
        return max;
    }

    private Pair help(TreeNode root){
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null){
            return new Pair(1,1);
        }

        Pair left = help(root.left);
        Pair right = help(root.right);
        Pair current = new Pair(1,1);

        if(left != null && root.left != null){
            if(root.left.val== root.val+1){
                current.increase = left.increase+1;
            }else if(root.left.val == root.val-1){
                current.decreaase = left.decreaase+1;
            }
        }

        if(right != null && root.right != null){
            if(root.right.val == root.val+1){
                current.increase = right.increase+1;
            }else if(root.right.val ==root.val-1){
                current.decreaase = right.decreaase+1;
            }
        }

        max = Math.max(current.decreaase+current.increase-1,max);
        return current;
    }
}
