package FBOA;

import java.util.Arrays;
import java.util.Comparator;

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
public class MinimumCoverInterval {

    public int findCover(Interval[] intervals, Interval interval) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                if (inter1.start == inter2.start) {
                    return inter1.end - inter2.end;
                }
                return inter1.start - inter2.start;
            }
        });
        int count = 0;
        int start = interval.start;
        int end = -1;
        int index = 0;
        while (index < intervals.length && end < interval.end) {
            if (intervals[index].end <= start) {
                index++;
                continue;
            }
            if (intervals[index].start > start) {
                break;
            }
            while (index < intervals.length && end < interval.end && intervals[index].start <= start) {
                end = Math.max(intervals[index].end, end);
                index++;
            }
            if (start != end) {
                count++;
                start = end;
            }
        }
        if (end < interval.end) {
            return 0;
        }
        return count;
    }
//Given A=[[0,3],[3,4],[4,6],[2,7]] B=[0,6] return 2 since we can use [0,3] [2,7] to cover the B
    public static void main(String[] arg) {
        MinimumCoverInterval  c  = new MinimumCoverInterval();
        c.findCover(new Interval[]{new Interval(0,3), new Interval(3,4), new Interval(4,6), new Interval(2,7) }, new Interval(0,6));
    }

}
