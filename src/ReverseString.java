/**
 * Created by xhu on 10/23/16.
 */
public class ReverseString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            Character temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

        }

        return new String(arr);
    }


}


