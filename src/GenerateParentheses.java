import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/23/16.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<String>();

        if(n <=0){
            return result;
        }

        generateParenthesisHelper(n, n,result,"");
        return result;


    }

    private void generateParenthesisHelper(int left, int right,List<String> result,String solution){
        if(left == 0 && right == 0){
            result.add(solution.toString());
            return;
        }

        if (left>0){
            generateParenthesisHelper(left-1,right, result,solution+"(");
        }

        generateParenthesisHelper(left,right-1,result,solution +")" );
    }

}



