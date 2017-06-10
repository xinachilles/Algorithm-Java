import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhu on 10/21/16.
 */
public class ValidWordAbbreviation {
    // valid word abbreviation

    public boolean validWordAbbreviation(String word, String abbr){
        if(word == null || abbr == null){
            return false;
        }

        int number = 0;
        int index = 0;

        for(char c :abbr.toCharArray()){
            if(Character.isDigit(c)){
               number= number*10+Character.getNumericValue(c);

            }else{
                index = index+number;
                if(index>=word.length() || c != word.charAt(index)){
                    return false;
                }
                index++;
                number =0;
            }

        }
        return index == word.length();


    }

}
