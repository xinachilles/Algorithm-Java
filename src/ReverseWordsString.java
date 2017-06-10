import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/23/16.
 */
public class ReverseWordsString {
    // reverse words in

    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        String[] array = s.split(" ");
        StringBuilder result =new StringBuilder();

        for(int i =0; i<array.length; i++){
            result.append(new StringBuilder(array[i]).reverse());
            if(i!= array.length-1){
                result.append(" ");
            }
        }


        return result.toString();

    }
}





