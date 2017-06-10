import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 4/28/17.
 */
public class TwoSumII {
    Map<Integer,Integer> counts = new HashMap<>();
    /** Initialize your data structure here. */
    public TwoSumII() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        counts.put(number,counts.getOrDefault(number,0)+1);

    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {

        for(int key: counts.keySet()){
            if(key == value-key){
                if( counts.get(key)>1){
                    return true;
                }
            }

            if(counts.containsKey(value-key)){
                return true;
            }
        }

        return false;
    }
}
