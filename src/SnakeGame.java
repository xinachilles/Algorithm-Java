import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by xhu on 4/22/17.
 */
public class SnakeGame {


    int width;
    int height;
    Deque<int[]> snake = new LinkedList<>();


    Queue<int[]> food = new LinkedList<>();
    int current;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake.offer(new int[]{0, 0});
        current = 0;

        for (int[] f : food) {
            this.food.offer(f);
        }
    }


    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] current = snake.getLast();
        int[] newHead = new int[2];

        switch (direction) {
            case "U":
                if (current[0] - 1 < 0) {
                    return -1;
                }
                newHead = new int[]{current[0] - 1, current[1]};
                break;
            case "L":
                if (current[1] - 1 < 0) {
                    return -1;
                }
                newHead = new int[]{current[0], current[1] - 1};
                break;
            case "R":
                if (current[1] + 1 >= width) {
                    return -1;
                }
                newHead = new int[]{current[0], current[1] + 1};
                break;
            case "D":
                if (current[0] + 1 >= height) {
                    return -1;
                }
                newHead = new int[]{current[0] + 1, current[1]};
                break;
        }




        if (food.isEmpty()||(newHead[0] != food.peek()[0] || newHead[1] != food.peek()[1])) {
            snake.removeFirst();
        }

        if (snake.contains(newHead)) {
            return -1;
        } else {
            food.poll();
            snake.offer(newHead);
            return snake.size();
        }


    }


}
