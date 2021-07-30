import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueEquation {

    //Because xi < xj,
    // yi + yj + |xi - xj| = (yi - xi) + (yj + xj)
    //So for each pair of (xj, yj),
    //we have xj + yj, and we only need to find out the maximum yi - xi.
    // and j -i <=k

    public int findMaxValueOfEquation(int[][] points, int k) {
        if(points == null || points.length == 0){
            return 0;
        }
        // deque will store the a {y-x, x }pair
        Deque<int[]> deque = new ArrayDeque<>();
        int result = Integer.MIN_VALUE;
       // deque.addLast(0);

        for(int[]point: points){
            int x = point[0];
            int y = point[1];
            // pop all the point which points[i][0] - peek[0]>k
            while(!deque.isEmpty() && x- deque.peek()[0]>k){
                deque.removeFirst();
            }
            if(!deque.isEmpty()){
                result = Math.max(result, x+y+ deque.peek()[1]-deque.peek()[0]);
            }
            // find the max point from i to i-k which yi-xi is max
            // only different deque with the pq, for pq we don't need to do this step
            while (!deque.isEmpty() && y-x > deque.peek()[1]-deque.peek()[0]){
                deque.removeLast();
            }
            deque.addLast(new int[]{y-x,x});
        }
        return result;
    }
}
