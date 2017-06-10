/**
 * Created by xhu on 12/20/16.
 */
public class NumMatrix {
    int[][] sumMatrix = null;

    public NumMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        sumMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum = sum + matrix[i][j];
                sumMatrix[i][j] = sum;
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                sum = sum + sumMatrix[i][col2];
            } else {
                sum = sum + sumMatrix[i][col2] - sumMatrix[i][col1 - 1];
            }
        }

        return sum;
    }
}
