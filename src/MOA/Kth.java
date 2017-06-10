package MOA;

import java.awt.*;
import java.util.*;

/**
 * Created by xhu on 6/10/17.
 */
public class Kth {
    class Point implements Comparable<Point>{
        int index;
        int value;

        public Point(int index, int value){
            this.index = index;
            this.value = value;
        }

        public int compareTo(Point p){
            if(this.value == p.value){
                return this.index - p.index;
            }else{
                return this.value-p.value;
            }
        }
    }

    public int[] KthStream(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Deque<Point> queue = new ArrayDeque<Point>() {
        };
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        // store the index
        for (int i = 0; i < nums.length; i++) {
            // if the number is out of range, remove it
            Point newPoint = new Point(i,nums[i]);

            for(Point p :queue){
                if(p.index<i - k + 1){
                    queue.remove(p);
                }
            }


            if (queue.size() == k && queue.peek().value < nums[i]) {
                queue.poll();
            }
            if(queue.size()<k) {
                queue.offer(newPoint);
            }

            if (i >= k - 1) {
                result[index++] = queue.peek().value;
            }
        }

        return result;
    }
}
