import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){

            while(!stack.isEmpty() && asteroid >0 && stack.peek()<0){
                int collision = stack.pop();
                if(Math.abs(asteroid)<Math.abs(collision)){
                    asteroid = collision;
                }else if(Math.abs(asteroid)==Math.abs(collision)){
                   asteroid = 0;
                }
            }
            if(asteroid != 0) stack.push(asteroid);

        }

        int[] result = new int[stack.size()];
        for(int i = result.length-1; i>=0; i--){
            result[i] = stack.pop();
        }

       return result;

    }
}
