public class NumberGoodWaysSplitString {
    public int numSplits(String s) {
        int[] left = new int[26];
        int[] right = new int[26];

        for(char c : s.toCharArray()){
            right[c-'a']++;
        }
        int rightDiff = 0;
        int leftDiff = 0;
        for(int i = 0; i<right.length;i++){
            if(right[i]>0){
                rightDiff++;
            }
        }
        int result = 0;
        for(char c : s.toCharArray()){
            right[c-'a']--;
            if(right[c-'a'] == 0){
                rightDiff--;
            }
            left[c-'a']++;
            if(left[c-'a'] == 0){
                leftDiff++;
            }


            if(rightDiff== leftDiff){
                result++;
            }

        }
        return result;
    }

}
