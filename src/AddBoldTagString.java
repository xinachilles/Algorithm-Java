public class AddBoldTagString {
    public String addBoldTag(String s, String[] dict) {
        if(s == null || dict == null){
            return s;
        }

        boolean[] bold = new boolean[s.length()];
        for(String d : dict){
            if(s.indexOf(d)>=0){
                for(int i = s.indexOf(d); i<d.length();i++){
                    bold[i] = true;
                }
            }
        }
        String result = "";
        for(int i = 0; i<bold.length;i++){
            if(bold[i]) {
                if (i == 0 || (i > 0 && bold[i - 1] == false)) {
                   // result =  result+<>;
                }
            }
                 result = result+ s.charAt(i);
             if(bold[i]) {
                 if (i == bold.length - 1 || (i < bold.length - 1 && bold[i + 1] == false)) {
                     result = result + "</b>";
                 }
             }
        }
        return  result;


    }
}
