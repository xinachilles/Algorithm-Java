/**
 * Created by xhu on 6/23/17.
 */
public class DecodeString3 {

    // s need sort.
    // if s is not sorted, use hashtable

    public String Encode(String s){
        if(s == null ){
            return  s;
        }

        int count = 1;
        char previous = s.charAt(0);
        StringBuilder result = new StringBuilder();
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) == previous ){
                count++;
            }else {
                result.append(previous).append(String.valueOf(count));
                count = 1;
                previous = s.charAt(i);
            }
        }

        if(count >=0){
            result.append(previous).append(String.valueOf(count));
        }

        return result.toString();

    }

    public String Decode(String s){
        StringBuilder result = new StringBuilder();
        String previous = "";
        int number = 0;
        for(int i = 0; i<s.length();i++){
            Character current = s.charAt(i);

            if(Character.isDigit(current)){
                number = number*10+Character.getNumericValue(current);

                if(i == s.length()-1 || !Character.isDigit(s.charAt(i+1))){
                    for(int j = 0; j<number;j++){
                        result.append(previous);
                    }
                }

                number = 0;
                previous = "";
            }else{
                previous = previous+current;
            }
        }

        return result.toString();
    }
}
