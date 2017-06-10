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

        int min = Math.min(a, b);
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

        return distance1 + distance2;

    }

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
