import java.util.PriorityQueue;

public class MazeIII {
    class Point {
        int row;
        int col;
        int distance;
        String direction;

        public Point(int row, int col, int dis, String d) {
            this.row = row;
            this.col = col;
            this.distance = dis;
            this.direction = d;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || ball == null || hole == null) {
            return "impossible";
        }
        int rows = maze.length;
        int cols = maze[0].length;

        PriorityQueue<Point> visiting = new PriorityQueue<Point>((a, b) -> {
            if (a.distance == b.distance) {
                return a.direction.compareTo(b.direction);
            } else {
                return a.distance - b.distance;
            }

        });
        // if the element first time pop from the queue
        boolean[][] resoved = new boolean[rows][cols];
        visiting.offer(new Point(ball[0], ball[1], 0, ""));
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] directions = new String[]{"d", "u", "r", "l"};

        while (!visiting.isEmpty()) {
            Point current = visiting.poll();

            if (current.row == hole[0] && current.col == hole[1]) {
                return current.direction;
            }

            if (resoved[current.row][current.col]) {
                continue;
            }

            resoved[current.row][current.col] = true;

            for (int i = 0; i < 4; i++) {
                int r = current.row;
                int c = current.col;
                int d = current.distance;
                String direction = current.direction;
                // down
                while (!outofBoundary(r + moves[i][0], c + moves[i][1], rows, cols)
                        && maze[r + moves[i][0]][c + moves[i][1]] != 1
                       ) {
                    if (r == hole[0] && c == hole[1]) {
                        break;
                    }
                    r = r + moves[i][0];
                    c = c + moves[i][1];
                    d++;
                }
                if (resoved[r][c] == false) {
                    visiting.offer(new Point(r, c, d, direction + directions[i]));
                }


            }
        }

        return "impossible";
    }

    private boolean outofBoundary(int r, int c, int rows, int cols) {
        return (r < 0 || r >= rows || c < 0 || c >= cols);
    }



}
