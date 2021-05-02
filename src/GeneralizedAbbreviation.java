import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/9/16.
 */
public class GeneralizedAbbreviation {
    //Generalized Abbreviation
    List<String> result = new ArrayList<>();
    public List<String> generateAbbreviations(String word)
    {
        if (word == null || word.length() == 0)
        {
            return result;
        }

        generateAbbreviationsHelper(word, new StringBuilder(),0,0);
        return result;
    }

    private void generateAbbreviationsHelper(String word, StringBuilder curr, int index, int count) {
        if (index == word.length())
        {

            result.add(word);
            return;
        }
        // constructed by number
        // previus is number
        if(index>0 && Character.isDigit(curr.charAt(curr.length()-1))){
           // generateAbbreviationsHelper(word, curr.setCharAt(curr.length()-1,(char)(count -'0')),index+1,0);
        }else{

        }

        // ornot
        generateAbbreviationsHelper(word, curr.append(word.charAt(index)),index+1,0);

    }
}
