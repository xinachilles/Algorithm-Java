import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;

import java.util.*;
import javafx.util.*;

public class MinimumAreaRectangleII {

    public double minAreaFreeRect(int[][] points) {
        // create a map, take point x1, y1, x2,y2 as example, the key is the pair(x1-x2, y1-y2) and value is
        // List of index of  {x1,y1} and {x2,y2} ; we can say x1,y1 and x2 y2 have the same direction
        // {x1-x2,y1-y2} and {x2-x1, y2-y1} are different
        HashMap<String, List<int[]>> maps = new HashMap<>();
        for(int i = 0; i<points.length;i++){
            for(int j = 0; j<points.length;j++){
                if( i==j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[j][1] - points[j][1];
                String key  = String.valueOf(dx)+","+String.valueOf(dy);
                if(!maps.containsKey(key)){
                    maps.put(key,new ArrayList<>());
                }
                // store the index
                maps.get(key).add(new int[]{i,j});

            }
        }
        // find any 2 line which have same direction
        double min =Double.MAX_VALUE;
        for(String key : maps.keySet()){
            for(int i = 0; i<maps.get(key).size();i++){
                for(int j = i+1; j<maps.get(key).size(); j++){
                    int[] point1 = points[maps.get(key).get(i)[0]];
                    int[] point2 = points[maps.get(key).get(i)[1]];
                    int[] point3 = points[maps.get(key).get(j)[0]];
                    if(point1 == point3 || point2 == point3) continue;
                    int dx1 = point1[0]-point3[0];
                    int dy1 = point1[1]-point3[1];

                    int dx2 = point1[0]-point2[0];
                    int dy2 = point1[1]-point2[1];


                    if( dx1*dx2 +dy1*dy2 != 0) continue;
                    double side1 = Math.pow(point1[0]-point2[0],2) + Math.pow(point1[1]-point2[1],2);
                    double side2 = Math.pow(point1[0]-point3[0],2) + Math.pow(point1[1]-point3[1],2);
                    double area = Math.sqrt(side1) * Math.sqrt(side2);

                    min = Math.min(min,area);


                }
            }
        }
        return min;
    }
}

