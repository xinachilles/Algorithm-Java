
public class StringShuffling {
    // covert the string ABCDE12345 to A1B2C3D4E5
    // inplace
    public void StringShuffling(char[] s ){
        StringShufflingHeler(s, 0,  s.length-1);

    }

    private void StringShufflingHeler(char[] s,int left, int right){
        if(right-left <=1){
            return;
        }

        int size= right-left+1;
        int mid = left+ size/2;

        int leftmid = left+ size/4;
        int rightmid = left+3*size/4;

        Reverse(s,leftmid,mid-1);
        Reverse(s,mid,rightmid-1);
        Reverse(s,leftmid,rightmid-1);

        StringShufflingHeler(s,left,left+2*(leftmid-left)-1);
        StringShufflingHeler(s,left+2*(leftmid-left),right);

    }

    private void Reverse(char[] s,int left, int right ){

        while (left<right){
             char temp = s[left];
             s[left] = s[right];
             s[right] = temp;

             left++;
             right--;
         }
    }
}
