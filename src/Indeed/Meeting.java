package Indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meeting {
    /*
    * 第一题：类似meeting rooms，输入是一个int[][] meetings, int start, int end, 每个数都是时间，13：00 => 1300， 9：30 => 18930， 看新的meeting 能不能安排到meetings
ex: {[1300, 1500], [930, 1200],[830, 845]}, 新的meeting[820, 830], return true; [1450, 1500] return false;
    * */

    public boolean canSchedule(int[][] meeting, int start, int end) {
        for (int i = 0; i < meeting.length; i++) {
            if (
                    (start >= meeting[i][0] && start < meeting[i][1]) ||
                            (end > meeting[i][0] && end <= meeting[i][1]) ||
                            (start < meeting[i][0] && end > meeting[i][1])
            ) {
                return false;
            }
        }
        return true;
    }

    /*
    * 类似merge interval，唯一的区别是输出，输出空闲的时间段，merge完后，再把两两个之间的空的输出就好，注意要加上0 - 第一个的start time
     * */

    public List<int[]> spareTime(int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return null;
        }
        List<int[]> new_meetings = mergeMeetings(meetings);
        List<int[]> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < new_meetings.size(); i++) {
            result.add(new int[]{start, new_meetings.get(i)[0]});
            start = meetings[i][1];
        }
        return result;
}

    private List<int[]> mergeMeetings(int[][] meetings) {
         List<int[]> result = new ArrayList<>();
           Arrays.sort(meetings,(a,b)->a[0]-b[0]);
           int start = meetings[0][0];
           int end = meetings[0][1];


        for (int i =1;i <meetings.length;i++) {
            if (end < meetings[i][0]) {
                result.add(new int[]{start, end});
                start = meetings[i][0];
                end = meetings[i][1];
            }else{
                end = Math.max(end, meetings[i][1]);
            }
        }
        result.add(new int[]{start, end});
        return result;
}




}
