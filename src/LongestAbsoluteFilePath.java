import java.util.ArrayList;
import java.util.List;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if(input == null || input.length()==0){
            return 0;
        }
        List<String> files = new ArrayList<>();
        for(int i = 0; i<input.length();i++){
            int j = i;
            while(i<input.length()&& input.charAt(i)!='\n'){
                i++;
            }
            // j == input.length or j = '\n
            files.add(input.substring(j,i));
        }
        List<String> dir = new ArrayList<>();
        int result = 0;
        for(String file: files){
            int k = 0;
            while (k<file.length()&& file.charAt(k) == '\t' ){
                k++;
            }
            if(dir.size() == k){
                dir.add(file.substring(k,file.length()));
            }else{
                dir.set(k, file.substring(k,file.length()));
            }

            if(dir.get(k).indexOf('.')!=-1){
                int count = 0;
                for(int i = 0; i<=k;i++){
                    count += dir.get(i).length();
                }
                count += k;
                result = Math.max(result,k);
            }

        }

        return result;

    }
}
