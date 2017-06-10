import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 1/1/17.
 */
public class StrobogrammaticNumber {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        StrobogrammaticDFS(n, 0, "", result);
        return result;

    }

    private void StrobogrammaticDFS(int n, int index, String s, List<String> result) {
        if (index == n) {
            if (isStrobogrammatic(s)) {
                result.add(s);
            }
            return;
        }

        for (char i = '0'; i <= '9'; i++) {
            if(index>0 && s.charAt(0) =='0'){
                return;
            }
            StrobogrammaticDFS(n, index + 1, s.length() == 0 ? String.valueOf(i) : s + i, result);
        }
    }


    private boolean isStrobogrammatic(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '0':
                    result.append('0');
                    break;
                case '6':
                    result.append('9');
                    break;
                case '1':
                    result.append('1');
                    break;
                case '8':
                    result.append('8');
                    break;
                case '9':
                    result.append('6');
                    break;


            }
        }
            return result.reverse().toString().equals(s);

    }

}
