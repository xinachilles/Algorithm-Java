public class WhereWillBallFall {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid.length];
        int rows = grid.length;
        int cols = grid[0].length;

        for(int row= 0;row<rows; row++){

            int c = 0;
            int r = row;

            while(r<rows-1 &&c<cols){
                if(grid[r][c] == 1){
                    if(c+1<cols && grid[r][c+1] ==1){
                        c++;
                        r++;
                    }else{
                        c = -1;
                        break;
                    }
                }else if(grid[r][c] == -1){
                    if(c-1>=0 && grid[r][c-1] ==-1){
                        c--;
                        r++;
                    }else{
                        c = -1;
                        break;
                    }
                }

            }

            result[r] = c;
        }

        return result;
    }
}
