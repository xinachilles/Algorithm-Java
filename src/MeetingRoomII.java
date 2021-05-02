import java.util.Arrays;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count = 1;
        int end = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] >=end){
                end = intervals[i][1];
            }else{
                count++;
            }
        }

        return count;

    }
}
