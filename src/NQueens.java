import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/24/16.
 */
public class NQueens {

    public class Solution {
        public int solveNQueens(int n) {

            if (n <= 0) {
                return 0;
            }

            int[] Queue = new int[n];
            List<Integer> solution = new ArrayList<>();

            return solveNQueueHelper(n, Queue, 0);

        }

        private int solveNQueueHelper(int n, int[] Queue, int row) {
            if (row == n) {

                return 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (isValid(i, row, Queue)) {
                    Queue[row] = i;
                    count = count + solveNQueueHelper(n, Queue, row + 1);
                    Queue[row] = 0;

                }
            }

            return count;

        }

        private boolean isValid(int col, int row, int[] Queue) {
            for (int i = 0; i < row; i++) {
                if (Queue[i] == col) {
                    return false;
                }

                if (i + Queue[i] == row + col) {
                    return false;
                }

                if (i-Queue[i] == row - col) {
                    return false;
                }
            }

            return true;
        }
    }


}
