package FBOA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 7/9/17.
 */
public class PalindromeSubset {
    public List<String> PalindromeSubset(String s){
        if(s == null || s.length() == 0){
            return null;
        }

        List<String> result = new ArrayList<>();

        Helper(s,result,"", 0);
        return result;
    }

    private void Helper(String s,List<String> result, String solution,int index){
        if(isPalidrome(solution)){
            result.add(solution);
        }

        for(int i = index; i<s.length();i++){
            solution = solution+s.charAt(i);
            Helper(s,result,solution,i+1);
            solution = solution.substring(0,solution.length()-1);
        }
    }

    private boolean isPalidrome(String s){
        if(s == null || s.length() == 0){
            return false;
        }

        int start = 0;
        int end = s.length()-1;
        while (start <end){
            if(s.charAt(start) != s.charAt(end)){
                return false;

            }

            start++;
            end--;
        }

        return true;
    }
}
