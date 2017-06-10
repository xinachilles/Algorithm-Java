/**
 * Created by xhu on 2/20/17.
 */
public class SerializeDeserializeBST {

    public String serialize(TreeNode root){
        if(root ==null){
            return null;
        }

        StringBuilder result = new StringBuilder();
        serializeHelper(root,result);
        return result.toString().substring(0,result.length()-1);
    }

    private void serializeHelper(TreeNode root,StringBuilder result){
        if(root == null){
            return;
        }

        result.append(root.val);
        result.append(",");
        serializeHelper(root.left,result);
        serializeHelper(root.right,result);
    }

    public TreeNode deserialize(String data){
        if(data == null || data.length() == 0){
            return 	null;
        }

        String[] values = data.split(",");
        int[] IntgerOfvalues = new int[values.length];
        for(int i = 0; i<values.length; i++){
            IntgerOfvalues[i] = Integer.valueOf(values[i]);
        }

        return deserializeHelper(IntgerOfvalues, 0, values.length-1);

    }

    private TreeNode deserializeHelper(int[] values, int start, int end){
        if(start>end){
            return null;
        }

        if(start == end){
            return new TreeNode(values[start]);
        }

        TreeNode root = new TreeNode(values[start]);

        int left = start+1;

        while(left+1<=end && values[left+1]< values[left]){

            left++;
        }

        root.left = deserializeHelper(values, start+1,left);
        root.right= deserializeHelper(values, left+1,end);

        return root;
    }
}
