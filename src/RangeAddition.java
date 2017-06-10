/**
 * Created by xhu on 11/6/16.
 */
public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0 || updates == null || updates.length == 0) {
            return new int[]{0};
        }

        int[] result = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int increase = update[2];

            result[start] += increase;
            if(end+1<result.length) result[end+1] -=increase;



        }
        int sum = 0;
        for(int i = 0; i<length; i++){
            sum +=result[i];
            result[i] = sum;
        }

        return result;

    }
}


