import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xhu on 2/20/17.
 */
public class NumberIslandsII {
    private UnionFind un;
    // number of islands ii
    // for each postion, seach its right, left, up and down. if find the island, union them together.
    // use a set to store the island`s parents. the count of hashset is the number of island.


    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0) {
            return result;
        }
        int count = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        UnionFind un = new UnionFind(m * n);
        HashSet<Integer> counts = new HashSet<Integer>();
        int[][] matrix = new int[m][n];

        for (int[] p : positions) {
            int x1 = p[0];
            int y1 = p[1];
            if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) {
                continue;
            }

            matrix[x1][y1] = 1;
            int id1 = un.id(x1, y1, n);
            count++;

            for (int i = 0; i < 4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && matrix[x2][y2] == 1) {
                    int id2 = un.id(x2, y2, n);

                    if (un.compress_find(id1) != un.compress_find(id2)) {
                        un.union(id1, id2);
                        count--;
                    }
                }
            }

            result.add(count);

        }


        return result;
    }
}
