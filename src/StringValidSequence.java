public class StringValidSequence {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null || arr == null){
            return false;
        }

        return helper(root,arr,0);

    }

    private boolean helper(TreeNode root, int[]arr, int index){

        if(root == null){
            if(arr.length == index){
                return true;
            }else{
                return false;
            }
        }

        if(index>=arr.length || root.val != arr[index]){
            return false;
        }

        return helper(root.left,arr,index+1) || helper(root.right,arr,index+1);

    }
}
