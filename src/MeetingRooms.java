import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xhu on 1/25/17.
 */
class IntervalCompartor implements Comparator<Interval>{

    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}
public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }

        Arrays.sort(intervals,new IntervalCompartor() );


        for(int i = 1;i<intervals.length;i++){
            if(intervals[i].start<intervals[i-1].end){
                return false;
            }
        }

        return true;

    }
}
