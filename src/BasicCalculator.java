import java.util.Stack;


/**
 * Created by xhu on 10/15/16.
 */
public class BasicCalculator {
   /* public int calcuatio(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        Stack<Character> operations = new Stack<Character>();
        // store the index of operations included: plus, minus, parentheses
        Stack<Integer> number = new Stack<Integer>();
        // store the index of each number character in S

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                int result = 0;
                while(!operations.isEmpty() && !number.isEmpty()){
                    Character current = operations.pop();
                    if(current == '(' ){
                        break;
                    }

                    if(current ==')'){
                        return 0;
                    }

                    int a = number.pop();
                    int b = number.pop();

                    if(current == '+'){
                        result = a+b+result;
                    }else if(current == '-'){
                        result = a-b+result;
                    }
                }
                number.push(result);
            }else if(s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-'){
                operations.push(s.charAt(i));
            }else{
                number.push(Character.getNumericValue(s.charAt(i)));
            }
        }


        int ans = 0;

        while(!operations.isEmpty() && !number.isEmpty()){
            Character current = operations.pop();
            if(current == '(' || current ==')' ){
                break;
            }
            if(number.size()<2){
                return -1;
            }


            int a = number.pop();
            int b = number.pop();

            if(current == '+'){
                ans = a+b+ans;
            }else if(current == '-'){
                ans = a-b+ans;
            }
        }
        return ans;
    }*/
   private  int getWeight(String expression,int base){
       if(expression == "+" || expression == "-"){
           base+=1;
           return base;
       }

       if(expression == "/" || expression == "*"){
           base+=2;
           return base;
       }

       return  Integer.MAX_VALUE;

   }
   public TreeNode2 getRPN(String s) {


       int number = 0;

       int base =0;
       Stack<TreeNode2> tree = new Stack<>();
       for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(Character.isDigit(c)){
               number = 10 * number + (int)(c - '0');
           }else {
                TreeNode2 node = new TreeNode2(new ExpressionTreeNode(String.valueOf(number)),getWeight(String.valueOf(number),base));

                AddToTree(tree,node);
                TreeNode2 op = new TreeNode2(new ExpressionTreeNode(String.valueOf(c)),getWeight(String.valueOf(c),base));
                AddToTree(tree,op);



           }
       }

       return tree.peek();

   }

   private int EvalRPN(TreeNode2 root){
        return 0;
   }


   private void AddToTree(Stack<TreeNode2> tree,TreeNode2 node){

      while(!tree.isEmpty() && node.weight<tree.peek().weight){
          TreeNode2 current = tree.pop();

          if(tree.isEmpty())
          {
              node.node.left  = current.node;
          }else{

              TreeNode2 left = tree.peek();
              if(left.weight>node.weight){
                  left.node.right = current.node;
              }else{
                  node.node.left = current.node;
              }
          }

      }

      tree.push(node);

}
}
