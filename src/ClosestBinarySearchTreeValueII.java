import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xhu on 3/4/17.
 */
public class ClosestBinarySearchTreeValueII {

    // closed binary search tree value
//1. inorder traversal the tree, find out the most closest value, n and put all values in a array

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }


        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Double min = Double.MAX_VALUE;
        int closes = Integer.MAX_VALUE;
        int closesIndex = -1;
        int index = -1;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            inOrder.add(node.val);
            index++;
            if (Math.abs(node.val - k) < min) {
                closes = node.val;
                min = (double)Math.abs(node.val - k);
                closesIndex = index;
            }
            current = node.right;
        }

//2. if the closest value`s index is i, contine search i+1 and i-1 and find the k moset closest value
        result.add(closes);
        int start = closesIndex - 1;
        int end = closesIndex + 1;
        k--;
        while (k > 0 && (end < inOrder.size() || start >= 0)) {
            if (start < 0) {
                result.add(inOrder.get(end));
                end++;
                continue;
            } else if (end >= inOrder.size()) {
                result.add(inOrder.get(start));
                start--;
                continue;
            } else if (Math.abs(inOrder.get(start) - k) < Math.abs(inOrder.get(end) - k)) {
                result.add(inOrder.get(start));
                start--;
                continue;
            } else {
                result.add(inOrder.get(end));
                end++;
                continue;
            }
        }


        return result;

    }
}
