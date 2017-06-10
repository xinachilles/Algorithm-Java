/**
 * Created by xhu on 11/6/16.
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {

        if(nums == null || nums.length ==0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>( );
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
            if(queue.contains(nums[i])){
                continue;
            }
            if(queue.size()>=3) {
                if (queue.peek() < nums[i]) {
                    queue.poll();

                }else{
                    continue;
                }
            }

            queue.offer(nums[i]);

        }

        return queue.size() ==3? queue.peek(): max;
    }
}
