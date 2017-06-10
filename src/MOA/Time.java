package MOA;

/**
 * Created by xhu on 6/9/17.
 */
public class Time {
    public boolean FindTime(String time){
        if(time == null || time.length() == 0){
            return true;
        }

        int start = 0;
        int end = time.length()-1;

        while (start<end){
            if(time.charAt(start) == ':'){
                start++;
                continue;
            }

            if(time.charAt(end) == ':'){
                end--;
                continue;
            }

            if(time.charAt(start) != time.charAt(end)){
                return false;
            }

            end--;
            start++;
        }

        return true;
    }
}
