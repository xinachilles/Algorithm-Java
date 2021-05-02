import java.util.ArrayList;
import java.util.List;

public class FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        if(trust ==null || N <=0){
            return -1;
        }


        List<Integer>[] trustArray = new ArrayList[N+1];
        for(int i  =1; i<=N; i++) {
            trustArray[i] = new ArrayList<>();
        }
        for(int i =0; i<trust.length; i++){
            int a = trust[i][0];
            int b = trust[i][1];
            trustArray[a].add(b);

        }
        int candidate = -1;
        for(int i = 1; i<=N;i++){

        }
        for(int i= 1; i<=N; i++){
            if( i == candidate){
                if(trustArray[i].size() >0){
                    return -1;
                }
            }else{
                if(trustArray[i].contains(candidate) == false){
                    return -1;
                }
            }
        }

        return candidate;
    }






}

