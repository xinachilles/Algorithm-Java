import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 11/5/16.
 */
public class CountNumberUniqueDigits {
    //count numbers with unique digits
    int count = 0;

    public int countNumberwithUniqueDigits(int n) {

        countNumberwithUniqueDigitsHelper(n, "", 0);
        return count;
    }


    private void countNumberwithUniqueDigitsHelper(int n, String number, int index) {

        if (number.length() > n) {
            return;
        }


        if (index == 0 || number.charAt(0) != '0') {
            count++;
        }


        for (char i = '0'; i <= '9'; i++) {
            if (number.indexOf(i) >= 0) {
                continue;
            }
            countNumberwithUniqueDigitsHelper(n, number.length() == 0 ? String.valueOf(i) : String.valueOf(i) + number, index + 1);


        }
    }

}
