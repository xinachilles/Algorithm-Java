import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/22/17.
 */
public class SnakeGameTest {
    @Test
    public void move() throws Exception {
        SnakeGame snakeGame = new SnakeGame(3,2,new int[][]{new int[]{1,2},new int []{0,1}} );
        snakeGame.move("R");
        snakeGame.move("D");
        snakeGame.move("R");
        snakeGame.move("U");
        snakeGame.move("L");


    }

}