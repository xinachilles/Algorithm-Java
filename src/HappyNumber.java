import java.util.HashSet;

/**
 * Created by xhu on 10/23/16.
 */
public class HappyNumber {
    // happy number
    public Boolean isHappy(int n) {
        HashSet<Integer> index = new HashSet<Integer>();

        index.add(n);
        while (true) {
            int happy = CalHappyNumber(n);
            if (happy == 1) {
                return true;
            }

            if (index.contains(happy)) {
                return false;
            }

            index.add(happy);
            n = happy;
        }
    }

    private int CalHappyNumber(int n) {

        int result = 0;
        while (n > 0) {
            int a = n % 10;
            result = result + a * a;
            n = n / 10;

        }

        return result;
    }

}
