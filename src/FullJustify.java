import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/22/16.
 */
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth)
    {
        if (words.length == 0 || words == null)
        {
            return null;
        }

        List<String> result = new ArrayList<>();
        for (int i = 0,w; i < words.length; i=w)
        {

            // w-i is the number of word fit into the line
            int length = -1;

            for (w = i; w < words.length && length + words[w].length() + 1 <= maxWidth; w++)
            {
                length = length + words[w].length() + 1;
            }

            int lengthOfSpace = 1;
            int numerOfWords = w - i-1; // last word don`t need sapce
            int restOfSpace = 0;

            // if this line need more than two words or it is not last word
            if (w != i + 1 && w != words.length ) {
                lengthOfSpace = (maxWidth - length) / numerOfWords + 1;
                restOfSpace = (maxWidth - length) % numerOfWords;
            }

            StringBuilder lines = new StringBuilder(words[i]);

            for (int j = i+1; j < w; j++)
                {

                    for (int s = 0; s < lengthOfSpace; s++)
                    {
                        lines.append(" ");
                    }

                    if (restOfSpace > 0)
                    {
                        lines.append(" ");
                        restOfSpace--;
                    }

                    lines.append(words[j]);
                }


            int reminder = maxWidth - lines.length();
            if (reminder > 0)
            {

                for (int s = 0; s < reminder; s++)
                {
                    lines.append(" ");
                }


            }

            result.add(lines.toString());


        }

        return result;
    }
}
