import java.util.*;

public class AllNodesDistanceKBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        return null;
    }

    public int helper(TreeNode root, TreeNode target, int k, List<Integer> result){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root == target){
            findKth(root,k,result);
            return 1;
        }

        int l = helper(root.left, target,k,result);
        int r = helper(root.right,target,k,result);

        if(l<=k){
            findKth(root.right,k-l,result);
        }
        if(r<=k){
            findKth(root.left,k-r,result);
        }
        return Math.min(l,r)+1;
    }

    private void findKth(TreeNode root, int k, List<Integer> result){
        if(root == null || k<0){
            return;
        }
        if(k == 0){
            result.add(root.val);
        }else{
            findKth(root.left,k-1,result);
            findKth(root.right,k-1,result);
        }
    }
}
