import java.util.HashSet;
import java.util.Set;

/**
 * Created by xhu on 12/17/16.
 */
public class UniqueSubstringsWraparoundString {

    // unique substring in wraparound string
    // how to solve this problme by dp?
    public int findSubstringInWraproundString(String p)
    {
        if( p == null || p.length() == 0){
            return 0;
        }
        int[] dp = new int[26];
        //dp[i] means the number of substring present in s which edn with c
        int count = 1;
        dp[p.charAt(0)-'a'] = 1;

        for(int i = 1;i<p.length();i++){
            if(p.charAt(i-1) ==(char) p.charAt(i)-1 || (char)( p.charAt(i-1)-25) == p.charAt(i) ){
                count++;
            }else{
                count = 1;
            }

            dp[p.charAt(i)-'a'] = Math.max(dp[p.charAt(i)-'a'],count);
        }

        int sum = 0;

        for(int i = 0;i<dp.length;i++){
            sum = sum+dp[i];
        }

        return sum;
    }


    // just need a for loop
    //private void findSubstringInWraproundStringHelper(string p, int index, HashSet<String> sets)
    //{

    //    for(int i = index; i<=p.Length; i++){
    //        string substring = p.Substring(index, i - index + 1);
    //        if (!sets.Contains(substring) && isValidSubsets(substring))
    //        {
    //            sets.Add(substring);
    //            findSubstringInWraproundStringHelper(p, i + 1, sets);
    //        }


    //    }
    //}

    //private bool isValidSubsets(String p)
    //{
    //    if (p == null || p.Length == 0)
    //    {
    //        return false;
    //    }

    //    int start = p[0] - 'a' + 1;

    //    for (int i = 1; i < p.Length; i++)
    //    {
    //        if (start > 'z')
    //        {
    //            start = 'a';
    //        }

    //        if ((char)start != p[i])
    //        {
    //            return false;
    //        }

    //        start = start + 1;
    //    }

    //    return true;
    //}


    private boolean isValidSubsets(String p)
    {
        if (p == null || p.length() == 0)
        {
            return false;
        }

        int start = p.charAt(0)  + 1;

        for (int i = 1; i < p.length(); i++)
        {
            if (start > 'z')
            {
                start = 'a';
            }

            if ((char)start != p.charAt(i))
            {
                return false;
            }

            start = start + 1;
        }

        return true;
    }

}
