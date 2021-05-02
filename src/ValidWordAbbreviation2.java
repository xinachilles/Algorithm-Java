public class ValidWordAbbreviation2 {
    public boolean validWordAbbreviation(String word, String abbr) {
        return helper(word, 0, abbr, 0,0);
    }

    private boolean helper(String word, int i, String abbr, int j, int current){

        if( i == word.length()){
            return j == abbr.length();
        }

        if(i>=word.length() || j>=abbr.length()){
            return false;
        }

        if(Character.isDigit(abbr.charAt(j))){
            current = current*10+Character.getNumericValue(abbr.charAt(j));
            return helper(word, i,abbr,j+1,current);
        }else{
            i = i+current;
            if(word.charAt(i) == abbr.charAt(j)){
                return helper(word, i+1,abbr,j+1,0);
            }
        }

        return false;
    }
}
