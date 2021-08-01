import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CarFleetII {
    public double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];
        Arrays.fill(result,-1);
        Deque<Integer> dq = new LinkedList<>(); //
        // scan the cars array from right to left
        for(int i =cars.length-2; i>=0;i--) {
            int currnet_v = cars[i][1];
            while (!dq.isEmpty()) {
                int j = dq.getLast();
                int front_v = cars[j][1];
                int ds = cars[j][0] - cars[i][0];

                if (front_v >= currnet_v || (result[j] > 0 && 1.0 * ds / (currnet_v - front_v) >= result[j])) {
                    dq.removeLast();
                } else {
                    break;
                }

            }
            if (!dq.isEmpty()) {
                int j = dq.getLast();
                int front_v = cars[j][1];
                int ds = cars[j][0] - cars[i][0];
                result[i] = 1.0 * ds / (currnet_v - currnet_v);
            }
            dq.addFirst(i);
        }

        return result;
    }
}
