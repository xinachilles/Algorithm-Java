import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        //lai offer: after detecting the first node that misses one child, then check // whether all following nodes expended to see wheatear they have any node generated ( if any // -> then false)
        boolean foundEmptyNode = false;

        Queue<TreeNode> visiting = new LinkedList<>();
        visiting.offer(root);

        while (!visiting.isEmpty()) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = visiting.poll();
                if (node.left == null && node.right == null) {
                    foundEmptyNode = true;
                    continue;
                } else {
                    // 1 and 2
                    if (foundEmptyNode) {
                        return false;
                    }

                    if (node.left == null) {
                        foundEmptyNode = true;

                    } else {
                        visiting.offer(node.left);
                    }

                    // for right
                    if (node.right == null) {
                        foundEmptyNode = true;
                    } else {
                        //3
                        if (foundEmptyNode) return false;
                        visiting.offer(node.right);
                    }
                }

            }
        }


        return true;
    }
}
