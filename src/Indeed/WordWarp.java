package Indeed;

import java.util.ArrayList;
import java.util.List;

public class WordWarp {
    /*
    * 给一个word list 和最大的长度，要求把这些word用 - 串联起来，但不能超过最大的长度。
    * */

    public List<String> wordWrap(List<String> words, int maxLen) {

            if (words == null || words.size() == 0) {
                return null;
            }
            List<String> result = new ArrayList<>();
            int  start = 0;
            while (start < words.size()) {
                // start with i
                int remain = maxLen;
                int count = 0;

                while (start < words.size()) {
                    if (remain - words.get(start).length() < 0) {
                        break;
                    }
                    count++;
                    remain -= words.get(start++).length() + 1;
                }
                String solution = "";
                for (int j = start - count; j < start; j++) {
                    solution += words.get(j);
                    if (j != start - 1) {
                        solution += "-";
                    }
                    result.add(solution);
                }
            }
            return result;
        }

    private String wordWarpLine(String word, int max){
        return "";
    }
        /*
    We are building a word processor and we would like to implement a "reflow" functionality that also applies full justification to the text.
    Given an array containing lines of text and a new maximum width, re-flow the text to fit the new width. Each line should have the exact specified width. If any line is too short, insert '-' (as stand-ins for spaces) between words as equally as possible until it fits.
            Note: we are using '-' instead of spaces between words to make testing and visual verification of the results easier.
     leetcode 68
     */

    public static void main(String[] args){

    }


}
