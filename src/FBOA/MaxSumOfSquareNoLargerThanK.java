package FBOA;

public class MaxSumOfSquareNoLargerThanK {
    public int sum(int[][] matrix, int m, int k) {
        if (m > matrix.length || m > matrix[0].length) {
            return 0;
        }
        int maxSum = 0;
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            int rectSum = 0;
            for (int row = 0; row < m; row++) {
                rectSum += matrix[row][col];
            }
            sum[0][col] = rectSum;
            for (int row = 1; row < matrix.length - m + 1; row++) {
                rectSum += matrix[row + m - 1][col] - matrix[row - 1][col];
                sum[row][col] = rectSum;
            }
        }
        for (int row = 0; row < matrix.length - m + 1; row++) {
            int squareSum = 0;
            for (int col = 0; col < m; col++) {
                squareSum += sum[row][col];
            }
            if (squareSum < k) {
                maxSum = Math.max(squareSum, maxSum);
            }
            for (int col = 1; col < matrix[0].length - m + 1; col++) {
                squareSum += sum[row][col + m - 1] - sum[row][col - 1];
                if (squareSum < k) {
                    maxSum = Math.max(squareSum, maxSum);
                }
            }
        }
        return maxSum;
    }


    public static void main(String[] arg) {
        MaxSumOfSquareNoLargerThanK  c  = new MaxSumOfSquareNoLargerThanK();
        c.sum(new int[][]{new int[]{1,  0, 1}, new int[] {0, -2, 3 }, new int[]{0,0,0} },3,2 );
    }
}
