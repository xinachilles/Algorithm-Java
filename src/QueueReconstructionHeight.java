import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionHeight {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return null;
        }
        Arrays.sort(people, ((a,b)-> a[1]==b[1]? a[0]-b[0]:b[1]-a[1]));
        List<int[]> result = new ArrayList<>();
        for(int[] p: people){
            result.add(p[1],p);
        }
        return result.toArray(new int[result.size()][2]);


    }
}
