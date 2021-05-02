package DOA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountAllValidPickupDeliveryOptions2 {
    Set<Character> pService = new HashSet<>();
    Set<Character> dService = new HashSet<>();

    public boolean countOrders(String input){
        for(int i = 0; i<input.length();i+=2){


            char service = input.charAt(i);
            if(i+1>=input.length()) return false;
            char number = input.charAt(i+1);

            if(service == 'P'){
                if(pService.contains(number)){
                    return  false;
                }else{
                    pService.add(number);
                }
            }else if(service == 'D'){
                if(!pService.contains(number) || dService.contains(number)){
                    return  false;
                }else{
                    dService.add(number);
                }
            }

        }
        return true;
    }
}
