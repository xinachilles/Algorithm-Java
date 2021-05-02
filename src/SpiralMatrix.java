import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/29/16.
 */
public class SpiralMatrix {
    // spiral matrix

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int beginRow = 0;
        int endRow = matrix.length - 1;

        int beginCol = 0;
        int endCol = matrix[0].length - 1;

        while (beginCol < endCol && beginRow < endRow) {

            // upper row
            for (int i = beginCol; i < endCol; i++) {
                result.add(matrix[beginRow][i]);
            }

            // right row
            for (int i = beginRow; i < endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            //bottom row
            for (int i = endCol; i > beginCol; i--) {
                result.add(matrix[endRow][i]);
            }

            for (int i = endRow; i > beginRow; i--) {
                result.add(matrix[i][beginCol]);
            }
        }
        if (beginCol == endCol) {
            for (int i = beginRow; i <= endRow; i++) {
                result.add(matrix[i][beginCol]);
            }
        } else if (beginRow == endRow) {
            for (int i = beginCol; i <= endCol; i++) {
                result.add(matrix[beginRow][i]);
            }
        }


        return result;
    }


}
