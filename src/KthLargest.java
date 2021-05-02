import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> queue;
    int size;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;
        for(int i = 0; i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(queue.size()>size ){
            if(queue.peek()<val){
               queue.poll();
               queue.offer(val);
            }

        }else{
            queue.offer(val);
        }
        return queue.peek();
    }

}
