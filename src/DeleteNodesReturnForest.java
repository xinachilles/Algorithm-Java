import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> delete_set = new HashSet<>();
        for(int d: to_delete) {
            delete_set.add(d);
        }
        root = DeleteNode(root,result,delete_set);
        if(root!=null){
            result.add(root);
        }

        return result;
    }
    private TreeNode DeleteNode(TreeNode root, List<TreeNode> result,Set<Integer> deleteSet ){
        if(root == null){
            return null;
        }
        TreeNode left = DeleteNode(root.left,result,deleteSet);
        TreeNode right = DeleteNode(root.right,result,deleteSet);

        if(deleteSet.contains(root.val)){
            if(left !=null) result.add(left);
            if(right !=null) result.add(right);
            return null;
        }else{
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
