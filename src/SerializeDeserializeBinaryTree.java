import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 1/10/17.
 */
public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.substring(0,result.length()-1).toString();

    }

    private void serializeHelper(TreeNode root, StringBuilder result){
        if(root == null){
            result.append("#");
            result.append(",");
            return;
        }

        result.append(String.valueOf(root.val)+",");
        serializeHelper(root.left,result);
        serializeHelper(root.right,result);

    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        if(data == null|| data.length() ==0){
            return null;
        }

        String[] values = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q){
        if(q.isEmpty()){
            return null;
        }

        String value = q.poll();
        if(value.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(value));

        root.left = deserializeHelper(q);

        root.right = deserializeHelper(q);

        return root;
    }
}
