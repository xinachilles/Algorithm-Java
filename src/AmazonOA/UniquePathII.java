package AmazonOA;

/**
 * Created by xhu on 4/16/17.
 */
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
        {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] pathes = new int[row][col];

        if(obstacleGrid[row-1][col-1] == 1){
            pathes[row-1][col-1] = 0;
        }else{
            pathes[row-1][col-1] = 1;
        }

        for(int i = col-2; i>=0; i--){
            if(obstacleGrid[row-1][i] == 1) {
                pathes[row - 1][i] = 0;
            }else{
                pathes[row-1][i] = pathes[row-1][i+1];
            }
        }

        for(int i = row-2; i>=0;i--){
            if(obstacleGrid[i][col-1]  == 1){
                pathes[i][col-1] = 0;
            }else{
                pathes[i][col-1] = pathes[i+1][col-1];
            }
        }

        for(int i = row-2; i>=0;i--){
            for(int j = col-2; j>=0; j--){
                if(obstacleGrid[i][j] == 1){
                    pathes[i][j] = 0;
                }else{

                    pathes[i][j] = pathes[i+1][j]+pathes[i][j+1];
                }
            }
        }

        return pathes[0][0];
    }
}
