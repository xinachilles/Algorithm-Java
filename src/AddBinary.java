/**
 * Created by xhu on 10/16/16.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;

        StringBuilder result = new StringBuilder();
        while (i >=0 || j >=0) {
            int sum = 0;
            if (i <0) {
                sum = Character.getNumericValue(b.charAt(j)) + carry;
                j--;
            } else if (j <0) {
                sum = Character.getNumericValue(a.charAt(i)) + carry;
                i--;
            } else {
                sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + carry;
                i--;
                j--;
            }

            carry = sum / 2;
            sum = sum % 2;

             result.insert (0,String.valueOf(sum));

        }

        if(carry>0){
            result.insert(0, String.valueOf(carry));
        }

        return result.toString();
    }
}
