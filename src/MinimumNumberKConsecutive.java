public class MinimumNumberKConsecutive {
    public int minKBitFlips(int[] A, int K) {
        int result = 0;
        int flipped = 0; // if flipped = 1-- A[i] has been flipped, if flipped == 0, A[i] has not been flipped
        int[] isflipped = new int[A.length]; // if we flipped A[i] set the isflipped[i] = 1

        for(int i =0;i<A.length;i++){
            // flipped is only for i-k to i, (once only flip k bit ) if i>=k, update the flipped -- like slide windows
            if(i>=K){
                flipped = flipped^isflipped[i-K];
            }
            // if flipped == A[i] means current A[i] = 0, we need flipped it to 0
            // flipped = 0 and A[i] = 0, current A[i] =0 need to flip
            // flipped = 1 and A[i] = 1, original A[i] = 1 but A[i] has been flipped, current A[i] = 0
            if(flipped == A[i]){
                if(i+K>A.length){
                    return -1;
                }
                isflipped[i] = 1;
                flipped = flipped^1; // 0 to 1, 1 to 0
                result++;
            }
        }


        return result;
    }


}
