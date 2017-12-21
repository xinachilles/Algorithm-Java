package AmazonOA;

import java.util.*;

public class Golf {

    private class newComapre implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }


    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();

        int row = forest.size();
        int col = forest.get(0).size();


        for (int r = 0; r < forest.size(); ++r) {
            for (int c = 0; c < forest.get(r).size(); ++c) {

                int v = forest.get(r).get(c);
                if (v > 1) trees.add(new int[]{v, r, c});
            }
        }

        Collections.sort(trees, new newComapre());
        int[][] source = {new int[]{0, 0}, new int[]{0, col - 1}, new int[]{row - 1, 0}, new int[]{row - 1, col - 1}};


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {

            int ans = 0, sr = source[i][0], sc = source[i][1];

            if(forest.get(sr).get(sc)!=1){
                continue;
            }

            List<List<Integer>> temp = new ArrayList<>();
            for(List f : forest){
                temp.add(new ArrayList<>(f));
            }


            for (int[] tree : trees) {

                int[] d = distance(temp, sr, sc, tree[0], row, col);
                if (d[0] < 0) {

                    ans = Integer.MAX_VALUE;
                    break;
                }


                ans += d[0];
                sr = d[1];
                sc = d[2];
                temp.get(d[1]).set(d[2], 1);

            }


            min = Math.min(ans, min);

        }

        return min;

    }


    private int[] distance(List<List<Integer>> forest, int SourceX, int SouceY, int target, int row, int col) {


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] visited = new boolean[row][col];


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{SourceX, SouceY});


        visited[SourceX][SouceY] = true;
        int step = 0;


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                if (forest.get(current[0]).get(current[1]) == target) {
                        return new int[]{step, current[0], current[1]};
                }


                for (int j = 0; j < 4; j++)
                {

                    int r = current[0] + dr[j];
                    int c = current[1] + dc[j];

                    if (0 <= r && r < row && 0 <= c && c < col && !visited[r][c] && forest.get(r).get(c) > 0) {

                        visited[r][c] = true;
                        queue.offer(new int[]{r, c});
                    }

                }
            }


            step++;

        }

        return new int[]{-1, -1, -1};


    }
}
