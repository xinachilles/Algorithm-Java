import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][]result = new int[R*C][2];

        int[][] moves = new int[][] {{1,0}, {0,1}, {-1,0},{0,-1}};
        int count = 0;
        int step =  1;
        int d = 0;
        result[0] = new int[]{r0,c0};

        while(count < R*C){
            if(d>=4) {
                d = d %4;
                step++;
            }
            for(int i = 0; i<step; i++){

                int x  = moves[d][0];
                int y  = moves[d][1];

                if(x<0 || x>=R || y<0 || y>=C){
                    d++;
                    break;
                }else{
                    r0 = x;
                    c0 = y;
                    result[count] = new int[]{r0,c0};
                    count++;
                }
            }
        }

        return result;
    }
    }


