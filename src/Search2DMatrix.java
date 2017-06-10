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

        int r = 0;


        int start = 0;
        int end = rows - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[start][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start][0] <=target && matrix[start][cols - 1] >= target) {
            r = start;
        } else if (matrix[end][0] <= target && matrix[end][cols - 1] >= target) {
            r = end;
        } else {
            return false;
        }


        start = 0;
        end = cols - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[r][mid] == target) {
                return true;
            }

            if (matrix[r][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[r][start] == target || matrix[r][end] == target) {
            return true;
        } else {
            return false;
        }

    }
}
