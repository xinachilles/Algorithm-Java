import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class NQueue {
    // N-Queue
    public List<List<String>> solveNQueen(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        int[] Queue = new int[n];
        List<Integer> solution = new ArrayList<>();

        solveNQueueHelper(n, result, Queue, 0);
        return result;

    }

    private void solveNQueueHelper(int n, List<List<String>> result, int[] Queue, int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder lines = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (Queue[i] == j) {
                        lines.append("Q");
                    } else {
                        lines.append(".");
                    }
                }

                solution.add(lines.toString());
            }
                result.add(solution);
                return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(i, row, Queue)) {
                Queue[row] = i;
                solveNQueueHelper(n, result, Queue, row + 1);
                Queue[row] = 0;

            }
        }

    }

    private boolean isValid(int col, int row, int[] Queue) {
        for (int i = 0; i < row; i++) {
            if (Queue[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(Queue[i] - col)) {
                return false;
            }
        }

        return true;
    }
}
