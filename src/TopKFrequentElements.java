import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhu on 9/18/16.
 */
public class TopKFrequentElements {
    //top k frequent element

// 1.the input array is sort?
// 2. do you need the result is sorted?(yes, for this question)
// 3. sort base on what, base on the value or base on the number of value (base on frequency)

    // sort a hashMap, the pair is value and the number of this value in this array,
// ask if the array is like {1,2,3} and k=2, return what?
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> maps = new HashMap<>();

        for (int i : nums) {
            maps.put(i,maps.getOrDefault(i,0)+1);

        }
        // sort the maps by frequency (maps`s value) use the bucketsort.
        // for exmple, if array [1,1,1 2,2]. the maps shoulbe be like  {1,3}  {2,2}
        // the bucket arrya should be  [null, null, 2, 1];

        // bucket array index is the frequency,
        List<Integer>[] bucket = new List[nums.length+1];

        for (int key : maps.keySet()) {

            if (bucket[maps.get(key)] == null) {
                bucket[maps.get(key)] =  new ArrayList<Integer>();
            }
            bucket[maps.get(key)].add(key);
        }



        int index = nums.length;
        while (result.size()<k && index >= 0) {
            if (bucket[index] != null) {
                result.addAll(bucket[index]);

            }

            index--;
        }

        return result;

    }
}
