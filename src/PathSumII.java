import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xhu on 7/19/17.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root ==null){
            return result;
        }

        Stack<Integer> sums = new Stack<Integer>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<List<Integer>> stackLst = new Stack<List<Integer>>();

        nodes.push(root);
        sums.push(sum);
        stackLst.push(new ArrayList<Integer>());


        while(!nodes.isEmpty()){
            TreeNode current = nodes.pop();
            List<Integer> temp = stackLst.pop();
            if(current == null){
                continue;
            }

            temp.add(current.val);
            int value = sums.pop();

            if(current.left == null && current.right == null && value-current.val == 0){

                result.add(new ArrayList<Integer>(temp));

            }else{
                nodes.push(current.left);
                nodes.push(current.right);

                sums.push(value-current.val);
                sums.push(value-current.val);

                stackLst.push(new ArrayList<Integer>());
                stackLst.push(new ArrayList<Integer>());
            }

        }

        return result;

    }
}
