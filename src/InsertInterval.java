import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class InsertInterval {
    //insert interval
    /*
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        intervals.sort(new IntervalCompartor());
        int start = newInterval.start;
        int end = newInterval.end;


        for (Interval i : intervals) {


            if (i.end < start) {
                result.add(i);
            } else if (i.start > end) {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            } else {
                start = Math.min(newInterval.start, i.start);
                end = Math.max(newInterval.end, i.end);
            }

        }

        result.add(new Interval(start, end));

        return result;
    }
    */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        for (; i < intervals.length; i++) {

            if (intervals[i][1] < start) {
                result.add(intervals[i]);
            } else if (end >= intervals[i][1]) {
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            } else {
                break;
            }

        }

        result.add(new int[]{start, end});
        for (int j = i; i < intervals.length; i++) {
            result.add(intervals[j]);
        }

        return result.toArray(new int[result.size()][2]);

    }
}
