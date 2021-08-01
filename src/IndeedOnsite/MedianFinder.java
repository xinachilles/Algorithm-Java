package IndeedOnsite;

import java.util.Collections;
import java.util.PriorityQueue;

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

        while(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }

        while(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if(!minHeap.isEmpty() && minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }else{
            return (double) maxHeap.peek();

        }
    }
}
