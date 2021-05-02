import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones == null ||stones.length == 0 ){
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for(int i = 0; i<stones.length;i++){
            heap.offer(stones[i]);
        }
        while(heap.size()>1){
            int max1 = heap.poll();
            int max2 = heap.poll();
            if(max1!= max2){
                heap.offer(max1-max2);
            }
        }

        if(heap.size()>0){
            return heap.poll();
        }else{
            return 0;
        }




    }
}
