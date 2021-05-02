import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] solution = new int[n][2]; // solution [i][1] = speed[i]. solution[i][2] = efficiency[i]
        for(int i = 0; i<n; i++){
            solution[i][0] = speed[i];
            solution[i][1] = efficiency[i];
        }
        // sort by efficiency
        Arrays.sort(solution,(a,b)->{ return b[1]-a[1];});
        // for speed, pop the
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sumS = 0;
        long max  = 0;

        //double mod = Math.pow(10,9)+7;

        for(int i =0; i<n; i++ ){
            sumS+=solution[i][0];


            if(pq.size() ==k) sumS-=pq.poll();

            pq.offer(solution[i][0]);
            max = Math.max(max,sumS *solution[i][1]);


        }
        return (int) (max % (long)(1e9 + 7));
    }
}
