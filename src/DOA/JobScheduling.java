package DOA;

import java.util.Arrays;
import java.util.TreeMap;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        // sort by ending time
        Arrays.sort(jobs, (a, b)->a[1] - b[1]);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        // key will be the job i ' ending time  and value will be total profit cab be get for 0 to i
        //dp.put(0, 0);
        for (int[] job : jobs) {
            if(dp.isEmpty()){
                dp.put(job[1], job[2]);
            }else{
            // if we take this job, we need find the lagest ending time <job[0]
            int take  = dp.floorEntry(job[0]).getValue() + job[2];
            if (take > dp.lastEntry().getValue())
                dp.put(job[1], take);
            }
        }
        return dp.lastEntry().getValue();
    }
}
