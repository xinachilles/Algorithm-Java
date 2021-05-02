import java.util.*;

public class ReorganizeString {



    public String reorganizeString(String S) {
       if(S == null || S.length() == 0){
           return "";
       }

        int[] letters = new int[24];
        for(Character c : S.toCharArray()){
            letters[c-'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b)->{if(letters[a-'a'] ==letters[b-'a']){return a-b; }
                                                                    else{ return letters[a-'a']-letters[b-'a'];}});
        for(int i =0; i<24;i++){
            if(letters[i]>0){
                pq.offer((char)('a'+i));
            }
        }

        String result = "";
        while (pq.size()>0){
            List<Character> temp = new ArrayList<>();

            while (pq.size()>0){
                char c = pq.poll();
                if(result.length()>0 && result.charAt(result.length()-1) == c){
                        return "";
                }else{
                    result = result+c;
                }

                letters[c-'a']--;
                if(letters[c-'a']>0){
                    temp.add(c);
                }

            }
        }
        return result;
    }


}
