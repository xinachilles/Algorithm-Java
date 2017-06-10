/**
 * Created by xhu on 10/8/16.
 */
public class MultiplyStrings {
    //multiply string

    public String multiply(String num1, String num2) {
        // multiply strings
        if (num1 == null || num2 == null) {
            return null;
        }

        int[] number1 = new int[num1.length()];
        int[] number2 = new int[num2.length()];
        int[] result = new int[num1.length() + num2.length() + 1];

        for (int i = 0; i < number1.length; i++) {
            number1[i] = (int) Character.getNumericValue(num1.charAt(i));
        }

        for (int i = 0; i < number1.length; i++) {
            number2[i] = (int) Character.getNumericValue(num2.charAt(i));
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int j = num2.length() - 1;
            for (; j >= 0; j--) {
                int num = number1[i] * number2[j] + carry + result[i + j];
                carry = num / 10;
                num = num % 10;
                result[i + j] = num;
            }

            result[i] += carry;
        }

        int k = 0;
        while (k < result.length) {
            if (result[k] == 0) {
                k++;
            } else {
                break;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = k; i < result.length; i++) {
            ans.append(result[i]);
        }

        return ans.length() == 0? "0": ans.toString();
    }
}

