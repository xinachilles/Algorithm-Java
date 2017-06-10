import sun.util.resources.hr.CalendarData_hr;

/**
 * Created by xhu on 10/8/16.
 */
public class DecodeWays {


   /* public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        numDecodingHelper(s, 0);
        return count;
    }

    private void numDecodingHelper(String s, int index) {
        if (index > s.length()) {
            count++;
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (index + i <= s.length()) {
                int number = Integer.valueOf(s.substring(index, index + i));
                if (number >= 1 && number <= 26) {
                    numDecodingHelper(s, index + i);
                }
            }
        }

    }*/

    // decode ways

    //dymatic
   /* public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] ways = new int[s.length() + 1];

        // ways[i] is number of decode way for s[0..i-1];
        //ways[i] = if( s.substring(i-2,i) is valid) ways[i-1]+ways[i-2]; other ways = ways[i-1]

        ways[0] = 1;

        ways[1] = Character.getNumericValue(s.charAt(1)) == 0 ? 0 : 1;

        for (int i = 2; i<s.length(); i++) {
            int substring2 = Integer.valueOf(s.substring(i-2, i));
            int subString1 = Character.getNumericValue(s.charAt(i-1));

            if (substring2 >= 1 && substring2 <= 26) {
                ways[i] = ways[i-1] + ways[i - 2];
            } else if(subString1 !=0 ) {
                ways[i] = ways[i - 1];
            }
        }

        return ways[s.length()];
    }*/


    int count;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        numDecodingHelper(s, 0);
        return count;
    }

    private void numDecodingHelper(String s, int index) {
        if (index == s.length()) {
            count++;
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            int number = Integer.valueOf(s.substring(index, i + 1));
            if (number >= 1 && number <= 26) {
                numDecodingHelper(s, i + 1);
            } else {
                break;
            }
        }
    }
}
