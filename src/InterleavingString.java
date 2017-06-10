/**
 * Created by xhu on 10/15/16.
 */
public class InterleavingString {


    // interleaving String
// brute force
    /*public boolean isInterleave(String s1, String s2, String s3){
        if(s1==null || s2 == null || s3 ==null){
            return false;
        }

        if(s1.length()+s2.length() != s3.length()){
            return  false;
        }

        boolean[] count = new boolean[s3.length()];
        int indexOfS1 = 0;
        int indexOfS2 = 0;
        for(int i = 0; i<s3.length() && indexOfS1 <s1.length();i++){

            if(s1.charAt(indexOfS1) == s3.charAt(i)){
                count[i] = true;
                indexOfS1++;
            }
        }

        StringBuilder s3Copy = new StringBuilder();
        for(int i =0; i<s3.length();i++){
            if(!count[i]){
                s3Copy.append(s3.charAt(i));
            }
        }

        return s3Copy.toString().equals(s2);



    }*/
    // interleaving string

    public boolean isInterleave(String s1, String s2, String s3)
    {
        if (s1 == null || s2 == null || s3 == null)
        {
            return false;
        }

        if (s1.length() + s2.length() != s3.length())
        {
            return false;
        }

        int n = s3.length();

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //dp[i,j] maenas from 0 to i in s1 and from 0 to j in s2 can form s3 length i+j
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) == s3.charAt(i))
            {
                dp[i + 1][0] = true;
            }
            else
            {
                break;
            }
        }

        for (int i = 0; i < s2.length(); i++)
        {
            if (s2.charAt(i) == s3.charAt(i))
            {
                dp[0][i + 1] = true;
            }
            else
            {
                break;
            }
        }

        for (int i = 0; i < s1.length(); i++)
        {

            for (int j = 0; j < s2.length(); j++)
            {
                if ((dp[i][j + 1] && s1.charAt(i) == s3.charAt(j + i + 2) || (dp[i + 1][j] && s2.charAt(j) == s3.charAt(j + i + 2))))
                {
                    dp[i + 1][j + 1] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
