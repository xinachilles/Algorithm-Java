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
        Deque<Integer> deque = new ArrayDeque<>();
        int result = Integer.MIN_VALUE;
        deque.addLast(0);
        // deque will store the index of point
        for(int i = 1; i<points.length;i++){
            // pop all the point which points[i][0] - peek[0]>k
            while(!deque.isEmpty() && points[i][0]- points[deque.peek()][0]>k){
                deque.removeFirst();
            }
            if(!deque.isEmpty()){
                result = Math.max(result, points[i][1]+points[i][0]+  points[deque.peek()][1]-points[deque.peek()][0]);
            }
            // find the max point from i to i-k which yi-xi is max
            while (!deque.isEmpty() && points[i][1]-points[i][0] > points[deque.peek()][1]-points[deque.peek()][0]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return result;
    }
}
