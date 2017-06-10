import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 9/18/16.
 */


public class MaxPoint {
    // max point on a line
    public int maxPoint(Point[] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        int max = 1;
        // i is the index of start point
        for (int i = 0; i < points.length; i++) {
            // go through the point array expct i
            // use hashmap to store a double, integer pair. double is for slop and integer is the number of line which have the same slope
            Map<Double, Integer> maps = new HashMap<>();
            int numberOfSamePoint = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    numberOfSamePoint++;
                    continue;
                }
                Double slope = Double.MAX_VALUE;
                if (points[j].x != points[i].x) {
                    slope = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                }
                if (!maps.containsKey(slope)) {
                    maps.put(slope, 1);
                }

                maps.put(slope, maps.get(slope) + 1);
            }

            for (double key : maps.keySet()) {
                max = Math.max(max, maps.get(key) + numberOfSamePoint);
            }

        }

        return max;

    }
}
