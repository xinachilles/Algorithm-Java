import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xhu on 1/1/17.
 */
public class AndroidUnlockPatterns {

    /*//bfs every ppint
    public int numberOfPatterns(int m, int n) {
        if (m == 0 || n == 0 || m > n) {
            return 0;
        }


        int row = 3;
        int col = 3;
        int[] dx = {1, 0, -1, 0,1,1,-1,-1 };
        int[] dy = {0, 1, 0, -1,1,-1,1 ,-1};
        int sum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Queue<Integer[]> visiting = new LinkedList<>();
                int count = 0;
                int length = 1;
                boolean[][] visited = new boolean[row][col];
                visiting.offer(new Integer[]{i, j});
                visited[i][j] = true;

                while (!visiting.isEmpty()) {
                    int size = visiting.size();
                    for (int s = 0; s < size; s++) {
                        Integer[] current = visiting.poll();

                        if (length >= m) {
                            count++;
                        }

                        for (int k = 0; k < 8; k++) {
                            int x = current[0] + dx[k];
                            int y = current[1] + dy[k];

                            if (x >= 0 && x < 3 && y >= 0 && y < 3 && visited[x][y] == false && length < n) {


                                visited[x][y] = true;
                                visiting.offer(new Integer[]{x, y});
                            }

                        }

                    }

                    length++;

                }
                sum = sum + count;
            }


        }

        return sum;
    }*/

    //  dfs all possible combination from 1-9 and skip invalid moves
    // build a jump table if the move requires jump
    // for example jum[1][9] = 5 it means we can jump 1 to 9 if 5 is already visteid

    int count = 0;

    public int numberOfPatterns(int m, int n) {
        if (m <= 0 || n <= 0 || m < n) {
            return 0;
        }

        int[][] board = {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        int row = 3;
        int col = 3;
        int[][] jump = new int[10][10];
        jump[1][3] = 2;
        jump[4][6] = 5;
        jump[7][9] = 8;
        jump[1][7] = 4;
        jump[2][8] = 5;
        jump[3][9] = 6;
        jump[1][9] = 5;
        jump[3][7] = 5;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[] visited = new boolean[10];
                DFS(m, n, i, j, board, visited, jump, 0);
            }
        }

        return count;

    }


    private void DFS(int m, int n, int x, int y, int[][] board, boolean[] visited, int[][] jump, int length) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            return;
        }

        int current = board[x][y];

        if (visited[current]) {
            return;
        }

        if (length > n) {
            return;
        }
        if (length >= m && length <= n) {
            count++;

        }
        visited[current] = true;
        DFS(m, n, x + 1, y, board, visited, jump, length + 1);
        DFS(m, n, x - 1, y, board, visited, jump, length + 1);
        DFS(m, n, x, y + 1, board, visited, jump, length + 1);
        DFS(m, n, x, y - 1, board, visited, jump, length + 1);
        DFS(m, n, x + 1, y + 1, board, visited, jump, length + 1);
        DFS(m, n, x - 1, y - 1, board, visited, jump, length + 1);


        if (current + 2 <= 9 && visited[jump[current][current + 2]])
            DFS(m, n, x + 2, y, board, visited, jump, length + 1);
        if (current - 2 <= 9 && visited[jump[current - 2][current]])
            DFS(m, n, x - 2, y, board, visited, jump, length + 1);

        if (current + 6 <= 9 && visited[jump[current][current + 6]])
            DFS(m, n, x, y + 2, board, visited, jump, length + 1);
        if (current - 6 >= 0 && visited[jump[current - 6][current]])
            DFS(m, n, x, y - 2, board, visited, jump, length + 1);

        if (current + 4 <= 9 && visited[jump[current][current + 4]])
            DFS(m, n, x - 2, y - 2, board, visited, jump, length + 1);
        if (current - 4 >= 0 && visited[jump[current - 4][current]])
            DFS(m, n, x + 2, y + 2, board, visited, jump, length + 1);

        if (current + 8 <= 9 && visited[jump[current][current + 8]])
            DFS(m, n, x + 2, y + 2, board, visited, jump, length + 1);
        if (current - 8 >= 0 && visited[jump[current - 8][current]])
            DFS(m, n, x - 2, y - 2, board, visited, jump, length + 1);


    }
}