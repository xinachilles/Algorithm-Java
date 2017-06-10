package MOA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 6/5/17.
 */
public class ContiguousSubstring {
    public List<String> Substring(String s){
        List<String> result = new ArrayList<>();
        helper(s,result,"",0);
        return result;
    }

    private void helper(String s, List<String> result,String solution,int index){

        if(solution.length()>1 && !result.contains(solution)){
                result.add(solution);
        }



        for(int i = index; i<s.length(); i++){
            if(solution.length() == 0
                    || (solution.charAt(solution.length()-1) == 'Z' && s.charAt(i) == 'A')
                    || (solution.charAt(solution.length()-1) +1 == s.charAt(i))){
                helper(s,result,solution+s.charAt(i),index+1);
            }else{
                solution ="";
                helper(s,result,String.valueOf(s.charAt(i)),index+1);
            }
        }
    }
}
