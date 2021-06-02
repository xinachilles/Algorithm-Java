package IndeedOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributeList {
  //  先给出了了O(n*2)的解法，后来发现可以先数⼀一遍字符个数，找到出现最多的，⽐比如a出现3
  //  次，就建3个⼦子list，然后把每种字符round robin那样放进各个list就⾏行行了了， 这样是O(n)
    // find the maximum repeating element in the array
    // find the element with highest occurence in the array
    List<List<Integer>> gao(List<Integer> input) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i: input) {
            map.put(i,map.getOrDefault(i,0)+1);
            max = Math.max(map.get(i),max);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < max; ++i) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        int cur = 0;

        for (int key :map.keySet()) {
           for(int i = 0; i<map.get(key);i++){

                result.get(cur).add(key);
                cur = (cur + 1) % max;
            }
        }
        return result;
    }
        }

