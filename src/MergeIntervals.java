import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xhu on 10/23/16.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if(intervals  == null || intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals,((a,b) -> a[0]-b[0]));
        List<int[]> collection = new ArrayList<>();

        int[] a = intervals[0];
        for(int i = 1; i< intervals.length; i++){
            if(a[1]< intervals[i][0]){
                collection.add(a);
                a = intervals[i];
            }else{
                a[1] = Math.max(intervals[i][1], a[1]);
            }
        }
        int[][] result = new int[collection.size()][2];
        for(int j = 0; j< result.length; j++){
            result[j] = collection.get(j);
        }

        return  result;
    }

}
