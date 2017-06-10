import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xhu on 3/1/17.
 */
public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n){


        return findStrobogrammatic(n,n);

    }


   // because we can add 0 at the begin so we need a sub function to find me find out

    public List<String> findStrobogrammatic(int n, int m){

        if(n == 0){
            return Arrays.asList("");
        }

        if(n == 1){
            return Arrays.asList(new String[]{"0","1","8"});
        }

        List<String> result = findStrobogrammatic(n-2,m);
        List<String> temp = new ArrayList<>();
        for(String s : result){
            if (m !=n){
                temp.add("0"+s+"0");
            }
            temp.add("1"+s+"1");

            temp.add("6"+s+"9");

            temp.add("8"+s+"8");

            temp.add("9"+s+"8");
        }

        return temp;
    }
}
