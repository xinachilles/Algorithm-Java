public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0){
            return false;
        }

        //return helper(num,0,0,0,0);
        return false;
    }

    private boolean helper(String num, int index, Double previous1,Double previous2,int number) {

        // i the first number length, num1 is from [0 to i)
        for (int i = 1; i <= num.length() / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                return false;
            }
            long num1 = Long.parseLong(num.substring(0, i));
            // j is second string length
            for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) {
                if (j > 1 && num.charAt(i) == '0') {
                    break;
                }
                long num2 = Long.parseLong(num.substring(i, i + j + 1));
                // if(num.length()-1-i+j+1+1)
                // long num3 = Long.parseLong(num.substring(i+j+1,num.length()));
            }

        }
        return false;
    }

}
