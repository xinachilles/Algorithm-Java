public class ReplacetoAvoidConsecutive {

    public String modifyString(String s) {
        if(s ==null || s.length() == 0){
            return s;
        }

        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '?'){
                char a1 = 'a';
                boolean isvalid = false;
                for(;a1<='z';a1++){
                    if(i>=1 && result.charAt(i-1) == a1){
                        continue;
                    }
                    if(i<result.length()-1 && result.charAt(i+1) == a1){
                        continue;
                    }

                    isvalid= true;
                    break;
                }

                if(isvalid) {
                    result.setCharAt(i,a1);
                }else{
                    return "";
                }

            }
        }

        return result.toString();
    }
}
