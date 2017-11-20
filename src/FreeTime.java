import java.lang.reflect.Array;
import java.util.*;

public class FreeTime {

    public List<String> minMeetingRooms(Interval[] intervals, int start, int end) {
        List<String> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res;
        }

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int begin = start;//the beginTime of freeTime (end of last meeting)
        for (Interval i : intervals) {
            if (begin >= end) {//if the start of free time is out of range(exceeds end), break the loop
                break;
            }
            if (i.start > begin) {//only add time range to res when there is a diff(free time) between two times
                res.add(begin + "-" + Math.min(i.start, end));//if the i.start exceeds end, we pick end to be the boundary
            }
            begin = Math.max(begin, i.end);//update begintime
        }
        return res;
    }
}
