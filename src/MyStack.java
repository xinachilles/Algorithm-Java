import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 4/2/17.
 */
public class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue  = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        top();
        if(!queue.isEmpty()){
            return queue.poll();
        }else{
            return -1;
        }

    }

    /** Get the top element. */
    public int top() {
        for(int i = 0; i<queue.size()-1;i++){
            queue.offer(queue.poll());
        }

        if(!queue.isEmpty()){
            return queue.peek();
        }else{
            return -1;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}