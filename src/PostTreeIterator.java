import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by xhu on 5/22/17.
 */
public class PostTreeIterator {

    Stack<TreeNode> s = new Stack<TreeNode>();

    public PostTreeIterator(TreeNode root) {
        NextNode(root);

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = s.pop();
        if (!s.isEmpty()) {
            TreeNode top = s.peek();
            if(top.left == current) {
                NextNode(top.right);
            }
        }

        return current.val;
    }

    private void NextNode(TreeNode root){
        TreeNode current = root;
        while(current !=null){
            s.push(current);
            if(current.left != null){
                current = current.left;
            }else
                current = current.right;
            }
        }

    }

