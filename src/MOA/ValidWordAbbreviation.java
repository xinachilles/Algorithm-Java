package MOA;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null){
            return false;
        }


        int i = 0;// index for word
        int j = 0; // index for abbr

        while(i<word.length() &&j<abbr.length() ){
            if(Character.isDigit(abbr.charAt(j) )){
                if(abbr.charAt(j)=='0'){
                    return false;
                }
                int number  = 0;
                while(j<abbr.length() && Character.isDigit(j)) {
                    number = number * 10 + Character.getNumericValue(abbr.charAt(j));
                    j++;
                }
                i+=number;
            }else{
               if(word.charAt(i) != word.charAt(j)){
                   return false;
               }
               i++;
               j++;
            }

        }

        if(i < word.length() || j< abbr.length()) {
            return false;
        }

        return true;
    }
}
