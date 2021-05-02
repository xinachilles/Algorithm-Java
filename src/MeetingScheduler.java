import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,(a,b)-> a[0]-b[0]);
        Arrays.sort(slots2,(a,b)-> a[0]-b[0]);

        int index1 = 0;
        int index2 = 0;
        List<Integer> result = new ArrayList<>();

        while(index1<slots1.length && index2<slots2.length){
            int max = Math.max( slots1[index1][0], slots2[index2][0]);
            int min = Math.min(slots1[index1][1], slots2[index2][1]);

            if (max+duration <=min){
                result.add(max);
                result.add(min);
                return result;
            }

            if(slots1[index1][0]<slots2[index2][0]){
                index1++;
            }else{
                index2++;
            }
        }

        return result;
    }
}
