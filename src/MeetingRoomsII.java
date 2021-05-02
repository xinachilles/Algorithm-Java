import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by xhu on 1/25/17.
 */


public class MeetingRoomsII {
    class Time {
        int time;
        boolean isStart;

        public Time(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;

        }



    }
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals,(a, b)->{return a[0]-b[0];});
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[1][1]);

        for(int i = 1; i<intervals.length;i++){
            while(!queue.isEmpty() && intervals[i][0] >=queue.peek()){
                queue.poll();
            }
            queue.offer(intervals[1][1]);
        }

        return queue.size();
    }
}

