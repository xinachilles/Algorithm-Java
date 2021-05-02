import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int end = intervals[0][1];
        int count = 0;
        // find the max number of non-overlapping
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] >= end){
                count++;
                end = intervals[i][1];
            }
        }
       return intervals.length-count;

       }
}
