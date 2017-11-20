package FBOA;

public class BalancedParentheses {

    /**
     * iterate from the start to the end once, to delete the redundant right ones
     *                  end   to the start,                            left
     * */

    //O(len), O(len)
    public String balance(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                left++;
                sb.append('(');
            } else if (c[i] == ')' && right < left) {
                right++;
                sb.append(')');
            }
        }

        c = sb.toString().toCharArray();
        sb = new StringBuilder();
        left = 0;
        right = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ')') {
                right++;
                sb.append(')');
            } else if (c[i] == '(' && left < right) {
                left++;
                sb.append('(');
            }
        }
        return sb.reverse().toString();
    }


    public static void main(String[] arg) {
        BalancedParentheses a = new BalancedParentheses();
        System.out.println(a.balance("()"));
        System.out.println(a.balance(")("));
        System.out.println(a.balance("((((("));
        System.out.println(a.balance("(()()("));
        System.out.println(a.balance("(()()("));
        System.out.println(a.balance(")(())("));
    }

}
