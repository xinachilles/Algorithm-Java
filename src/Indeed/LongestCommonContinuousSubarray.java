package Indeed;

import org.testng.reporters.jq.Main;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonContinuousSubarray {
    // input
    //[
    //  ["3234.html", "xys.html", "7hsaa.html"], // user1
    //  ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
    //]

    //输出两个user的最长连续且相同的访问记录。
    //["xys.html", "7hsaa.html"]
    private static List<String> longestCommonContinuous(String[]history1, String[] history2){
       // the longest continue common subarray end with i,j
        int[][] longest = new int[history1.length+1][history2.length+1];
        int max = 0;
        int end = 0;

        for(int i = 0; i<history1.length;i++){
            for(int j =0; j<history2.length;j++){
                if(history1[i].equals(history2[j])){
                    longest[i+1][j+1] = longest[i][j] +1;
                }else{
                    longest[i+1][j+1] = 0;
                }
                if(max <longest[i+1][j+1]){
                    max = longest[i+1][j+1];
                    end = i;
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int i =end; i>=end-max+1 && i>=0; i--){
            result.add(0,history1[i]);
        }
        return result;
    }
    public static void main(String[] args){

     String[] history1 = new String[]{"3234.html", "xys.html", "7hsaa.html"};
     String[] histroy2 = new String[]{"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};

     List<String> result = longestCommonContinuous(history1, histroy2);
     for(String r: result){
         System.out.println(r);
     }
    }

}
