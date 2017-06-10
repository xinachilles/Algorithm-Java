import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 1/11/17.
 */
public class FindLeavesBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        findLeaves(root, result);
        return result;
    }

    private int findLeaves(TreeNode root, List<List<Integer>> result) {
        if (root == null) return -1;
        int level = 1 + Math.max(findLeaves(root.left, result), findLeaves(root.right, result));
        if (result.size() < level + 1) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        return level;


    }

}
