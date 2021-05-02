import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/23/16.
 */
public class DecodeString {
    int index = 0;
    public String decodeString(String s) {
        if(s == null || s.length() ==0){
            return "";
        }
        int number = 1;
        String result = "";
        while(index<s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                number = number *10 + (int)(c-'0');
            }else if(c == '['){

                String temp = decodeString(s.substring(index+1));
                for(int i = 0; i<number;i++){
                    result = result+temp;
                }
            }else if(c == ']'){
                return result;
            }
            index++;
        }
        return result;

    }
}
