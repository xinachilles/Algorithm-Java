import java.util.PriorityQueue;

/**
 * Created by xhu on 2/7/17.
 */


public class KthSmallestElementSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Position> queue = new PriorityQueue<Position>();

        for (int i = 0; i < cols && i < k; i++) {
            queue.offer(new Position(0, i, matrix[0][i]));
        }

        while (!queue.isEmpty() && k > 1) {
            Position current = queue.poll();
            k--;

            if(current.row+1<rows){
                queue.offer(new Position(current.row+1, 0, matrix[current.row+1][current.col]));
            }


        }


        if (!queue.isEmpty()) {
            return queue.peek().val;
        } else {
            return -1;
        }


    }
}
