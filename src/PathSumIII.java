import java.util.*;

/**
 * Created by xhu on 1/11/17.
 */
public class PathSumIII {

    //Path sum
    int count;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        helper(root, sum, 0, map);
        return count;
    }

    private void helper(TreeNode root, int sum, int current, Map<Integer, Integer> sums) {
        if (root == null) {
            return;
        }

        current = current + root.val;
        if (sums.containsKey(current)) {
            sums.put(current, sums.get(current));
        } else {
            sums.put(current, 1);
        }


        if (sums.containsKey(current - sum)) {
            count += sums.get(current - sum);
        }


        helper(root.left, sum, current, sums);
        helper(root.right, sum, current, sums);
        sums.put(current,sums.get(current)-1);
    }

}


