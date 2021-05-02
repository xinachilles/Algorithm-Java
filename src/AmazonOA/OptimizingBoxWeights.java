package AmazonOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class OptimizingBoxWeights {
    public  List<Integer> optimizingBoxWeights(int[] arr) {
       int target = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
       for(int i = 0; i<arr.length;i++){
           target+=arr[i];
           pq.add(arr[i]);
       }

       int curSum = 0;
        List<Integer> res = new ArrayList<>();
        while (curSum <= target/2) {
            int val = pq.poll();
            curSum += val;
            res.add(val);
        }
        Collections.reverse(res);
        return res;
    }
}
