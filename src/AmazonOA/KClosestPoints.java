package AmazonOA;

import java.util.*;

/**
 * Created by xhu on 3/12/17.
 */
public class KClosestPoints {
    /*private Point global_origin = null;*/
    public List<List<Integer>> kClosestHeap(List<List<Integer>> points,int k) {
        // Write your code here
       // global_origin = origin;
        if(points == null || points.size() ==0){
            return null;
        }

        List<Integer> origin =  Arrays.asList(new Integer[]{0,0});

        PriorityQueue<List<Integer>> counts  = new PriorityQueue<List<Integer>>(points.size(), new  Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                double distance1 = getDistance(o1,origin);
                double distance2 = getDistance(o2,origin);

                double diff = distance1-distance2;

                if(diff == 0){
                    diff = o1.get(0)-o2.get(0);
                }

                if (diff == 0){
                    diff = o1.get(1) - o2.get(1);
                }

                return (int)diff;
            }
        });

        for(List<Integer> p :points){

            counts.offer(p);
        }

        List<List<Integer>> result =new ArrayList<>();

        for(int i = 0; i<k && !counts.isEmpty();i++){
            result.add(counts.poll());
        }

        return result;
    }


  /*  private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }*/

    public List<List<Integer>> kClosest(List<List<Integer>> points,int k) {
        // Write your code here
        if (points == null || points.size() == 0) {
            return null;
        }

        searchKpoint(points, k, 0, points.size() - 1, Arrays.asList(new Integer[]{0,0}));

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(points.get(i));
        }

        return result;
    }

    private void searchKpoint(List<List<Integer>> points, int k, int start, int end, List<Integer> origin) {


        int lo = start;
        int hi = end;
        List<Integer> povit = points.get(start);
        double distance = getDistance(povit, origin);

        while (lo <= hi) {
            while (lo <= hi && getDistance(points.get(lo), origin) <= distance) {
                lo++;
            }

            while (lo <= hi && getDistance(points.get(hi), origin) > distance) {
                hi--;
            }

            if (lo <= hi) {
                swap(points, lo, hi);
                lo++;
                hi--;
            }
        }

        swap(points, hi, start);


        if (hi + 1 == k) {
            return;
        } else if (hi < k) {
            searchKpoint(points, k, hi + 1, end, origin);
        } else {
            searchKpoint(points, k, start, hi - 1, origin);
        }

    }


    private double getDistance(List<Integer> A, List<Integer> B) {
        if (A == null || A.size() != 2 || B == null || B.size() != 2) {
            return -1;
        }

        int xDistance = Math.abs(A.get(0) - B.get(0));
        int yDistance = Math.abs(A.get(1) - B.get(1));
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public void swap(List<List<Integer>> points, int i, int j) {
        List<Integer> temp = points.get(i);
        points.set(i, points.get(j));
        points.set(j, temp);
    }
}
