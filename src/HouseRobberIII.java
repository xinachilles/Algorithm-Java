import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 1/18/17.
 */
public class HouseRobberIII {

    int sum = 0;

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int[] result = helper(root);
        return result[3];
    }


    private int[] helper(TreeNode root) {
        if (root == null) {
            return null;
        }


        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] max = new int[3];
        // max[0] means if rob the root value,the maximum amount of money can rob
        // max[1] means if don`t rob the root, the maximum amount of money can rob
        // max[2] means the max of 1 and 2


        max[0] = root.val + left[1] + right[1];
        max[1] = left[2] + right[2];

        max[2] = Math.max(max[0],max[1]);

        return max;
    }

}
