import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class FreqStack {
    List<Stack<Integer>> stacks;
    HashMap<Integer,Integer> maps;


    public FreqStack() {
        stacks = new ArrayList<>();
        maps = new HashMap<>();
    }

    public void push(int x) {

        maps.put(x, maps.getOrDefault(x,0)+1);
        int frequency = maps.get(x);
        if(stacks.size()<frequency){
            stacks.add(new Stack<>());
        }

        stacks.get(frequency-1).push(x);
    }

    public int pop() {
       Stack<Integer> last  =   stacks.get(stacks.size()-1);
       int n = last.pop();
       if(last.empty()){
           stacks.remove(last);
       }
       maps.put(n,maps.get(n)-1);
       if(maps.get(n) == 0){
           maps.remove(n);
       }

       return n;
    }


}
