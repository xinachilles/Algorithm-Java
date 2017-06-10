/**
 * Created by xhu on 3/13/17.
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }

        int[][] length = new int[s.length()][s.length()];

        for(int i = 0; i<s.length();i++){
            length[i][i]  = 1;
        }

        for(int i = s.length()-1;i>0;i--){
            for(int j = i+1; j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j ==i+1){
                        length[i][j] = 2;
                    }else{
                        length[i][j] = length[i+1][j-1]+2;
                    }
                }else{
                    length[i][j] = Math.max(length[i+1][j],length[i][j-1]);
                }
            }
        }

        return length[0][s.length()-1];
    }
}
