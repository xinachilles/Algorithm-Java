/**
 * Created by xhu on 7/4/17.
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }

        boolean isNumber = false;
        boolean isE = false;
        boolean isDot = false;

        s = s.trim();
        for(int i = 0;i<s.length(); i++){
            char current = s.charAt(i);

            if(Character.isDigit(current)){
                isNumber = true;
            }else if(current == '.'){
                if(isDot ||isNumber == false || isE){
                    return false;
                }else{
                    isDot = true;

                }
            }else if(current == 'e')
                if(isDot || isNumber == false || isE){
                    return false;
                }else{
                    isE = true;
                }
        }

        return true;
    }


}

