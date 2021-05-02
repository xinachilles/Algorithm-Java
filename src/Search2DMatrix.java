/**
 * Created by xhu on 10/30/16.
 */
public class Search2DMatrix {
    public Boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows*cols-1;
        while(start+1<end){
            int mid = start+ (end-start)/2;
            if(matrix[mid/cols][mid%cols] == target){
                return true;
            }else if (matrix[mid/cols][mid%cols] < target){
                start  = mid;
            }else{
                end = mid;
            }

        }
        if(matrix[start/cols][start%cols] == target){
            return true;
        }

        if(matrix[end/cols][end%cols] == target){
            return true;
        }
        return false;
    }
}
