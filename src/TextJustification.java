import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xhu on 10/15/16.
 */
public class TextJustification {
    /*public List<String> fullJustify(String[] words, int maxWidth) {
        //text justinfication
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return null;

        }

        int count = 0;

        while (count <= words.length - 1) {
            count = Justify(words, count, maxWidth, result);

        }

        return result;
    }


    private int Justify(String[] words, int count, int maxWidth, List<String> result) {

        int i = count;
        StringBuilder solution = new StringBuilder();
        for (; i < words.length; i++) {

            solution.append(words[i]).append(" ");
            if (solution.length() > maxWidth + 1) {
                break;
            }
        }

        if (i == words.length - 1) {
            // remove the last space
            solution.deleteCharAt(solution.length() - 1);
            result.add(solution.toString());
            return words.length;
        }

        // remove the last word and space
        solution.deleteCharAt(solution.length() - 1);
        solution.deleteCharAt(solution.indexOf(words[i]));

        int totalLengthOfSapce = maxWidth - solution.length();
        int numOfWords = i - count - 1;

        // last word don`t need space
        int lengthOfSapce = totalLengthOfSapce / (numOfWords - 1);
        int lengthOfSpaceLastLeft = lengthOfSapce % (numOfWords - 1);
        int currentIndex = 0;
        if (lengthOfSapce > 0) {
            for (int j = 0; j < numOfWords - 1; j++) {
                for (int k = 1; k <= lengthOfSapce; k++) {
                    solution.insert(currentIndex, " ");
                    currentIndex++;
                }
                currentIndex = currentIndex + words[j].length();

            }
        }

        if (lengthOfSpaceLastLeft > 0) {
            currentIndex = currentIndex - lengthOfSapce - words[count + numOfWords - 2].length();

            for (int k = 1; k < lengthOfSpaceLastLeft; k++) {
                solution.insert(currentIndex, " ");
                currentIndex++;
            }
        }
        result.add(solution.toString());
        return count + numOfWords;
    }*/

    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new LinkedList<String>();

        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= L; w++) {
                len += words[w].length() + 1;
            }

            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) { // not 1 char, not last line
                space = (L - len) / (w - i - 1) + 1;
                extra = (L - len) % (w - i - 1);
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) strBuilder.append(' ');
                if (extra-- > 0) strBuilder.append(' ');
                strBuilder.append(words[j]);
            }
            int strLen = L - strBuilder.length();
            while (strLen-- > 0) strBuilder.append(' ');
            list.add(strBuilder.toString());
        }

        return list;
    }
}

