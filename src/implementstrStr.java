/**
 * Created by xhu on 10/16/16.
 */
public class implementstrStr {
    public int strStr(String haystack, String needle){
        if(needle == null || haystack == null){
            return 0;
        }

        if(needle.length() == 0 && haystack.length()==0){
            return 0;
        }

        if(haystack.length()==0){
            return -1;
        }

        if(needle.length()==0){
            return 0;
        }

        int length = haystack.length();

        for(int i = 0; i+length <needle.length(); i++){
            if(needle.substring(i,i+length).equals(haystack)){
                return i;
            }
        }

        return -1;
    }

}
