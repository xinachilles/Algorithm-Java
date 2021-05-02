public class MaximumSumBSTBinaryTree {
    int result = 0;
    class Count{
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean isBST = false;
        int sum  = 0;

        public Count(int max, int min,int sum,boolean isBST){
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.isBST = isBST;
        }
    }
    public int maxSumBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        return result;
    }

    private Count helper(TreeNode root){
        if(root ==null){
            return new Count(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        }

        Count left = helper(root.left);
        Count right = helper(root.right);
        boolean isBST = left.isBST && right.isBST && root.val>left.max && root.val<right.min;
        int max = right.max == Integer.MIN_VALUE? root.val : right.max;
        int min = left.min == Integer.MIN_VALUE? root.val : left.min;
        int sum = left.sum+ right.sum+ root.val;
        if(isBST){
            result = Math.max(sum,result);
        }
        return new Count(max,min,sum,isBST);

    }


}
