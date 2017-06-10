import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by xhu on 4/13/17.
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return null;
        }
        double[] result = new double[nums.length-k+1];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        int index = 0;
        double median = -1.0;
        for(int i = 0; i<nums.length; i++){
            if( i>=k ){
                if( minQueue.contains(nums[i-k])){
                    minQueue.remove(nums[i-k]);
                }else{
                    maxQueue.remove(nums[i-k]);
                }
            }

            if(minQueue.size() == 0 || nums[i]<=minQueue.peek()){
                minQueue.offer(nums[i]);
            }else{
                maxQueue.offer(nums[i]);
            }

            if(minQueue.size()>maxQueue.size()+1){
                maxQueue.offer(minQueue.poll());
            }

            if(maxQueue.size()>minQueue.size()){
                minQueue.offer(maxQueue.poll());
            }

            if(i>=k-1){
                if(minQueue.size() == maxQueue.size()){
                    median = (double)minQueue.peek()/2+ (double)maxQueue.peek()/2;
                }else{
                    median = (double)minQueue.peek();
                }

                result[index] = median;
                index++;
            }

        }

        return result;
    }
}
