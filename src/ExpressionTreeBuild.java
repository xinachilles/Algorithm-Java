import java.util.Stack;

/**
 * Created by xhu on 2/1/17.
 */


public class ExpressionTreeBuild {
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return null;
        }

        int base = 0;
        Stack<TreeNode2> stack = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            if (i < expression.length) {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }

                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
            }
            TreeNode2 current = new TreeNode2(new ExpressionTreeNode(expression[i]), getWeight(expression[i], base));


            while (!stack.isEmpty() && current.weight <= stack.peek().weight) {
                current.node.left = stack.pop().node;
            }
            if (!stack.isEmpty()) {
                stack.peek().node.right = current.node;
            }


            stack.push(current);

        }


        ExpressionTreeNode resut = null;
        while (!stack.isEmpty()) {
            resut = stack.pop().node;
        }
        return resut;
    }

    private int getWeight(String expression, int base) {
        if (expression.equals("+") || expression.equals("-")) {
            return base + 1;
        }

        if (expression.equals("*") || expression.equals("/")) {
            return base + 2;
        }

        return Integer.MAX_VALUE;

    }
}
