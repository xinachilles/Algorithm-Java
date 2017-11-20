/**
 * Created by xhu on 7/4/17.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }


        int isNegative = 1;

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isNegative = -1;
        }


        long lgdividend = Math.abs((long) dividend);
        long lgdivisor = Math.abs((long) divisor);

        int result = 0;
        if (lgdividend < lgdivisor) return 0;

        while (lgdividend >= lgdivisor) {
            int shift = 0;
            while (lgdividend >= lgdivisor << shift + 1) {
                shift++;
            }

            lgdivisor = lgdivisor << shift;
            result += 1 << shift;

            lgdividend -= lgdivisor;


        }

        return isNegative * result;


    }
}
