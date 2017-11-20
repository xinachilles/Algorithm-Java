public class ConstructBinaryTreeString {

    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0){
            return null;
        }

        int index = s.indexOf("(");
        int value = index == -1? Integer.valueOf(s) : Integer.valueOf(s.substring(0,index));

        int start  = index;
        int numberOfLeft = 0;
        int numberOfRight = 0;

        TreeNode root = new TreeNode(value);
        if(index == -1){
            return root;
        }

        for(int i = start; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                numberOfRight++;
            }

            if(s.charAt(i) == '('){
                numberOfLeft++;
            }

            if(numberOfRight == numberOfLeft && start == index){
                root.left = str2tree(s.substring(start,i));
                start++;
            }else if(numberOfRight == numberOfLeft){
                root.right = str2tree(s.substring(i+1));
            }
        }

        return root;



    }
}
