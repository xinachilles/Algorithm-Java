public class VerifyPreorderSequenceBST {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return true;
        }

        return verifyPreorder(preorder);

    }

    private boolean helper(int[]preorder,int start, int end){
        if(start>=end){
            return true;
        }
        int root = preorder[start];
        int i = start+1;
        while(i<=end && preorder[i]<root){
            i++;
        }

        for(int j = i; j<=end; j++){
            if(preorder[j]<root) return false;
        }

        return helper(preorder,start+1, i-1) && helper(preorder,i,end);


    }
}
