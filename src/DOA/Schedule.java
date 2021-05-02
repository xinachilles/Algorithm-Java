package DOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Schedule {
    List<int[]> schedule(List<int[]> bookings, int a, int b,int duration){
        if(bookings == null || bookings.size()==0){
            return null;
        }
        // sort the start time
        Collections.sort(bookings,(c,d)->{return c[0]-d[0];} );
        // merge all the slot to temp list
        List<int[]> temp = new ArrayList<>();
        int[] slot = bookings.get(0);
        // merge all the time slot
        for(int i =1; i<bookings.size();i++){
            if(bookings.get(i)[0]>slot[1]){
                temp.add(slot);
                slot = bookings.get(i);
            }else{
                slot[1] = Math.max(slot[1],bookings.get(i)[1]);
            }
        }
        temp.add(slot);
        List<int[]> result = new ArrayList<>();
        if(a+duration<temp.get(0)[0]){
            result.add(new int[]{a,a+duration});
        }
        for(int i = 0; i<temp.size()-1;i++){
            if(temp.get(i)[1]+duration<=temp.get(i+1)[0] && temp.get(i)[1]>=a && temp.get(i+1)[0]<=b){
                result.add(new int[]{ temp.get(i)[1],temp.get(i+1)[0] });
            }
        }
        // return 50 60 or 50 58
        if(temp.get(temp.size()-1)[1]+duration<=b){
            result.add(new int[]{temp.get(temp.size()-1)[1], temp.get(temp.size()-1)[1]+duration} );
        }

        return result;
    }
}
