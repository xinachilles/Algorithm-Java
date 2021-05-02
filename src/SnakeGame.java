import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by xhu on 4/22/17.
 */
public class SnakeGame {


    int width;
    int height;
    int indexOfFood;
    int[][] food;
    int score;
    Deque<Integer> snake = new LinkedList<>();
    Set<Integer> set = new HashSet<>();


    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake.offer(0);
        set.add(0);
        indexOfFood = 0;
        score = 0;

    }


    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        if (score < 0) {
            return score;
        }
        //
        int row = snake.getFirst() / width;
        int col = snake.getFirst() % width;

        switch (direction) {
            case "U":
                row--;
                break;
            case "L":
                col--;
                break;
            case "R":
                col++;
                break;
            case "D":
                row++;
                break;
        }
        // remove the tail from set
        set.remove(snake.getLast());

        if (row < 0 || row > height || col < 0 || col > width || set.contains(snake.getFirst())) {
            return -1;
        }
        int head = row * width + col;
        snake.addFirst(head);
        set.add(head);

        // eat the food
        if (indexOfFood < food.length && row == food[indexOfFood][0] && col == food[indexOfFood][1]) {
            score++;
            set.add(snake.getLast());// add the tail back
            return score;
        }

        // remove the tail
        snake.removeLast();
        return score;

    }


}
