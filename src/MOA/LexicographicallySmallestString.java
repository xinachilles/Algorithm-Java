package MOA;

public class LexicographicallySmallestString {
    private String lexiSmallestString(String s) {

        StringBuilder str = new StringBuilder(s);
        int i=0;
        for(i=0; i<str.length()-1; i++){
            if(str.charAt(i)>str.charAt(i+1)){
                break;
            }
        }

        return str.deleteCharAt(i).toString();
    }

}
