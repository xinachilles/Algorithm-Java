package FBOA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 7/8/17.
 */
public class LowercaseUpcase {
    public List<String> AllLowerAndUpcase(String a){
        if(a == null || a.length() == 0){
            return null;
        }

        List<String[]> combination = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for(char a1 : a.toCharArray()){
            String [] letters = new String[2];
            letters[0] = String.valueOf(a1).toLowerCase();
            letters[1] = String.valueOf(a1).toUpperCase();

             combination.add(letters);
        }

        DFS(combination,result,"",0);
        return result;
    }

    private void DFS(List<String[]> combination, List<String> result, String solution, int index ){
        if(index == combination.size()) {
            result.add(solution);

            return;
        }

        for(int i = 0; i<combination.get(index).length; i++){
            DFS(combination,result,solution.length() == 0? combination.get(index)[i]:solution+combination.get(index)[i],index+1);
        }
    }

}
