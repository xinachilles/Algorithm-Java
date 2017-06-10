/**
 * Created by xhu on 10/8/16.
 */
public class CountandSay {
    // count and say
    public String countAndSay(int n) {

        StringBuilder s = new StringBuilder("1");
        for (int i = 1; i <= n; i++) {
            int count = 1;
            StringBuilder ans = new StringBuilder();
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    ans.append(String.valueOf(count)).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            ans.append(String.valueOf(count)).append(s.charAt(s.length() - 1));
            s = ans;
        }

        return s.toString();

    }
}
