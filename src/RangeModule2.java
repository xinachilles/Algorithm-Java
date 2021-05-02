import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RangeModule2 {
    TreeMap<Integer, Integer> map;
    public RangeModule2() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer[] range = getOverlapRange(left,right);
        int new_left = range[0] == null? left: Math.min(range[0],left);
        int new_right = range[1] == null? right:Math.max(range[1],right);

        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
        map.put(new_left,new_right);


    }

    public boolean queryRange(int left, int right) {
        Integer[] range = getOverlapRange(left,right);
        if(range[0] == range[1]) return false;
        return range[0]<=left && range[1]>=right;
    }

    public void removeRange(int left, int right) {
        Integer[] range = getOverlapRange(left,right);
        int new_left = range[0] == null? left: Math.min(range[0],left);
        int new_right = range[1] == null? right:Math.max(range[1],right);

        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
        if (new_left< left) map.put(new_left,left);
        if(new_right>right) map.put(right,new_right);

    }
    // for left, first find the greatest key less than or equal to left-- left upperbound
    // if the [left upperbound] is not overlapping the [left,right], return the next key

    // for right_upperbound, return the the first key great than right
    // for example 10->20 and 21->30
    // add 18->23
    // start -> 21-30
    // end  -> null


    private Integer[] getOverlapRange(int left ,int right){
        Integer left_upperbound = map.floorKey(left);
        if (left_upperbound ==null || map.get(left_upperbound)< left){
            left_upperbound = map.higherKey(left_upperbound);
        }

        Integer right_upperbound = map.ceilingKey(right);
        if (right_upperbound ==null || right_upperbound > right){
            right_upperbound = map.get(map.floorKey(right));
        }
        return new Integer[]{left_upperbound,right_upperbound};
    }
}
