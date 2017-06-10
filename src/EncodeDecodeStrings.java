import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 4/1/17.
 */
public class EncodeDecodeStrings {

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int begin = 0;


        while (begin < s.length()) {
            int length = 0;
            while(begin<s.length() && Character.isDigit(s.charAt(begin))){
                length  = length*10+ Integer.valueOf(s.charAt(begin));
                begin++;
            }

            if(begin+length>s.length()){
                break;
            }

            String substirng = s.substring(begin, begin+length);
            begin = begin +length;

            result.add(substirng);
        }

        return result;
    }
}
