public class StringAbbreviationMatch {

    public boolean match(String input, String pattern) {
        // Write your solution here
        if(input == null && pattern == null ){
            return true;
        }

        if(input == null || pattern == null){
            return  false;
        }

        return helper(input,pattern);
    }

    private boolean helper(String input,String pattern){
        if(input.length() == 0 && pattern.length() == 0){
            return true;
        }

        if(input.length() == 0 || pattern.length() ==0){
            return false;
        }


        if(Character.isDigit(pattern.charAt(0))){
            int index = 0;
            int number = 0;

            while (index<pattern.length() && Character.isDigit(pattern.charAt(index))){
                  number = number*10+Character.getNumericValue(pattern.charAt(index));
                  index++;
            }
            if(number>input.length()){
                return false;
            }
            return helper(input.substring(number),pattern.substring(index));


        }else if( input.charAt(0) != pattern.charAt(0)){
            return false;
        }else{
            return helper(input.substring(1),pattern.substring(1));
        }





    }
}
