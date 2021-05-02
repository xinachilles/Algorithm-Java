import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> min;
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek()>x){
            min.push(x);
        }
    }

    public void pop() {
        int i = stack.pop();
        if(min.peek() == i){
            min.pop();
        }


    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
