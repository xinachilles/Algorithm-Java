import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by xhu on 3/25/17.
 */
public class MedianFinder {
    // store the number which smaller than media number, descend order
    PriorityQueue<Integer> maxHeap;
    // store the number bigger than media number, ascend order
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        while(maxHeap.size()+1>minHeap.size()){
            minHeap.offer(maxHeap.poll());
        }

        while(minHeap.size()+1>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if(!minHeap.isEmpty() && minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }else if (minHeap.size()>maxHeap.size()){
            return (double) minHeap.peek();
        }else if(maxHeap.size()>minHeap.size()){
            return (double) maxHeap.peek();
        }else{
            return -1;
        }

    }
}
