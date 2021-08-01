import java.util.Arrays;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row + 1][col + 1][row + 1];

        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[1][1][1] = grid[0][0];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int x = 1; x <= row; x++) {
                    int y = i + j - x;
                    if (y < 1 || y >= col || dp[i][j][x]>0) continue;


                    // up+up, left+up
                    int result1 = Math.max(dp[i-1][j][x-1], dp[i][j-1][x-1]);
                    // up+left, left+left
                    int result2 = Math.max(dp[i-1][j][x], dp[i][j-1][x]);
                    int result =  Math.max(result1,result2);
                    int value = 0;
                    if(i== x && j == y){
                        value = grid[i-1][j-1];
                    }else if(grid[i-1][j-1] == -1 ||grid[x-1][y-1] == -1 ){
                        value = Math.max(grid[x-1][y-1], grid[i-1][j-1]);
                    }else{
                        value = grid[i-1][j-1]+grid[x-1][y-1];
                    }

                    if(result<0 || value<0) {
                        dp[i][j][x] = -1;
                    }else{
                        dp[i][j][x] = result + value;

                    }

                }
            }

        }
        return dp[row][col][row] == -1? 0:dp[row][col][row] ;
    }
}
