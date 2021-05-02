// suffering the string from a1b2c3d4 to abcd124

public class StringSuffering {
/*
    public String stringSuffering(String s){
        if( s== null || s.length() == 0 ){
            return s;
        }

        return helper(s, 0,s.length()-1);
    }
*/
    // the function will return a array {a.b} ,a is the start point of letter and b will start point of number
    /*
    private int[] helper(char[] a, int left, int right, char[] temp ){
        if(right  == left ){
           if(Character.isDigit(a[left])){
               return new int[] {0,left};
           }else{
               return new int[]{left,0};
           }
        }

       if(left -left +1 == 2){
           return new int[] {left,right};
       }

       int mid = left+(right-left)/2;
       int[] larray = helper(a,left,mid,temp);
       int[] rarray = helper(a,mid+1, right,temp);

       for(int i = ;i<=larray[0];i++ ){
           temp[i] =a[i];
       }
       for(int i = right)
    }

     */
}
