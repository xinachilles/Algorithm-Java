import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {

    @Test
    public void islandPerimeter() {
        IslandPerimeter test = new IslandPerimeter();
        test.islandPerimeter(new int[][]{{0,1,0,0},
                {1,1,1,0},{0,1,0,0},{1,1,0,0}});
    }
}