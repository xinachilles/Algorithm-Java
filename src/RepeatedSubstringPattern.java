/**
 * Created by xhu on 3/10/17.
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s){
        if(s ==null || s.length() == 0){
            return false;
        }

        for(int i = 0; i<s.length()/2; i++){
            String pattern = s.substring(0,i+1);
            if(helper(s.substring(i+1),pattern)){
                return true;
            }
        }
        return false;
    }



    private boolean helper(String s,String pattern){

        if(s.equals(pattern)){
            return true;
        }

        if(s.length()<pattern.length()){
            return false;
        }



        if(pattern.equals(s.substring(pattern.length()))){
            return helper(s.substring(pattern.length()),pattern);
        }else{
            return false;
        }

    }
}
