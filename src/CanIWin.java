import java.util.*;

/**
 * Created by xhu on 12/11/16.
 */
public class CanIWin {
    // can i win
    public boolean canIWin(int maxChoosableInteger, int desiredTotal)
    {
        // total sum from 1 to max
        int sum = (1+maxChoosableInteger)*(maxChoosableInteger)/2;
        if(sum<desiredTotal){
            return false;
        }
        // state[i] = 1 means number i has been choose

        int[] state = new int[maxChoosableInteger+1];
        // transfer the state to a string, if player 1 can win with the current state(key)
        Map<String,Boolean> map = new HashMap<>();
        List<Integer> tracking = new ArrayList<>();
        return canIWinHelper(desiredTotal, state,map);
    }

    private boolean canIWinHelper(int desiredTotal, int[]state, Map<String, Boolean> map)
    {

        String key = Arrays.toString(state);
        if(map.containsKey(key)){
            return map.get(key);
        }

        for (int i = 1; i <state.length; i++)
        {
            if(state[i] == 0){
                state[i] = 1;
                // I win or another player can not win
                if(desiredTotal -i<=0 || !canIWinHelper(desiredTotal,state,map)){
                    map.put(key,true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
                map.put(key,false);
            }


        }

        return false;
    }
}
