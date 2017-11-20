import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xhu on 3/12/17.
 */
public class KClosestPoints {
    /*private Point global_origin = null;
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
    }*/


  /*  private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }*/

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if (points == null || points.length == 0) {
            return null;
        }

        searchKpoint(points, k, 0, points.length - 1, origin);

        Point[] result = new Point[k + 1];

        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }

    private void searchKpoint(Point[] points, int k, int start, int end, Point origin) {


        int lo = start;
        int hi = end;
        Point povit = points[start];
        double distance = getDistance(povit,origin);

        while (lo <= hi) {
            while (lo <= hi && getDistance(points[lo], origin) <= distance) {
                lo++;
            }

            while (lo <= hi && getDistance(points[hi], origin) > distance) {
                hi--;
            }

            if(lo<=hi){
                swap(points, lo, hi);
                lo++;
                hi--;
            }
        }

        swap(points,hi,start);


        if (hi+1 == k) {
            return;
        } else if (hi < k) {
            searchKpoint(points, k, hi + 1, end, origin);
        } else {
            searchKpoint(points, k, start, hi - 1, origin);
        }

    }


    private double getDistance(Point A, Point B) {
        int xDistance = Math.abs(A.x - B.x);
        int yDistance = Math.abs(A.y - B.y);
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
    public  void swap(Point[] points, int i, int j) {
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
