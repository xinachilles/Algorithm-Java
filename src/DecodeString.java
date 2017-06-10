import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/23/16.
 */
public class DecodeString {

    public String Encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String s : strs) {
            result.append(s.length());
            result.append("/");
            result.append(s);

        }

        return result.toString();
    }

    public List<String> Decode(String s) {
        List<String> result = new ArrayList<>();
        int begin = 0;
        int end = 0;

        while (begin < s.length()) {
            end = s.indexOf('/', begin);
            int length = Integer.valueOf((s.substring(begin, end)));
            String substirng = s.substring(end + 1, end + 1 + length);
            begin = end + 1 + length;

            result.add(substirng);
        }

        return result;

    }
}
