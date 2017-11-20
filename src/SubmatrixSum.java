import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 6/17/17.
 */
public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] result = new int[2][2];

        if(matrix == null || matrix.length ==0){
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int left = 0; left<cols; left++){
            int[] colSum = new int[rows];

            for(int right = left; right<cols; right++) {
                for (int i = 0; i < rows; i++) {
                    colSum[i] += matrix[i][right];
                }


                Map<Integer, Integer> index = new HashMap<>();
                index.put(0, 0); // sum ,row
                int sum = 0;
                for (int j = 0; j < rows; j++) {
                    sum = sum + colSum[j];

                    if (index.containsKey(sum)) {
                        int row = index.get(sum);

                        result[0][0] = row;
                        result[0][1] = left;

                        result[0][0] = j;
                        result[0][1] = right;
                    }

                     index.put(sum,j);
                }
            }
        }

        return result;
    }
}
