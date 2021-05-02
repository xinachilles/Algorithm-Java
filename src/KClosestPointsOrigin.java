import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KClosestPointsOrigin {
    private Random random = new Random();
    public int[][] kClosest(int[][] points, int K) {

            // Write your code here
            if (points == null || points.length == 0) {
                return null;
            }

            searchKpoint(points, K, 0, points.length - 1, new int[]{0,0});

            int[][] result = new int[K][];

            for (int i = 0; i < K; i++) {
                result[i]= points[i];
            }

            return result;
        }

    private void searchKpoint(int[][] points, int k, int start, int end, int[] origin) {

        int r = random.nextInt(end-start+1)+start;
        int lo = start;
        int hi = end;
        int[] povit = points[r];

        double distance = getDistance(povit, origin);

        while (lo <= hi) {
            while (lo <= hi && getDistance(points[lo], origin) <= distance) {
                lo++;
            }

            while (lo <= hi && getDistance(points[hi], origin) > distance) {
                hi--;
            }

            if (lo <= hi) {
                swap(points, lo, hi);
                lo++;
                hi--;
            }
        }

        swap(points, hi, r);


        if (hi + 1 == k) {
            return;
        } else if (hi < k) {
            searchKpoint(points, k, hi + 1, end, origin);
        } else {
            searchKpoint(points, k, start, hi - 1, origin);
        }

    }

    private double getDistance(int[] A, int[] B) {

        int xDistance = Math.abs(A[0] - B[0]);
        int yDistance = Math.abs(A[1] - B[1]);
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];

        points[i] = points[j];
        points[j] = temp;
    }


    }

