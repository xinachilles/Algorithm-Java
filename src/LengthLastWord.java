/**
 * Created by xhu on 11/20/16.
 */

public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }


        String[] arr = s.trim().split(" ");

        if (arr.length == 0) {
            return s.length();
        }

        int i = arr.length - 1;
        for (; i >= 0; i--) {
            if (arr[i].length() != 0) {
                break;
            }
        }

        if(i<0){
            return 0;
        }else {
            return arr[i].length();
        }
    }
}
