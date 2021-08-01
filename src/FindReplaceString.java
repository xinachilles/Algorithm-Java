import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FindReplaceString {
   public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //Check if the substring sources[i] occurs at index indices[i] in the original string s.
        List<int[]> sorted = new ArrayList<>();
        for(int i = 0; i<indices.length;i++){
            sorted.add(new int[] {indices[i],i});
        }
        Collections.sort(sorted,(a,b)->a[0]-b[0]);

     //   StringBuilder result = new StringBuilder();
        int j = 0;
        int i = 0;

        while(i<s.length()){
            if(j>=sorted.size()) break;
            int index = sorted.get(j)[1];

            if(indices[index] == i){

                if(s.substring(i,i+sources[index].length()).equals(sources[index])) {
                    s = s.substring(0,i)+targets[index]+s.substring(i+sources[index].length(),s.length());
                    i += sources[index].length();
                }
                j++;

            }else{
              i++;
            }

        }

        return  s;
    }

    private boolean check(String s, int start, String source){
        /*
        if(index<indices.length-1 && start+source.length()>indices[index+1]){
            return false;
        }
         */
        if(start+source.length()>s.length()){
            return false;
        }
        if(!s.substring(start,start+source.length()).equals(source)){
            return false;
        }
        return true;
    }

}
