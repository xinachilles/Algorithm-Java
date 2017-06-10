/**
 * Created by xhu on 2/11/17.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n)
    {
        int[][] matrix =new int[n][n];

        int startRow = 0;
        int endRow = n-1;

        int startCol = 0;
        int endCol = n-1;

        int data = 1;

        while(startRow<=endRow && startCol<=endCol){
            for(int i = startCol;i<=endCol;i++){
                matrix[startRow][i]  = data;
                data++;
            }

            startRow++;

            for(int i = startRow; i<=endRow; i++){
                matrix[i][endCol] = data;
                data++;
            }

            endCol--;

            if(startRow<=endRow){
                for(int i = endCol;i>=startCol;i--){
                    matrix[endRow][i]  = data;
                    data++;
                }
            }

            endRow--;

            if(startCol<=endCol){
                for(int i = endRow; i>=startRow; i--){
                    matrix[i][startCol] = data;
                    data++;
                }
            }

            startCol++;
        }

        return matrix;
    }
}
