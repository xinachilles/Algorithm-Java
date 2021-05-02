package MOA;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Interview {
    public int test1(int[][] matrix){
        int total = matrix.length;
        // number of people i know
        int[] know = new int[total];
        // number of people know i
        int[] knowing = new int[total];
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length;j++){
                if(matrix[i][j] == 1){
                    know[i]++;
                    knowing[j]++;
                }
            }
        }

        for(int i = 0; i<know.length;i++){
            if( know[i] == 0 && knowing[i] == total-1){
                return i;
            }
        }

        return -1;
    }
    public String test2(String a, Set<Character> set){
        int slow = 0;
        int fast = 0;
        String result = "";
        Map<Character,Integer> maps = new HashMap<>();
        for(;fast<a.length();fast++){
            char c= a.charAt(fast);
            if(set.contains(c)) {
                maps.put(c, maps.getOrDefault(c, 0) + 1);
            }
            while (maps.keySet().size() == set.size() ){
                char s = a.charAt(slow);
                if(result.equals("") || fast-slow+1<result.length()){
                    result = a.substring(slow,fast+1);
                }
                if(set.contains(s)) {
                    maps.put(c, maps.get(s) - 1);
                }
                if(maps.get(c) ==0){
                    maps.remove(c);
                }
                slow++;
            }
        }
        return  result;
    }


}
