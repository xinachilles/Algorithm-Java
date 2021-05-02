public class AddStrings {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null){
            return null;
        }

        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder resut  = new StringBuilder();
        int carry = 0;
        while(i>=0 || j >=0){
            int n = 0;
            if( i <0) {
                char c = num2.charAt(j);
                n = c - '0';
                j--;
            }else if(j<0) {
                char c = num1.charAt(i);
                n = c - '0';
                i--;
            }else{
                char c1 = num1.charAt(i);
                char c2 = num2.charAt(j);
                n = (c1-'0')+(c2-'0');
                i--;
                j--;
            }
            carry = n/10;
            n = n%10;
            resut.append(String.valueOf(n));

    }
        if(carry>0){
            resut.append(String.valueOf(carry));
        }

        return resut.reverse().toString();
}
}
