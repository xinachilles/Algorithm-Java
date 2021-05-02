public class KnightDialer {
    public int knightDialer(int N) {
        int modK = 1000000007;
        int[][] dp0 = new int[4][3]; // dp0[i][j] means the number of possible move ways the knight can from 0,0 to i,j after k hops
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

        for(int r = 0; r<4; r++){
            for(int c = 0; c<3;c++){
                dp0[r][c] = 1;
            }
        }

        dp0[3][0] = 0;
        dp0[3][2] = 0;

        for(int i = 0; i<N;i++){
            int[][]dp1 = new int[4][3];// number of way to move after k+1 hops
            for(int r = 0; r<4; r++){
                for(int c= 0; c<3; c++){
                    if( r == 3 && c != 1){
                        continue;
                    }
                    for(int j = 0; j<8; i++){
                        int row = r+moves[j][0];
                        int col = c+moves[j][1];
                        if(row >=4 || row<0 || col >=3 || col<0 || (row== 3 && col!=1) ){
                            continue;
                        }

                        dp1[row][col]+=dp0[r][c] % modK;
                    }
                }
            }
            dp0 = dp1;
        }

        int sum = 0;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<3; j++){
                sum+=dp0[i][j] % modK;
            }
        }

        return sum;
    }
}
