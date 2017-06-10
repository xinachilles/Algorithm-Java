import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/9/16.
 */
public class GeneralizedAbbreviation {
    //Generalized Abbreviation

    public List<String> generateAbbreviations(String word)
    {
        List<String> result = new ArrayList<>();
        if (word == null || word.length() == 0)
        {
            return result;
        }

        generateAbbreviationsHelper(word, result, 0,"", 0);
        return result;
    }

    private void generateAbbreviationsHelper(String word, List<String> result, int index, String cur, int count) {
        if (index == word.length())
        {
            if(count>0) {
                cur = cur + String.valueOf(count);
            }
            result.add(cur);
            return;
        }



            generateAbbreviationsHelper(word, result, index + 1, "", count + 1);
            generateAbbreviationsHelper(word,result,index+1,cur+ (count>0 ? String.valueOf(count):"")+word.charAt(index),0);


    }
}
