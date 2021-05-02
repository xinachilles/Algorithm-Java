import java.util.Random;

public class RandomPickWeight {
    Random r;
    int [] sum;
    public RandomPickWeight(int[] w) {
        r = new Random();
        sum[0] = w[0];
        for(int i = 1; i<w.length;i++){
            sum[i] = sum[i-1]+w[i];
        }

    }
    // return the index which equal or smallest number greater than target
    private  int binarySearch(int target, int[] sum){
        int start = 0;
        int end = sum.length-1;

        while (start+1<end){
            int mid = start+(end-start)/2;
            if(sum[mid] == target){
                return mid;
            }else if(target< sum[mid]){
                end  = mid;
            }else{
                start = mid;
            }
        }

        if(sum[start] >= target){
            return start;
        }else{
            return  end;
        }
    }
    public int pickIndex() {
        int guess = r.nextInt(sum[sum.length-1])+1;
        return binarySearch(guess,sum);


    }
}
