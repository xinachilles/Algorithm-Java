package FBOA;

/**
 * Created by xhu on 7/9/17.
 */
public class StringRepeat {
    public String StringRepeat(String a){
        if(a == null || a.length() == 0){
            return a;
        }

        int count = 1;
        char previous = a.charAt(0);
        StringBuilder result = new StringBuilder();

        for(int i = 1; i<a.length(); i++){
            if(a.charAt(i) == previous){
                count++;
            }else{
                result.append(String.valueOf(count)).append(previous);
                count = 1;
                previous = a.charAt(i);
            }
        }

        result.append(String.valueOf(count)).append(previous);
        return result.toString();


    }
}
