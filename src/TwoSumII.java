import java.util.*;

/**
 * Created by xhu on 4/28/17.
 */
public class TwoSumII {
    HashSet<Integer> sets = new HashSet<>();
    /** Initialize your data structure here. */
    public TwoSumII() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        sets.add(number);

    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {

        Iterator<Integer> it = sets.iterator();
        while(it.hasNext()){
            if(sets.contains(value-it.next())){
                return  true;
            }
        }
        return false;
    }
}
