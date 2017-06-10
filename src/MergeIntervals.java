import java.util.ArrayList;
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
    public List<Interval> Merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        intervals.sort(new IntervalComparer());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        for (int i = 1; i < intervals.size(); i++) {
            if (start >= intervals.get(i).end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;

            }
        }

        result.add(new Interval(start, end));
        return result;
    }


    public class IntervalComparer implements Comparator<Interval> {
        @Override
        public int compare(Interval x, Interval y) {
            if (x.start == y.start) {
                return x.end - y.end;
            } else {
                return x.start - y.end;
            }
        }


    }

}
