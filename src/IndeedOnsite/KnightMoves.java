package IndeedOnsite;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class KnightMoves {
    public int minKnightMoves(int x, int y) {
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        Queue<int[]> visiting = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        visiting.offer(new int[]{0, 0});
        int step = 0;
        visited.add("0,0");

        while (!visiting.isEmpty()) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                int[] current = visiting.poll();

                visited.add(current[0] + "," + current[1]);

                for (int j = 0; j < 8; j++) {
                    int r = current[0] + moves[j][0];
                    int c = current[1] + moves[j][1];

                    if (r == x && c== y) {
                        return step+1;
                    }

                    String position = r + "," + c;
                    if (!visited.contains(position) && r >= -1 && c >= -1) {
                        visiting.add(new int[]{r, c});
                    }


                }
            }
            step++;
        }
        return -1;
    }


/*
* we can convert  the x and y to the absolute value since

and we just need focus on first quadrant  which is x>0 and y>0
since the step from 0.0 to -1 -1 is equal to the 0.0  to 1.1

the reason r>=-1 c>=-1 is if the destination is  1,1 the shortest path is (0,0) -> (2, -1) -> (1,1)
* */
    public int minKnightMoves2(int x, int y) {
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        x= Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> visiting = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        visiting.offer(new int[]{0, 0});
        int step = 0;
        visited.add("0,0");

        while (!visiting.isEmpty()) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                int[] current = visiting.poll();

                if (current[0] == x && current[1]== y) {
                    return step;
                }


                for (int j = 0; j < 8; j++) {
                    int r = current[0] + moves[j][0];
                    int c = current[1] + moves[j][1];



                    String position = r + "," + c;
                    if (!visited.contains(position) && r>=-1 && c>=-1) {
                        visiting.add(new int[]{r, c});
                        visited.add(r + "," + c);
                    }


                }
            }
            step++;
        }
        return -1;
    }


}
