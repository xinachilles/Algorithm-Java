/**
 * Created by xhu on 12/17/16.
 */
public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0 || rows == 0 || cols == 0) {
            return 0;
        }

        int times = 1;
        int index = 1;
        int beginCols = sentence[0].length() + 1;
        int beginRows = 1;

        while (index < sentence.length && beginRows <= rows) {

            int current = sentence[index].length();
            // for cols
            if (current + beginCols <= cols) {
                beginCols = beginCols + current + 1;
            } else {
                beginRows++;
                beginCols = current + 1;
            }


            index++;
            if (index == sentence.length) {
                index = 0;
                times++;
            }


        }
        return index < sentence.length ? times - 1 : times;


    }
}
