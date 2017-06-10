import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 5/22/17.
 */
public class estMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length  == 0){
            return 0;
        }

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                }
            }
        }

        for(int j = 0;j<grid[0].length; j++){
            for(int i = 0; i<grid.length;i++){
                if(grid[i][j] == 1){
                    cols.add(j);
                }
            }
        }

        return distance(rows)+distance(cols);
    }

    private int distance(List<Integer> data){
        int start = 0;
        int end = data.size()-1;
        int dis = 0;
        while(start<end){
            dis += data.get(end)-data.get(start);

            start++;
            end--;
        }

        return dis;
    }
}
