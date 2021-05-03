import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xhu on 10/15/16.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int j = 0;
        List<String> result = new ArrayList<>();

        while(j<words.length){

            int i = j;
            int lineLength = words[i].length();//how many word characters (doesn't include space) we can fit inside of this line
            int spaceNeeded = 0;//how many times (group of space) we need to apply a group of spaces inside of this line
            j++;
           while( j<words.length && lineLength+words[j].length()+spaceNeeded <maxWidth)
           {
               spaceNeeded++;
               lineLength+=words[j].length();
               j++;

           }

            int diff = maxWidth-lineLength;// total space needed for current line
            int numberOfwords = j-i;
            if(numberOfwords == 1 || j >=words.length){
                result.add(leftJustify(words,i,j,diff));
            }else{
                result.add(middleJustify(words,i,j,diff));
            }

        }
            return  result;
    }

    private String middleJustify(String[]words, int start, int end, int diff){
        int spaceNeeded = end-start-1;// how many group of space -- session needed (in between each word)
        int space = diff/spaceNeeded; // how many space needed for each seesction
        int extraSpace = diff%spaceNeeded;
        StringBuilder line  = new StringBuilder(words[start]);
        for(int k = start+1; k<end;k++){
            if(spaceNeeded>0) {
                for (int s = 0; s < space; s++) {
                    line.append(" ");

                }
                spaceNeeded--;
            }
            if(extraSpace>0){
                line.append(" ");
                extraSpace--;
            }

            line.append(words[k]);
        }

        return line.toString();
    }
    private String leftJustify(String[]words,int start,int end,int diff){

         int space =0;
         StringBuilder result = new StringBuilder(words[start] );
         for(int i = start+1; i<end; i++){
             result.append(" ");
             result.append(words[i]);
             space++;
         }
         // apply the rest of space to the right
         for(int i =0;i< diff-space;i++){
             result.append(" ");
         }

         return result.toString();

    }


}

