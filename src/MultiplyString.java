/**
 * Created by xhu on 10/23/16.
 */
public class MultiplyString {

    /*      if (num1 == null || num2 == null) {
              return null;
          }

          int position = 0;
          int result = 0;
          int num = Integer.valueOf(num1);

          for (Character c : num2.toCharArray()) {

              result = result + (int) Math.pow(10, position) * multipySigialPosition(num, Character.getNumericValue(c));
          }

          return String.valueOf(result);
      }


      private int multipySigialPosition(int a, int b) {
          return a * b;
      }*/
    public String Multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int[] nums = new int[num1.length() + num2.length() + 1];
        int carry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {

            int j = num2.length() - 1;
            for (; j >= 0; j--) {
                int n = Character.getNumericValue(num1.charAt(i)) *
                        Character.getNumericValue(num2.charAt(j)) + carry + nums[i + j];
                carry = n / 10;
                n = n % 10;
                nums[i + j+1] = n;
            }

            if (carry > 0) {
                nums[i + j+1] = carry;
            }
        }

        int k = num1.length() + num2.length() - 1;

        while (k > 0) {
            if (nums[k] == 0 ) {
                k--;
            } else {
                break;
            }

        }

        StringBuilder result = new StringBuilder();
        for (int i = k; i >= 0; i--) {
            result.append(nums[i]);
        }

        return result.toString();
    }
}


