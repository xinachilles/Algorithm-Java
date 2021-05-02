import java.util.ArrayList;
import java.util.List;

public class Game24 {
    public boolean judgePoint24(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        List<Double> solution = new ArrayList<>();
        for(int n: nums){
            solution.add((double)n);
        }
        return helper(solution);
    }

    private boolean helper(List<Double> solution ){
        if(solution.size() == 0){
            return false;
        }
        if(solution.size() == 1){
            return Math.abs(solution.get(0)-24) <0.01;
        }
        boolean result = false;
        for(int i = 0; i<solution.size();i++){
            for(int j = i+1; j< solution.size();j++){
                List<Double> temp = new ArrayList<>();
                for(int k =0;k<solution.size();k++){
                    if(k!=i && k!= j){
                        temp.add(solution.get(k));
                    }
                }
                double a = solution.get(i);
                double b = solution.get(j);
                temp.add(a+b);
                result |=helper(temp);
                temp.remove(temp.size()-1);

                temp.add(a-b);
                result |=helper(temp);
                temp.remove(temp.size()-1);

                temp.add(b-a);
                result |=helper(temp);
                temp.remove(temp.size()-1);

                temp.add(a*b);
                result |=helper(temp);
                temp.remove(temp.size()-1);
                if(b!= 0){
                    temp.add(a/b);
                    result |=helper(temp);
                    temp.remove(temp.size()-1);
                }
                if(a!=0){
                    temp.add(b/a);
                    result |=helper(temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
        return result;
    }
}
