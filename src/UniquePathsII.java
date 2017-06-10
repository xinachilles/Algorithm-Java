/**
 * Created by xhu on 10/29/16.
 */
public class UniquePathsII {
    //unique path ii

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[]ways = new int[col];



        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[j] = 0;
                }
                else {
                   if(j == 0){
                       if(row == 0){
                           ways[j] = 1;
                       }
                   }else{
                       ways[j] += ways[j-1];
                   }

                }
            }
        }


        return ways[col];


    }


}
