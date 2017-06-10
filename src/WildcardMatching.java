/**
 * Created by xhu on 2/19/17.
 */
public class WildcardMatching {

/*    public boolean isMatch(String s, String p) {
        if(s==null	 || p ==null){
            return false;
        }

        return isMatchHelper(s,p);
    }

    private boolean isMatchHelper(String s, String p){
        if(s.length() == 0){
            return p.length() ==0;
        }

        if(p.charAt(0) != '*'){
            if(s.length()>0 && ( p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))){
                return isMatchHelper(s.substring(1),p.substring(1));
            }
        }else{
            for(int i = 0;i<s.length();i++){
                if(isMatchHelper(s.substring(i),p.substring(1))){
                    return true;
                }
            }
        }

        return false;
    }*/


   /* public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        // dp[i][j] is true means for 0 to i-1 of p is match 0 to j-1 of s

        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[i][0] = true;
            }
        }

        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (p.charAt(i) != '*') {
                    dp[i + 1][j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && dp[i][j];
                } else {
                    boolean isMatch = false;
                    for (int k = 0; k <= j; k++) {
                        if (dp[i][k]) {
                            isMatch = true;
                            break;
                        }
                    }
                    dp[i + 1][j + 1] = isMatch;
                }

            }
        }

        return dp[p.length() + 1][s.length() + 1];

    }*/

    // wildcard matching
    public boolean isMatch(String s, String p) {
        return false;
    }


}
