package AmazonOA;

/**
 * Created by xhu on 4/15/17.
 */
public class BinarySearchTreeDistance {

   public int Distance(int[] array, int a, int b)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        TreeNode root = new TreeNode(array[0]);

        for (int i = 1; i < array.length; i++)
        {
            insertToBinarySearchTree(array[i], root);
        }

       /* int min = Math.min(a, b);
        int max = Math.max(a, b);
        int distance1 = -1;
        int distance2 = -1;
        TreeNode lca = root;


        if (max <array[0])
        {
            lca = getCommonLCA(root.left, a, b, min, max);

        }
        else if(min > array[0])
        {
            lca = getCommonLCA(root.right, a, b, min, max);
        }

        distance1 = getDistance(a, lca);
        distance2 = getDistance(b, lca);

        if (distance1 == -1 || distance2 == -1)
        {
            return -1;
        }

        return distance1 + distance2;*/
       return lowestCommonAncestor3(root, new TreeNode(a), new TreeNode(b));

    }
/*
    private TreeNode getCommonLCA(TreeNode root, int a, int b, int min, int max)
    {
        if (root == null)
        {
            return null;
        }

        if (root.val == b || root.val == a || (root.val>=min &&  root.val <=max))
        {
            return root;
        }

        if (root.val < min)
        {
            return getCommonLCA(root.right, a, b, min, max);
        }

        if (root.val > max)
        {
            return getCommonLCA(root.left, a, b, min, max);
        }


        return null;
    }
    private int getDistance(int target, TreeNode root)
    {
        TreeNode current = root;
        int step = 0;
        boolean isFind = false;

        while (current != null)
        {
            step++;
            if (current.val == target)
            {
                isFind = true;
                break;
            }else if (current.val < target)
            {
                current = current.right;
            }
            else
            {
                current = current.left;
            }
        }

        return isFind ? step-1 : -1;

    }*/

    class ResultType {
        public int distance_a = Integer.MAX_VALUE;
        public int distance_b = Integer.MAX_VALUE;


        public ResultType(int distance_a, int distance_b) {
            this.distance_a = distance_a;
            this.distance_b = distance_b;

        }
    }

    public int lowestCommonAncestor3(TreeNode root, TreeNode a, TreeNode b) {
        ResultType res = helper(root, a, b);
        if (res.distance_a == Integer.MAX_VALUE || res.distance_b == Integer.MAX_VALUE ) {//return node only when two nodes found
            return Integer.MAX_VALUE;
        }
        return res.distance_b+res.distance_a-1;
    }

    private ResultType helper(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return new ResultType(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        ResultType left = helper(root.left, a, b);
        ResultType right = helper(root.right, a, b);
        int  distance_a = left.distance_a == Integer.MAX_VALUE? right.distance_a: left.distance_a;
        int  distance_b = left.distance_b == Integer.MAX_VALUE? right.distance_b : right.distance_b;

        if(root.compareTo(a) ==0 ){
            return  new ResultType(0,distance_b==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_b+1);
        }

        if(root.compareTo(b) == 0){
            return  new ResultType(distance_a==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_a+1,0);
        }

            return  new ResultType(distance_a==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_a+1,distance_b==Integer.MAX_VALUE? Integer.MAX_VALUE:distance_b+1);
        }







    private void insertToBinarySearchTree(int number, TreeNode root)
    {
        TreeNode insert = null;
        TreeNode current = root;
        int step = 0;

        while (current != null)
        {
            insert = current;

            if(current.val == number){
                return;
            }else if (current.val < number)
            {
                current = current.right;
            }
            else
            {
                current = current.left;
            }

        }

        if (insert.val < number)
        {
            insert.right = new TreeNode(number);
        }
        else
        {
            insert.left = new TreeNode(number);
        }
    }

}
