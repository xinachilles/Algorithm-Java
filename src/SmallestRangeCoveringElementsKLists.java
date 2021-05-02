import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsKLists {
    /*

    use of an array of pointers, next



​
 ) elements from amongst the elements currently pointed by nextnext. The range formed by these maximum and minimum elements surely
contains atleast one element from each list.
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // group of index, next[i] mean the current point of nums[i]
        int[] next = new int[nums.size()];

        boolean stop = false;
        int gobal_max = Integer.MIN_VALUE;
        int gobal_min = 0;

        int max = Integer.MAX_VALUE;

        PriorityQueue< Integer > min_queue = new PriorityQueue < Integer > ((i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        for(int i = 0;i<nums.size();i++){
            min_queue.offer(i);
            max = Math.max(max,nums.get(i).get(0));
        }

        for (int i = 0; i < next.length && !stop; i++) {
            for (int j = 0; j < nums.get(i).size() && !stop; j++) {

                int min_i = min_queue.poll();
                if (gobal_max-gobal_min > max - nums.get(min_i).get(next[min_i])) {
                    gobal_min = min_i;
                    gobal_max = max;
                }

                next[min_i]++;
                if (next[min_i] == nums.get(min_i).size()) {
                    stop = true;
                    break;
                }
                min_queue.offer(min_i);
                max = Math.max(max, nums.get(min_i).get(next[min_i]));

            }
        }

        return new int[]{gobal_min, gobal_max};
    }
}
