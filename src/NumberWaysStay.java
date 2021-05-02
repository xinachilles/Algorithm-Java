public class NumberWaysStay {
    public int numWays(int steps, int arrLen) {
        if(arrLen == 0){
            return 0;
        }
        int[][] ways = new int[steps][arrLen];
        //ways[i][j] is number of ways in poistion i after j step
        // ways[i][j] = ways[i][j-1]+ways[i-1][j-1]+ways[i+1][j-1];
        ways[0][0] = 1;

        for(int i= 1; i<steps; i++){
            for(int j =0; j<arrLen;j++){
                ways[i][j] = ways[i-1][j];

                if(j>0) ways[i][j]+= ways[i-1][j-1];

                if(j<arrLen-1) ways[i][j]+=ways[i-1][j+1];

            }
        }
        return ways[steps-1][0];
    }
}
