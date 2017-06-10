/**
 * Created by xhu on 10/6/16.
 */
public class DistinctSubsequences {

    /* int count = 0;
     public int numDistinct(String s, String t) {
         if(s == null || s.length() ==0){
             return 0;
         }

         numDistinctHelper(s,t,0,"");
         return count;
     }

     private void  numDistinctHelper(String s, String t, int index,String solution){
         if(solution.equals(t)){
             count++;
             return;
         }

         if(index == s.length()){
             return;
         }

         for(int i = index; i<s.length(); i++){
              solution = solution+s.charAt(i);
              if(solution.length()>t.length()){
                  return;
              }
              if(t.substring(0,t.length()).equals(solution)){
                  numDistinctHelper(s,t,index+1,solution);
              }
              solution  = solution.substring(0,solution.length()-1);
         }
     }
 */
    // distinct subsequences
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int[][] dy = new int[s.length() + 1][t.length() + 1];
        dy[0][0] = 1;

        for (int i = 0; i < s.length(); i++) {
            dy[i + 1][0] = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    dy[i + 1][j + 1] = dy[i][j+1];
                } else {
                    dy[i + 1][j + 1] = dy[i][j] + dy[i][j+1];
                }
            }
        }

        return dy[s.length()][t.length()];
    }
}


