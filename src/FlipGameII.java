import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/10/16.
 */
public class FlipGameII {
    List<String> collections = new ArrayList<>();

    public Boolean canWin(String s) {
       if(s == null || s.length() == 0){
           return false;
       }

       return canWinHelper(new StringBuilder(s));
    }

    private boolean canWinHelper(StringBuilder s){
        boolean canWind = false;
        for(int i =1;i<s.length();i++){
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+'){
                s.setCharAt(i-1,'-');
                s.setCharAt(i,'-');

                if(!canWinHelper(s)){
                    return true;
                }

                s.setCharAt(i-1,'+');
                s.setCharAt(i,'+');



            }
        }

        return false;
    }




}
