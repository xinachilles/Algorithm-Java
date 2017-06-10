/**
 * Created by xhu on 11/17/16.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length ==0 || matrix[0].length ==0){
                return false;
            }

            int row = matrix.length-1;
            int col = 0;

            while (row>=0 && col >=0){
                if(matrix[row][col] == target){
                    return true;
                }else if(matrix[row][col]<target){
                    col++;
                }else{
                    row--;
                }

            }

            return false;
    }
}
