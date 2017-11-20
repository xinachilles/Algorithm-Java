import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by xhu on 7/15/17.
 */
public class LCA {


    // misktake node1 is the parents of node2
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Map<TreeNode, TreeNode> maps = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> visited = new LinkedList<>();
        Boolean isFind1 = false;
        Boolean isFind2 = false;

        maps.put(root, root);
        visited.offer(root);

        while (!maps.isEmpty() && (!isFind1 || !isFind2)) {
            int size = maps.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = visited.poll();
                if (current == p) {
                    isFind1 = true;
                }

                if (current == q) {
                    isFind2 = true;

                }

                if (isFind1 && isFind2) {
                    break;
                }

                if (current.left != null) {
                    visited.offer(current.left);
                    maps.put(current.left, current);
                }

                if (current.right != null) {
                    visited.offer(current.right);
                    maps.put(current.right, current);
                }
            }
        }

        TreeNode parent1 = p;
        TreeNode parent2 = q;


        if (isFind1 && isFind2) {
            while (parent1 != parent2) {
                parent1 = maps.get(parent1);
                parent2 = maps.get(parent2);

                if(parent1 == q){
                    return q;
                }

                if(parent2 == p){
                    return p;
                }
            }


            return parent1;

        }

        return null;

    }

}
