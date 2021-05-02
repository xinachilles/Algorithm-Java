public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        int count = 1;
        int max = 1;

        for(int i = 1; i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }

            max = Math.max(count,max);
        }

        return max;
    }
}
