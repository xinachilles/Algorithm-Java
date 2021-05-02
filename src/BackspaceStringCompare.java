import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int numberOfSharpS =0;
        int numberOfSharpT = 0;

        int indexS = S.length();
        int indexT = T.length();

        while(indexS>=0 && indexT>=0){
            while(indexS>=0 && (S.charAt(indexS) == '#' || numberOfSharpS>0) ){
                if(S.charAt(indexS) == '#'){
                    numberOfSharpS++;
                }else{
                    numberOfSharpS--;
                }
            }

            while(indexT>=0 && (T.charAt(indexT) == '#' || numberOfSharpT>0) ){
                if(T.charAt(indexT) == '#'){
                    numberOfSharpT++;
                }else{
                    numberOfSharpT--;
                }
            }

            if(indexS<0){
                return indexS == indexT;
            }

            if(S.charAt(indexS) != T.charAt(indexT)){
                return false;
            }
            indexS--;
            indexT--;
        }

        return true;

    }
}
