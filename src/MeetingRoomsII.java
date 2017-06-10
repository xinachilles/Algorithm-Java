import java.util.*;

/**
 * Created by xhu on 1/25/17.
 */


public class MeetingRoomsII {
    class Time implements  Comparable<Time>{
        int time;
        boolean isStart;

        public Time(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;

        }

        @Override
        public  int compareTo(Time a){
            if(this.time == a.time){
                if(a.isStart){
                    return -1;
                }else{
                    return  1;
                }
            }else{
                return this.time - a.time;
            }

        }

    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        List<Time> times = new ArrayList<>();
        for(Interval i : intervals){
            times.add(new Time(i.start,true));
            times.add(new Time(i.end,false));
        }

        Collections.sort(times);
        int count = 0;
        int max = 0;

        for(Time t:times){
            if(t.isStart){
                count ++;
            }else{
                count --;
            }

            max = Math.max(max,count);
        }

        return max;
    }
}

