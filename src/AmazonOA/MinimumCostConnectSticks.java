package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s:sticks){
            pq.add(s);
        }
        int result = 0;
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            result+= a+b;
            pq.add(a+b);
        }

        return result;
    }
}
