import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        Queue<int[]> visiting = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        visiting.offer(new int[]{0, 0});
        int step = 0;

        while (!visiting.isEmpty()) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                int[] current = visiting.poll();
                if (current[0] == x && current[1] == y) {
                    return step;
                }
                visited.add(String.valueOf(current[0]) + "," + String.valueOf(current[1]));

                for (int j = 0; j < 8; j++) {
                    int r = current[0] + moves[j][0];
                    int c = current[1] + moves[j][1];

                    String position = String.valueOf(r) + "," + String.valueOf(c);
                    if (!visited.contains(position) && r >= -1 && c >= -1) {
                        visiting.add(new int[]{r, c});
                    }


                }
            }
            step++;
        }
        return -1;
    }
}
