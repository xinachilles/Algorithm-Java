import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 9/29/16.
 */
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if(digits ==null || digits.length() ==0){
            return result;
        }

        List<List<Character>> letters = getAllLetters(digits);

        letterCombinationsHelper(letters,"",result,0);
        return result;
    }


    private void letterCombinationsHelper(List<List<Character>> letters,String solution, List<String> result,int level){
        if(level == letters.size()){
            result.add(solution.toString());
            return;
        }

        for(Character c : letters.get(level)){
            letterCombinationsHelper(letters,solution.length() == 0? c.toString(): solution+c.toString(),result,level+1);

        }
    }

    private List<List<Character>>  getAllLetters(String s){
        List<List<Character>> result = new ArrayList<>();
        for(Character c : s.toCharArray()){
            List<Character> charNumbers = new ArrayList<>();
            int number = Character.getNumericValue(c);
            int size  = 3;


            if(number==7 || number==9){
                size = 4;
            }

            for(int i = 0; i<size;i++){
                char letter = (char)('a'+ (number-2)*3+i);
                if(number>=7){
                    letter = (char)(letter+1);
                }
                charNumbers.add(letter);
            }

            if(charNumbers.size()>0) result.add(charNumbers);
        }

        return result;
    }
}
