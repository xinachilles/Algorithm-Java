import java.util.*;

/**
 * Created by xhu on 1/10/17.
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    Stack<Integer> stack = new Stack<Integer>();

    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return;
        }

        for(int i = nestedList.size()-1; i>=0; i--){
            pushToStack(nestedList.get(i),stack);
        }
    }

    @Override
    public Integer next() {
        return  stack.pop();
    }

    private void pushToStack(NestedInteger e, Stack<Integer> stack){
        if(e.isInteger()){
            stack.push(e.getInteger());
        }
        List<NestedInteger> list = e.getList();

        for(int i = list.size()-1;i>=0; i--){
            pushToStack(list.get(i),stack);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
