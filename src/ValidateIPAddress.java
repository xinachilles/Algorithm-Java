public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0 ){
            return "Neither";
        }
        String[] ip4 = IP.split("[.]");
        String[] ip6 = IP.split(":");
        if(ip4.length == 4 && IP.chars().filter(a->a =='.').count() == 3 ){
            for(String s : ip4){
                if(isIP4(s)){
                    continue;
                }else{
                    return "Neither";
                }
            }
            return "IPv4";
        }

        if(ip6.length == 8 && IP.chars().filter(a->a ==':').count() == 7){
            for(String s : ip6){
                if(isIP6(s)){
                    continue;
                }else{
                    return "Neither";
                }
            }
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isIP4(String s){
        if(s.length()==0 || s.charAt(0) == '0'){
            return false;
        }
        try{
            int number = Integer.valueOf(s);
            if( number>=0 && number <=255){
                return true;
            }else{
                return false;
            }

        }catch(NumberFormatException e){
            return false;
        }
    }

    private boolean isIP6(String s){
        if(s.length() >4 || s.charAt(0) == '-'){
            return false;
        }
        try{
            int number = Integer.parseInt(s,16);
            if( number>=0 ){
                return true;
            }else{
                return false;
            }

        }catch(NumberFormatException e){
               return false;
        }
    }
}
