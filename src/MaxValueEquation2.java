import java.util.PriorityQueue;

public class MaxValueEquation2 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //create a pair y-x, x and store it in a max heap, the max heap is sorted base on the y-x

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->(a[0]==b[0]? a[1]-b[1]: b[0]-a[0]));
        // try to push all the element in the point to the max heap
        // for each j, keep pop unitl xj-xtop <=k, the top value will be the largest y-x we can use
        int result = Integer.MIN_VALUE;
        for(int[] point: points){
            int x = point[0];
            int y = point[1];

            while(!heap.isEmpty() && x-heap.peek()[1]>k){
                heap.poll();
            }
            if (!heap.isEmpty()){
                result = Math.max(result,x+y+heap.poll()[0]);
            }
            heap.offer(new int[]{y-x,x});
        }
            return result;
    }
}
