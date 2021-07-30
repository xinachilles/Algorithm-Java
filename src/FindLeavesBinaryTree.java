import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 1/11/17.
 */
public class FindLeavesBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root ==null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        DFS(root,result);
        return result;
    }

    private int DFS(TreeNode root,List<List<Integer>> result){
        if(root == null){
            return 0;
        }
        int left = DFS(root.left,result);
        int right = DFS(root.right,result);

        int depth = Math.max(left,right)+1;

        if(depth == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);

        return depth;

    }


}
