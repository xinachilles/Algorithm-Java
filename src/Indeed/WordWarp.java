package Indeed;

import java.util.ArrayList;
import java.util.List;

public class WordWarp {
    /*
    *Pt.1 Connecting words with '-' as blank spaces, no exceeds maxLength
    *   e.g. ["1p3acres", "is", "a", "good", "place", "to", "communicate"], 12
    * => {"1p3acres-is", "a-good-place", "for", "communicate"}

     * */
/*
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

 */
    public static List<String> wrapLines(String[] words, int maxLength){
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start<words.length){
            if(sb.length() == 0){
                // assume all words length no exceed to maxLength
                sb.append(words[start++]);
            }else if(sb.length()+1+words[start].length()<=maxLength){
                sb.append("-");
                sb.append(words[start++]);
            }else{
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length()!=0) {
            result.add(sb.toString());
        }
        return result;

    }

        /*
    We are building a word processor and we would like to implement a "reflow" functionality that also applies full justification to the text.
    Given an array containing lines of text and a new maximum width, re-flow the text to fit the new width. Each line should have the exact specified width. If any line is too short, insert '-' (as stand-ins for spaces) between words as equally as possible until it fits.
            Note: we are using '-' instead of spaces between words to make testing and visual verification of the results easier.
     leetcode 68
     */

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int j = 0;
        List<String> result = new ArrayList<>();

        while(j<words.length){

            int i = j;
            int lineLength = words[i].length();//how many word characters (doesn't include space) we can fit inside of this line
            int spaceNeeded = 0;//how many times (group of space) we need to apply a group of spaces inside of this line
            j++;
            while( j<words.length && lineLength+words[j].length()+spaceNeeded <maxWidth)
            {
                spaceNeeded++;
                lineLength+=words[j].length();
                j++;

            }

            int diff = maxWidth-lineLength;// total space needed for current line
            int numberOfwords = j-i;
            if(numberOfwords == 1 || j >=words.length){
               // result.add(leftJustify(words,i,j,diff));
                result.add(words[i]);
            }else{
                result.add(middleJustify(words,i,j,diff));
            }

        }
        return  result;
    }

    private static String middleJustify(String[]words, int start, int end, int diff){
        int spaceNeeded = end-start-1;// how many group of space -- session needed (in between each word)
        int space = diff/spaceNeeded; // how many space needed for each seesction
        int extraSpace = diff%spaceNeeded;
        StringBuilder line  = new StringBuilder(words[start]);
        for(int k = start+1; k<end;k++){
            if(spaceNeeded>0) {
                for (int s = 0; s < space; s++) {
                    line.append("-");

                }
                spaceNeeded--;
            }
            if(extraSpace>0){
                line.append("-");
                extraSpace--;
            }

            line.append(words[k]);
        }

        return line.toString();
    }
    private static String leftJustify(String[]words,int start,int end,int diff) {

        int space = 0;
        StringBuilder result = new StringBuilder(words[start]);
        for (int i = start + 1; i < end; i++) {
            result.append("-");
            result.append(words[i]);
            space++;
        }
        // apply the rest of space to the right
        for (int i = 0; i < diff - space; i++) {
            result.append("-");
        }

        return result.toString();
    }


    public static void main(String[] args){
       /*
        String[] lines = { "The", "day", "began", "as","still","as", "the",
                "night", "abruptly", "lighted","with",
                "brilliant", "flame" };
        */

        List<String> result2 = wrapLines(new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"},12);
        for(String r:result2){
            System.out.print(r);
            System.out.println("");
        }


        String[] lines = { "The day began as still as the",
                "night abruptly lighted with",
                "brilliant flame"};
        List<String> new_lines = new ArrayList<>();
        for(String line : lines){
            for(String word : line.split(" ")){
                new_lines.add(word);
            }
        }

       List<String> result = fullJustify(new_lines.toArray(new String[0]),24);
       for(String r: result){
           System.out.println(r);
       }

    }


}
