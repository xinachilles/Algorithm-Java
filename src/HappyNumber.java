import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/**
 * Created by xhu on 10/23/16.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>();
        nums.add(n);
        while(true){
            n = calDigital(n);
            if(n == 1){
                return true;
            }

            if(nums.contains(n)){
                return false;
            }else{
                nums.add(n);
            }
        }
    }

    private int calDigital(int n){
        int result = 0;
        while(n>0){
            int a = n /10;
            result = result + a*a;
            n = n%10;
        }

        return result;
    }



}
