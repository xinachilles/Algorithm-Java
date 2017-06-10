/**
 * Created by xhu on 10/22/16.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
      if(s == null || s.length() == 0){
          return s;
      }
      String s1 = s+"#"+new StringBuilder(s).reverse();

      int[] KMP = ConstructKMP(s1);
      int longstPalindrom = KMP[KMP.length-1];



        return new StringBuilder(s.substring(longstPalindrom)).reverse().toString() + s;
    }

    private int[] ConstructKMP(String s){
        int[] KMP = new int[s.length()];
        KMP[0] = 0;
        int k = 0;
        for(int i = 1;i<s.length();i++){
            while(k>0 && s.charAt(k) != s.charAt(i)){
                k = KMP[k-1];
            }

           if(s.charAt(k) == s.charAt(i)){
                k++;
           }

           KMP[i]  = k;
        }

        return KMP;
    }


}
