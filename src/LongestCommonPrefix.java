/**
 * Created by xhu on 10/16/16.
 */
public class LongestCommonPrefix {


    // longest common prefix
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        StringBuilder prefix = new StringBuilder();
        for(int i =0;i<strs[0].length(); i++){
            Character p = strs[0].charAt(i);
            for(int j =1; j<strs.length; j++){
                if(p != strs[j].charAt(i)){
                    return prefix.toString();
                }
            }
            prefix.append(p);
        }

        return prefix.toString();
    }
}
