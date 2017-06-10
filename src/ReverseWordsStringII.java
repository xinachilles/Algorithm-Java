/**
 * Created by xhu on 11/26/16.
 */
public class ReverseWordsStringII {
    //reverse words in a string ii
    public void reverseWords(char[] s) {

        for (int i = 0; i < s.length - 1; i++) {
            int j = i + 1;
            for (; j < s.length; j++) {
                if (s[j] == ' ') {
                    reverseWord(s, i, j - 1);

                }

            }

        }

        reverseWord(s, 0, s.length - 1);
    }

    private void reverseWord(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

}
