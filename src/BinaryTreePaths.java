import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xhu on 7/21/17.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }


        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        String current = String.valueOf(root.val);

        for (String l : left) {
            result.add(current + "->" + l);
        }


        for (String r : right) {
            result.add(current + "->" + r);
        }


        if (right.size() == 0 && left.size() == 0) {
            result.add(current);
        }

        return result;


    }
}
