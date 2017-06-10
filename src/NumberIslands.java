import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 12/28/16.
 */
public class NumberIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        UnionFind un = new UnionFind(row * col);
        Set<Integer> count = new HashSet<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int id1 = un.id(i, j, col);

                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];


                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {

                            int id2 = un.id(x, y, col);

                            if (un.compress_find(id1) != un.compress_find(id2)) {
                                un.union(id1, id2);
                            }
                        }
                    }

                    if (!count.contains(un.compress_find(id1))) {
                        count.add(un.compress_find(id1));
                    }
                }


            }
        }

        return count.size();
    }

}
