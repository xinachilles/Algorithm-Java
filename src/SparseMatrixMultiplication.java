/**
 * Created by xhu on 10/3/16.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length ==0 || B == null || B.length ==0){
            return null;
        }
        int row = A.length;
        int col = A[0].length;

        int colB = B[0].length;

        int[][] result = new int[row][colB];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col;j++){
                for(int k= 0; k<colB;k++){
                    result[i][k] = result[i][k]+ A[i][j]*B[j][k];
                }
            }
        }

        String s = "1";

        Integer.valueOf(s);

        return result;



    }
}
