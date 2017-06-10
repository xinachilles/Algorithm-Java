import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 1/10/17.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int first, int second) {
        List<TreeNode> result = new ArrayList<>();
        if (first > second) {
            result.add(null);
            return result;
        }


        for (int i = first; i <= second; i++) {
            TreeNode root = new TreeNode(i);
            List<TreeNode> left = helper(first, i - 1);
            List<TreeNode> right = helper(i + 1, second);


            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    root.left = l;
                    root.right = r;

                    result.add(root);
                }
            }

        }

        return result;

    }
}
