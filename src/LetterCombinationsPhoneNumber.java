import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xhu on 9/29/16.
 */
public class LetterCombinationsPhoneNumber {
   /* public List<String> letterCombinations(String digits){
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
    }*/

   /* public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> visited = new LinkedList<>();
        visited.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int number = (int) (digits.charAt(i) - '0');
            if (number < 0 || number > 9) {
                continue;
            }

            int size = visited.size();
            for (int k = 0; k < size; k++) {
                String current = visited.poll();
                for (int j = 0; j < letters[number].length(); j++) {
                    current = current + letters[j];
                    visited.offer(current);
                }
            }


        }

        result = new ArrayList<>(visited);
        return result;

    }*/

    public List<String> letterCombinations(String digits) {
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();
        helper(letters, digits, result, "", 0);
        return result;
    }

    private void helper(String[] letters, String digits, List<String> result, String solution, int index) {
        if (index == digits.length()) {
            result.add(solution);
            return;
        }


        int number = (int) (digits.charAt(index) - '0');
        if (number < 0 || number > 9) {
            return;
        }

        for (int j = 0; j < letters[number].length(); j++) {
            helper(letters, digits, result, solution.length() == 0 ? String.valueOf(letters[number].charAt(j)) : solution + letters[number].charAt(j), index + 1);

        }

    }
}

