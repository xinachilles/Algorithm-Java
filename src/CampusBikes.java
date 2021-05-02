import java.util.*;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // the array {i,j,k } present the the distances from ith work to jth bike is k
        // the priority queue sorted by distance, the smallest distance put on the top
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{if(a[2] == a[2]){ return a[0]-b[0];} else{return a[2]-b[2];}} );
        for(int i = 0; i<workers.length; i++){
           for(int j = 0; j<bikes.length;j++){
                int[] d = new int[]{i,j,distance(workers[i],bikes[j]) };
                pq.offer(d);
           }
       }

        HashSet<Integer> used = new HashSet<>();
        int[] result = new int[workers.length];
        Arrays.fill(result,-1);
        while (pq.size()> 0 && used.size()<bikes.length){
            int[] q = pq.poll();
            int work_id = q[0];
            int bike_id = q[1];
            if(!used.contains(bike_id) && result[work_id]==-1 ){
                result[work_id] = bike_id;
                used.add(bike_id);
            }
        }
        return result;

    }
    private int distance(int[]a, int[]b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1]-b[1]);
    }
}
