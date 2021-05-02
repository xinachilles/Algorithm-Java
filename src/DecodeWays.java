import sun.util.resources.hr.CalendarData_hr;

/**
 * Created by xhu on 10/8/16.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[1] = (s.charAt(0) =='0'? 0:1);
        for(int i =1; i<s.length();i++){
            if(s.charAt(i) != '0'){
                dp[i+1]+=dp[i];
            }
            int number =  Integer.parseInt(s.substring(i-1,i+1));
            if(number >=10 && number<=26 ){
                dp[i+1] += dp[i-1];
            }
        }

        return dp[s.length()+1];
    }

}
