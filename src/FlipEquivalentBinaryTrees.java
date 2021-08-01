import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1 == null || node2 == null) {
                if(node1 != node2) return false;
            }

            if (node1.left == node2.left || node1.left != null && node2.left != null && node1.left.val == node2.left.val) {
                q1.addAll(Arrays.asList(node1.left, node1.right));
            }else {
                q1.addAll(Arrays.asList(node1.right, node1.left));
            }
            q2.addAll(Arrays.asList(node2.left, node2.right));
        }

        return q1.isEmpty() && q2.isEmpty();

    }
}
