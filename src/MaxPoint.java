import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 9/18/16.
 */


public class MaxPoint {
    // max point on a line
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> lines = new HashMap<>();
            int samePoint = 1;
            int result  = 0;
            Double slop = Double.MAX_VALUE;

            for (int j = i+1; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1] ){
                    samePoint++;
                    continue;
                }

                if (points[i][1] - points[j][1] != 0) {
                    slop = (double) (points[i][0] - points[j][0]) / (double) (points[i][1] - points[j][1]);
                } else {
                    slop = Double.MAX_VALUE;
                }
                lines.put(slop,lines.getOrDefault(slop,0)+1);
                result = Math.max(result,lines.get(slop));

            }

            max = Math.max(max, result+samePoint);
        }

        return max;
    }
}
