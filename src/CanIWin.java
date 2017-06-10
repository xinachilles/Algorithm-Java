import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 12/11/16.
 */
public class CanIWin {
    // can i win
    public boolean canIWin(int maxChoosableInteger, int desiredTotal)
    {

        List<Integer> tracking = new ArrayList<>();
        return canIWinHelper(maxChoosableInteger, desiredTotal, 1, 0);
    }

    private boolean canIWinHelper(int maxChoosableInteger, int desiredTotal, int start, int amount)
    {
        if (amount >= desiredTotal)
        {
            return true;
        }

        for (int i = start; i <=maxChoosableInteger; i++)
        {

            if (canIWinHelper(maxChoosableInteger, desiredTotal, i+1,amount + i)){
                    return false;
                 }

        }

        return false;
    }
}
