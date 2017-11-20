import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        if( n == 0 || logs == null || logs.size() == 0){
            return new int[]{};
        }

        String[] task = logs.get(0).split(":");
        int[] result = new int[n]; // for the excution time
        Stack<Integer> stack  = new Stack<Integer>();

        stack.push(Integer.parseInt(task[0])); // push the task index to
        int i = 1, time = Integer.parseInt(task[2]);

        while(i<logs.size()){
            task = logs.get(i).split(":");

            while(time<Integer.parseInt(task[2])){
                time++;
                result[stack.peek()]++;
            }

            if(task[1].equals( "start")){
                stack.push(Integer.parseInt(task[0]));
            }else{
                time++;
                result[stack.peek()]++;
                stack.pop();
            }
                i++;
        }

        return result;




    }
}
