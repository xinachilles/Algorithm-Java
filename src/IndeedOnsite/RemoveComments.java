package IndeedOnsite;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        if(source ==null || source.length==0){
            return result;
        }
        boolean model = false;
        for(String s: source){
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i<s.length();i++){
                if(i+1<s.length() && s.charAt(i) == '*' && s.charAt(i+1)=='/'){
                    model  = false;
                    i++;
                }else if(i+1<s.length() && s.charAt(i) == '/' && s.charAt(i+1)=='/'){
                    break;
                }else if(i+1<s.length() && s.charAt(i) == '/' && s.charAt(i+1)=='*'){
                    model = true;
                    i++;
                }else{
                    builder.append(s.charAt(i));
                }
            }

            if(!model){
                result.add(builder.toString());
            }
        }
        return result;
    }
}
