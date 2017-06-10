/**
 * Created by xhu on 10/29/16.
 */
public class RotateImage {
    //rotate image
    /*public void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
        {
            return;
        }
        int n = matrix.length;
        int[][] matrix2  = new int[n][n];

        for(int i = 0; i<n; n++){
            for(int j = 0; j<n; n++){
                matrix2[j][n-1-i] = matrix[i][j];
            }
        }


        for(int i = 0; i<n;i++){
            for(int j = 0; j<n; j++){

                matrix[i][j] = matrix2[i][j];
            }
        }
    }*/

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int row = matrix.length;

        reverseByRows(matrix);
        reverseAll(matrix);
    }

    private void reverseByRows(int[][] matrix) {
        int start = 0;
        int end = matrix.length;

        while (start < end) {
            for (int i = 0; i < matrix[0].length; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
        }
    }

    private void reverseAll(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
