import java.util.HashSet;
import java.util.Set;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int result = 0;

        for(String word: words){
            if(Stretchy(S,word)){
                result++;
            }
        }
        return  result;
    }
// string s is stretchy word of string word
    private boolean Stretchy(String S, String word){
       int i = 0; // i point to S
       int j = 0; // j point to word

        while (i<S.length() && j<word.length()){
           if(S.charAt(i) == word.charAt(j)){
               int len1 = getRepeatLength(S,i);
               int len2 = getRepeatLength(word,j);
               if(len1>=3 && len1<len2){
                   return false;
               }

               if(len1<3 && len1!=len2){
                   return false;
               }

               i+=len1;
               j+=len2;

           }else{
               return false;
           }
        }

        return  (i== S.length() && j == word.length());

    }

    private  int getRepeatLength(String str, int i){
        int start = i;
        while(i<str.length() && str.charAt(start) == str.charAt(i)){
            i++;
        }
        return i-1-start+1;
    }
}
