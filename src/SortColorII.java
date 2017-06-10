/**
 * Created by xhu on 4/26/17.
 */
public class SortColorII {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0){
            return;
        }


        int start = 0;
        int end = colors.length-1;
        while(start<= end){


            int current = start;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = start; i<=end; i++){
                min = Math.min(min,colors[i]);
                max = Math.max(max,colors[i]);
            }

            while(current <end){

                if(colors[current] >min && colors[current]  <max){
                    current++;
                }else if(colors[current]  == min){
                    switchData(colors,current,start);
                    start++;
                    current++;

                }else{
                    switchData(colors,current,end);
                    end--;
                }
            }


        }

    }

    private void switchData(int[] nums,int start, int end){
        if(start>=0 && start<nums.length && end >=0 && end<nums.length){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
