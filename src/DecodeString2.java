/**
 * Created by xhu on 3/7/17.
 */
public class DecodeString2 {

    // decode string
    int index = 0;

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }


        String result = "";

        for (; index < s.length() && s.charAt(index) != ']'; index++) {
            if (s.charAt(index) == '[') {
                continue;
            } else if (!Character.isDigit(s.charAt(index))) {
                result = result + s.charAt(index);
            } else {

                int times = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    times = times * 10 + Character.getNumericValue(s.charAt(index));
                    index++;
                }
                index++;// for [
                String sigal = decodeString(s);
                index++; //for ]

                String part = " ";
                for (int j = 0; j < times; j++) {
                    part += sigal;
                }

                result = result + part;

            }
        }

        return result;


    }
}
