/**
 * Created by xhu on 3/5/17.
 */
public class BullsCows {

    //bulls and cows
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null){
            return "0A0B";
        }

        if(secret.length() != guess.length()){
            return "0A0B";
        }

        int[] counts = new int[10];
        int numberOfBull = 0;
        int numberOfCow  = 0;

        for(int i = 0; i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                numberOfBull++;
            }else{
                if(counts[secret.charAt(i)-'a']<0) numberOfCow++; // in guess before
                if(counts[guess.charAt(i)-'a']>0) numberOfCow++;

                counts[secret.charAt(i)-'0']++;
                counts[guess.charAt(i)-'0']--;
            }
        }

        return String.valueOf(numberOfBull)+"A" +  String.valueOf(numberOfCow)+"B";
    }
}
