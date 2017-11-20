public class reverseWords {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        String[] arrays = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String a: arrays){
            StringBuilder temp = new StringBuilder(a);
            result.append(temp.reverse()).append(" ");
        }

        return result.reverse().substring(1,result.length());
    }
}
