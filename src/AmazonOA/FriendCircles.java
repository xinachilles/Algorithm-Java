package AmazonOA;
//547
public class FriendCircles {
    int count = 0;

    public int findCircleNum(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 1 && visited[i][j] == false) {
                    DFS(M, visited, row, col, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    private void DFS(int[][] M, boolean[][] visited, int row, int col, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return;
        }

        if (M[r][c] == 0 || visited[r][c] == true) {
            return;
        }

        visited[r][c] = true;
        if (r + 1 < row && M[r + 1][c] == 1 && visited[r + 1][c] == false) DFS(M, visited, row, col, r + 1, c);
        if (r - 1 >= 0 && M[r - 1][c] == 1 && visited[r - 1][c] == false) DFS(M, visited, row, col, r - 1, c);
        if (c + 1 < col && M[r][c + 1] == 1 && visited[r][c + 1] == false) DFS(M, visited, row, col, r, c + 1);
        if (c - 1 >= 0 && M[r][c - 1] == 1 && visited[r][c - 1] == false) DFS(M, visited, row, col, r, c - 1);


    }
}
