public class KnightProbabilityChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dp0 = new int[N][N]; // dp0[i][j] means the number of possible move ways the knight can from 0,0 to i,j after k step
        dp0[0][0] = 1;
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        for(int i = 0; i<K;i++){
            int[][]dp1 = new int[N][N];// number of way to move after k+1 step
            for(int r1 = 0; r1<N; r1++){
                for(int c1= 0; c1<N; c1++){
                    for(int j = 0; j<8; i++){
                        int row = r1+moves[j][0];
                        int col = c1+moves[j][1];
                        if(row >=N || row<0 || col >=N || col<0){
                            continue;
                        }

                        dp1[row][col]+=dp0[r1][c1];
                    }
                }
            }
            dp0 = dp1;
        }

        int sum = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                sum+=dp0[i][j];
            }
        }

        return sum/Math.pow(8,K);


    }
}
