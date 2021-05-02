import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }

            }

            result.add(sum/size);
        }

        return result;
    }
}
