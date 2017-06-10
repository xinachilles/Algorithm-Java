import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xhu on 3/12/17.
 */
public class KClosestPoints {
    private Point global_origin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        global_origin = origin;
        if(points == null || points.length ==0){
            return new Point[]{};
        }

        PriorityQueue<Point> counts  = new PriorityQueue<Point>(points.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int distance1 = getDistance(o1,global_origin);
                int distance2 = getDistance(o2,global_origin);

                int diff = distance1-distance2;

                if(diff == 0){
                    diff = o1.x-o2.x;
                }

                if (diff == 0){
                    diff = o1.y - o2.y;
                }

                return diff;
            }
        });

        for(Point p :points){

            counts.offer(p);
        }

        Point[] result = new Point[k];

        for(int i = 0; i<k && !counts.isEmpty();i++){
            result[i] = counts.poll();
        }

        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
