import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid ==null || grid.length ==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int moves[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();

        if(grid[0][0] == 0){
            queue.offer(new int[]{0,0});
        }
        int[][] dp = new int[rows][cols];

        for(int i = 0; i<rows;i++){
            for(int j  =0; j<cols; j++){
                if(grid[i][j] == 0){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0] = 1;
        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size; i++){
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                if(x == rows-1 && y == cols-1){
                    return dp[x][y];
                }else{
                    for(int j = 0; j<8;j++){
                        int dx = x+moves[j][0];
                        int dy = y+moves[j][1];

                        if(dx>=0 && dx<rows && dy>=0 && dy<cols && grid[dx][dy] == 0 ){
                            if(distance+1< dp[dx][dy]){
                                dp[dx][dy] = distance+1;
                                queue.offer(new int[]{dx,dy});
                            }

                        }
                    }
                }

            }
            distance++;
        }





        return -1;
    }
}
