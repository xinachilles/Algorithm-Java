import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {
    class Element implements Comparable<Element> {
        int index;
        int value;

        public Element(int index, int vlaue) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Element el){
            if(value==el.value)
                return 0;
            else if(value>el.value)
                return 1;
            else
                return -1;
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[]{};
        }


        int[]  result = new int[nums.length-k+1];

        PriorityQueue<Element> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());

        for(int i = 0; i<nums.length; i++){
            while (!pq.isEmpty() && pq.peek().index<= i-k ){
                pq.poll();
            }
            Element e = new Element(nums[i],i);
            pq.offer(e);

            if(i-k+1>=0){
                result[i-k+1] = nums[pq.peek().index];
            }

        }

        return result;


}
}
