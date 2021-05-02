import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 3/1/17.
 */
public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n){
        List<String> result = new ArrayList<>();
        int i = 0;

         if(n %2 == 1){
             i = 1;
             result.add("0");
             result.add("1");
             result.add("8");
         }else{
             result.add("");
         }

         for(; i<=n; i+=2){

             List<String> temp = new ArrayList<>();

             for(String s: result){
                 if(i!= n){
                     temp.add("0"+s+"0");
                 }

                 temp.add("1"+s+"1");
                 temp.add("6"+s+"9");
                 temp.add("8"+s+"8");

                 temp.add("9"+s+"8");
             }

             result = new ArrayList<>(temp);
         }

            return result;

    }


   // because we can add 0 at the begin so we need a sub function to find me find out


}
