/**
 * Created by xhu on 4/28/17.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0){
            return s;
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while(i<=s.length())
        {
            result.append( new StringBuilder(s.substring(i,i+k)).reverse());
            i = i+k;
        }

        return result.toString();

    }
}
