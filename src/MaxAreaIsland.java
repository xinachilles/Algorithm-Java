import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int max = 0;

        for(int i = 0; i<grid.length;i++ ){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,help(grid,i,j));
                }
            }
        }

        return max;
    }

    private  int help(int[][] grid, int r, int c){
        Queue<int[]> visiting = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] moves = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        visiting.offer(new int[]{r,c});
        grid[r][c] = 0;

        int area = 0;
        while(!visiting.isEmpty()){
            int[] current = visiting.poll();
            area++;
            for(int i = 0;i<moves.length;i++){
                int r1 = current[0]+moves[i][0];
                int c1 = current[1]+moves[i][1];
                if(r1>=0 && r1<rows && c1>=0 && c1<cols &&grid[r1][c1]!=0){
                    visiting.offer(new int[]{r1,c1});
                    grid[r1][c1] = 0;
                }
            }
        }
        return area;

    }
}
