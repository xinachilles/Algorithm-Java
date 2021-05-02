public class TilingRectangleFewestSquares1240 {
    int result = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        if(n == m){
            return 1;
        }
        helper(n,m,m*n,0);
        return result;
    }

    private void helper(int n, int m,int area, int currentNumber){
        if(area<0 ||n<=0 ||m<=0 ){
            return;
        }
        if(area == 0){
            result = Math.min(result,currentNumber);
            return;
        }

        int min = Math.min(n,m);
        for(int i = 1; i<=min; i++){
            helper(n-i, m-i,area-i*i,currentNumber+1 );
        }

    }
}
