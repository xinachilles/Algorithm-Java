import java.util.ArrayList;
import java.util.List;

public class DiffBetweenTwoStrings {
    public String[] diffBetweenTwoStrings(String source, String target) {
        // your code goes here
        // conner case
        if (source == null || target == null) {
            return new String[]{};
        }
        int[][] ways = new int[source.length() + 1][target.length() + 1];
        List<String> result = new ArrayList<>();
        // ways[i][j] the min changes from 0 to i of souce to 0 to j of target
        // ways[i][j] = min( ways[i-1][j],  ways[i][j-1] )

        // if source is null, insert..
        for (int i = 1; i <= target.length(); i++) {
            ways[0][i] = ways[0][i - 1] + 1;

        }
        // if word2 is null, delete
        for (int i = 1; i <= source.length(); i++) {
            ways[i][0] = ways[i - 1][0] + 1;

        }

        // only change word1 and word2 should not be changed
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    ways[i][j] = ways[i - 1][j - 1];
                    result.add(String.valueOf(source.charAt(i)));
                } else {

                    int insert = ways[i][j - 1];
                    int delete = ways[i - 1][j];
                    if (insert < delete) {
                        ways[i][j] = insert;
                        result.add("+" + target.charAt(j));
                    } else {
                        ways[i][j] = delete;
                        result.add("-" + source.charAt(i));
                    }
                }
            }
        }
        int i =0;
        int j = 0;
        while( i<source.length() && j<target.length()){
            if(source.charAt(i) == target.charAt(j)){
                result.add(String.valueOf(source.charAt(i)));
                i++;
                j++;
            }else if(ways[i+1][j]<= ways[i][j+1]){
                result.add("+" + target.charAt(j));
                j++;
            }else{
                result.add("-" +source.charAt(i));
                i++;
            }
        }

        while(j<target.length()){
            result.add("+"+ target.charAt(j));
            j++;
        }


        String[] Arr = new String[result.size()];
        return result.toArray(Arr);

    }
}

