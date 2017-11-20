/**
 * Created by xhu on 6/17/17.
 */
public class SubMatrix {
    class Result{
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;

        public  Result(int left, int right, int up, int low){
            this.leftBound = left;
            this.rightBound = right;
            this.upBound = up;
            this.lowBound  = low;
        }


    }

    public Result maxSum(int input[][]){
        int rows = input.length;
        int cols = input[0].length;

        Result solution  = new Result(Integer.MIN_VALUE,0,0,0);

        for(int left = 0; left < cols ; left++){
            int temp[] = new int[rows];

            for(int right = left; right < cols; right++){
                for(int i=0; i < rows; i++){
                    temp[i] += input[i][right];
                }
                Result r = new Result(left, right, 0, 0);

                kadane( temp,r);

                if(solution.maxSum < r.maxSum){
                    solution.maxSum = r.maxSum;
                    solution.leftBound = r.leftBound;
                    solution.rightBound = r.rightBound;
                    solution.upBound = r.upBound;
                    solution.lowBound = r.lowBound;
                }
            }
        }
        return solution;
    }

    private void kadane(int arr[],Result r ){

        int local = arr[0];
        int max = arr[0];

        int tempUp = 0;
        int tempLow = 0;

        int up = 0;
        int low = 0;

        for(int i=1; i < arr.length; i++){
           if(local+arr[i] < arr[i]){
                local = arr[i];
                tempUp = i;
                tempLow = i;
           }else{
               local = local+arr[i];
               tempLow = i;

               up = tempUp;
               low = tempLow;
           }

           if(max < local){
               max = local;

               up = tempUp;
               low = tempLow;
           }
        }

        r.lowBound = low;
        r.upBound = up;
        r.maxSum = max;

    }


}
