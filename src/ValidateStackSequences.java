import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || popped ==null){
            return false;
        }


        int indexPop = 0;
        int indexPush = -1;

        for(int i = 0; i<pushed.length;i++){
            pushed[++indexPush] = pushed[i];
            while (indexPush >=0 && indexPop< popped.length && pushed[indexPush] == popped[indexPop]){
                indexPush--;
                indexPop++;
            }
        }

        return indexPush==-1;

    }
}
