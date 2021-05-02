
public class CustomSortString {

    public String customSortString(String S, String T) {
        int[] bucket = new int[26];
        // put T into the backet

        for(int i = 0; i<T.length(); i++ ){
            bucket[T.charAt(i)-'a']++;
        }

        StringBuilder result =new StringBuilder();
        // sort the T basice on the S order first
        for(int i = 0; i<S.length();i++){
            for(int j = 0; j<bucket[S.charAt(i)-'a'];j++){
                result.append(S.charAt(i));
            }
            bucket[S.charAt(i)] = 0;
        }

        // put rest of T to result
        for(int i = 0;i<26;i++){
            for(int j = 0; j<bucket['a'+i]; j++){
                result.append((char)('a'+i));
            }
        }

        return result.toString();
    }
}
