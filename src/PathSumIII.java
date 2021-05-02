import java.util.*;

/**
 * Created by xhu on 1/11/17.
 */
public class PathSumIII {
    int count;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, sum, 0, map);
        return count;
    }

    private void helper(TreeNode root, int target, int current, Map<Integer, Integer> maps) {
        if (root == null) {
            return;
        }

        current = current + root.val;
        if(current == target){
            count++;
        }
        count+=maps.getOrDefault(target-current,0);
        maps.put(current,maps.getOrDefault(maps.get(current),0 )+1);
        helper(root.left,target,current,maps);
        helper(root.right,target,current,maps);
        maps.put(current,maps.get(current)-1);

    }

}


