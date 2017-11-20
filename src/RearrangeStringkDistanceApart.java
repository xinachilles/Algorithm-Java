/**
 * Created by xhu on 6/11/17.
 */
public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        //assump the the input letter is lowercase letters
        int[] counts = new int[26];
        int[] valid = new int[26];

        for(int i = 0; i<s.length(); i++){
            counts[s.charAt(i)-'a']++;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<s.length();i++){
            int j = selectValue(i,counts,valid);
            if(j == -1){
                return "";
            }

            result.append(j+'a');
            valid[j] = i+k;
        }

        return result.toString();


    }

    private int selectValue(int index, int[] counts, int[] valid){
        int j  = -1;
        int maxCount = Integer.MIN_VALUE;

        for(int i = 0; i<counts.length;i++){
            if(counts[i] >0 && counts[i]>maxCount && valid[i]>=index){
                maxCount = counts[i];
                j = i;
            }
        }

        return j;


    }
}
