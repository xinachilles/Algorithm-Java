import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        // create a hashmap key is x and value is set of points with same x axes but differnt y axes
        HashMap<Integer, Set<Integer>>  maps = new HashMap<>();
        for(int i = 0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            if(!maps.containsKey(x)){
                maps.put(x,new HashSet<>());
            }
            maps.get(x).add(y);
        }
        int min = Integer.MAX_VALUE;
        for(int i  =0; i<points.length;i++){
            for(int j = i+1; j<points.length;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 || y1 == y2 ){
                    continue;
                }

                int x3 = x1;
                int y3 = y2;

                int x4 = x2;
                int y4 = y1;

                if(!maps.get(x3).contains(y3) || !maps.get(x4).contains(y4)){
                    continue;
                }
                min = Math.min(min, Math.abs(y1-y3) * Math.abs(y1-y3));
            }
        }
        return min;
    }
}
