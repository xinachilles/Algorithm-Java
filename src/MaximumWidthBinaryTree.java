import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthBinaryTree {
    /*
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        // key is the depth of tree and value is the possition.

        Map<Integer,Integer> leftMost = new HashMap<>();
        Helper(leftMost,root,0,0);

        return max;

    }

    private void Helper(Map<Integer,Integer> leftMost, TreeNode root, int depth, int position){
        if(root == null){
            return;
        }


        if(!leftMost.containsKey(depth)){
            leftMost.put(depth,position);
        }

        max = Math.max(max,position - leftMost.get(depth) +1);

        Helper(leftMost,root.left,depth+1,position*2);
        Helper(leftMost,root.right,depth+1,position*2+1);
    }
*/
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        // key is the node of tree and value is array, int[0] is depth and int[1] is  the possition.

        Map<TreeNode,Integer> nodeMaps = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        nodeMaps.put(root, 0);
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode leftMost = null;
            TreeNode rightMost = null;

            for(int i  = 0; i<size;i++){
                TreeNode node = queue.poll();
                int position = nodeMaps.get(node);
                if(i == 0){
                    leftMost = node;
                }
                if(i == size-1){
                    rightMost = node;
                }

                if(node.left!=null){
                    queue.offer(node.left);
                    nodeMaps.put(node.left, 2*position);
                }

                if(node.right !=null){
                    queue.offer(node.right);
                    nodeMaps.put(node.right, 2*position+1);
                }

            }
            if(leftMost !=null && rightMost !=null){
                max = Math.max(max, nodeMaps.get(rightMost) - nodeMaps.get(leftMost)+1);
            }
        }

        return max;

    }
}
