import java.util.Arrays;

/**
 * Created by xhu on 10/23/16.
 */
public class ScrambleString {
    // scramble string
 /*   public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if(s1.length() != s2.length()){
            return false;
        }
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }

        if (isValid(s1, s2) == false) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            String s11 = s1.substring(0, i + 1);
            String s21 = s2.substring(0, i + 1);

            String s12 = s1.substring(i + 1, s1.length());
            String s22 = s2.substring(i + 1, s2.length());

            String s23 = s2.substring(s2.length() - i - 1, s2.length());
            String s24 = s2.substring(0, s2.length() - i - 1);

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }


            if (isScramble(s11, s23) && isScramble(s12, s24)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(String s1, String s2) {
        char[] arry1 = s1.toCharArray();
        char[] arry2 = s2.toCharArray();

        Arrays.sort(arry1);
        Arrays.sort(arry2);

        for (int i = 0; i < arry1.length; i++) {
            if (arry1[i] != arry2[i]) {
                return false;
            }

        }

        return true;
    }*/

    public boolean isScramble(String s1, String s2)
    {
        if (s1 == null || s2 == null)
        {
            return false;
        }

        if (!checkScramble(s1, s2))
        {
            return false;
        }

            int[][][] dp = new int[s1.length()][s2.length()][s1.length()+1];
        // dp[i,j,k] means from ith in s1 and from j th in s2 and both length is k are scramle or not

        return isScrambleHelper(s1, 0, s2, 0, s1.length(), dp);


    }

    private boolean isScrambleHelper(String s1, int start1, String s2, int start2, int length, int[][][] dp)
    {

        if(s1.equals(s2)){
            dp[start1][start2][length] = 1;
            return  true;
        }

        if (dp[start1][start2][length] == 1)
        {
            return true;
        }

        if (dp[start1][start2][length] == -1)
        {
            return false;
        }

        if (checkScramble(s1, s2) == false)
        {
            dp[start1][start2][length] = 0;
            return false;
        }

        for (int i = 1; i < s1.length(); i++)
        {

                    String s11 = s1.substring(0, i);
                    String s12 = s1.substring(i, s1.length());

                    String s21 = s2.substring(0, i);
                    String s22 = s2.substring(i, s2.length());

                    String s23 = s2.substring(s2.length() - i, s2.length());
                    String s24 = s2.substring(0, s2.length() - i);

                    if (isScrambleHelper(s11, start1, s21, start2 , i, dp) && isScrambleHelper(s12, start1 + i, s22, start2 + i, length - i, dp))
                    {
                        dp[start1][start2][length] = 1;
                        return true;
                    }

                    if (isScrambleHelper(s11, start1, s23, start2+length - i, i, dp) && isScrambleHelper(s12, start1+i, s24, start2, length-i, dp))
                    {
                        dp[start1][start2][length] = 1;
                        return true;
                    }


        }

        dp[start1][start2][length] = -1;
        return false;

    }

    private boolean checkScramble(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        for (int i = 0; i < s1.length(); i++)
        {
            if (s1Array[i] != s2Array[i])
            {
                return false;
            }
        }

        return true;
    }
}
