import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfusingNumberII {
    int count = 0;
    int limit = 0;
    int[] numbers = new int[] {0,1,6,8,9};
    Map<Integer,Integer> maps = new HashMap<>();
    public int confusingNumberII(int N) {
        limit = N;

        maps.put(8,8);
        maps.put(0,0);
        maps.put(6,9);
        maps.put(9,6);
        maps.put(1,1);
        helper(0,0,1);
        return count;
    }

    private void helper(int current, int rotateNum, int base){
        if(current>limit){
            return;
        }

        if(current != rotateNum){
            count++;
        }

        for(int n: numbers){
            if(n == 0 && current == 0){
                continue;
            }
            helper(current*10+n,maps.get(n)*base+rotateNum,base*10);
        }
    }
}
