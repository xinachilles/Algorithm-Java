/**
 * Created by xhu on 5/23/17.
 */
public class BinaryPalindrome {
    public boolean isBinaryPalindrome(int num){
        int numberOfBit = (int) Math.floor( (Math.log(num) / Math.log(2) )+1);
        int right = numberOfBit-1;
        int left = 0;

        while(left<right){
            if(getBit(num,left) == getBit(num,right)){
                left++;
                right--;
            }else{
                return false;
            }
        }

        return  true;


    }

    private boolean getBit(int num, int index){
      return (num &(1<<index)) !=0;
    }
}
