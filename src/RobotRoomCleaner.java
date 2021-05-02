import java.util.HashSet;

public class RobotRoomCleaner {
    class Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move() {
            return true;
        }

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft() {
        }

        ;

        void turnRight() {
        }

        ;

        // Clean the current cell.
        void clean() {
        }

        ;
    }


    public void cleanRoom(Robot robot) {

        HashSet<String> visited = new HashSet<>();
        DFS(robot, 0, 0, visited, 0);

    }
    private void DFS(Robot robot, int row, int col, HashSet<String> visited, int direction) {

        String path = String.valueOf(row) + "->" + String.valueOf(col);
        if(visited.contains(path)) return;
        robot.clean();
        visited.add(path);

        for(int k=0;k<4;k++) {
          if(robot.move()){
            switch (direction) {
                case 0:// up
                    row--;
                    break;
                case 90: //right
                    col++;
                    break;
                case 180: // down
                    row++;
                    break;
                case 270:
                    col--;
                    break;
                default:
                    break;
            }
                DFS(robot, row, col, visited, direction);
                BackTrack(robot);
            }
            // turn to next direction
            robot.turnRight();
            direction += 90;
            direction %= 360;
        }
    }
    private void BackTrack(Robot robot) {
        // go back to the starting position
        robot.turnRight(); // turnLeft
        robot.turnRight(); // turnLeft
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
