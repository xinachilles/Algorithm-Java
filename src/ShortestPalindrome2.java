public class ShortestPalindrome2 {
    public String shortestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return s;
            }

            int i = 0, j = s.length()-1;
            int end = s.length()-1;

            while(i<j){
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }else{
                    i = 0;
                    end--;
                    j = end;
                }
            }

            return new StringBuilder(s.substring(end+1,s.length())).reverse()+s;
        }

    }

