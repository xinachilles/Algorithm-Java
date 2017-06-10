/**
 * Created by xhu on 11/19/16.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }

        int sum = 0;
        int index = citations.length;

        for(int i = citations.length; i>=0; i--){
            sum++;
            if(citations[i]<index){
                index = citations[i];
            }

            if(sum >= index){
                return index;
            }
        }

        return 0;
    }
}
