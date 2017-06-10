/**
 * Created by xhu on 10/9/16.
 */
public class ZigZagConversion {
    // zigzag coversion
    public String covert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder[] zigArray = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            zigArray[i] = new StringBuilder();
        }

        char[] data = s.toCharArray();
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && i<index; i++) {
                zigArray[i].append(data[index]);
                index++;
            }

            for (int i = numRows - 2; i >= 0 && i<index; i--) {
                zigArray[i].append(data[index]);
                index++;
            }
        }

        for (int i = 1; i < s.length(); i++) {
            zigArray[0].append(zigArray[i].toString());
        }

        return zigArray[0].toString();
    }
}

