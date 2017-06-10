import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/14/16.
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() ==0){
            return  result;
        }

        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                StringBuilder copy = new StringBuilder(s);
                copy.setCharAt(i,'-');
                copy.setCharAt(i-1,'-');
                result.add(copy.toString());

            }
        }

        return result;


    }
}
