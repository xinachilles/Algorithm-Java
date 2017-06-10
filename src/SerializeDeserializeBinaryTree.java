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
    int index = 0;
    public TreeNode deserialize(String data) {
        if(data == null|| data.length() ==0){
            return null;
        }

        String[] values = data.split(",");
        return deserializeHelper(values);
    }

    private TreeNode deserializeHelper(String[] values){
        if(index>=values.length){
            return null;
        }

        String value = values[index];
        if(value.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(value));
        index++;
        root.left = deserializeHelper(values);
        index++;
        root.right = deserializeHelper(values);

        return root;
    }
}
