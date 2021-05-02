/**
 * Created by xhu on 10/8/16.
 */
public class CountandSay {
    // count and say
    public String countAndSay(int n) {
        if(n<=0) return "";

        String result = "1";

        for(int i = 2;i<=n;i++){
            String temp = "";
            char current = result.charAt(0);
            int count = 1;
            for(int j = 1; j<result.length(); j++){
                if(result.charAt(i) != current){
                    temp= temp+ String.valueOf(count)+current;
                    current = result.charAt(i);
                    count = 1;

                }else{
                    count ++;
                }
            }

            temp= temp+String.valueOf(count)+current;
            result = temp;
        }

        return result;


    }
}
