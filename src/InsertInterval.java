import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/30/16.
 */
public class InsertInterval {
    //insert interval
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

}
