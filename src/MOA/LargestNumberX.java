package MOA;

import java.util.HashMap;
import java.util.Map;

public class LargestNumberX {
    public int getLargeNum(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }

        Map<Integer,Integer> maps  = new HashMap<>();
        for(int a: array){
            maps.put(a,maps.getOrDefault(a,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(int key: maps.keySet()){
            if(key == maps.get(key) && max <key){
                max = key;
            }
        }

        return max;
    }
}
