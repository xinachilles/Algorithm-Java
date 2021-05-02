import java.util.*;

public class RandomizedSet {

    // value to index
    Map<Integer,Integer> index;
    Random r;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        index = new HashMap<>();
        r  = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(index.containsKey(val)){
            return false;
        }

        int length = list.size();
        list.add(val);
        index.put(val,length);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(index.containsKey(val)){
            return false;
        }
        int i = index.get(val);
        int last = list.get(list.size()-1);
        index.put(i,last);
        index.remove(val);
        list.set(i,last);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = r.nextInt(list.size());
        return list.get(i);
    }
}
