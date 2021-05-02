import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        if( n == 0 || logs == null || logs.size() == 0){
            return new int[]{};
        }

        String[] task = new String[3];
        int[] result = new int[n]; // for the excution time
        //Stack<Integer> stack  = new Stack<Integer>();

        // stack.push(Integer.parseInt(task[0])); // push the task index to
        int i = 0, pre = 0;

        while(i<logs.size()){
            task = logs.get(i).split(":");


            if(task[1].equals( "start")){

                result[ Integer.parseInt(task[0])] += Integer.parseInt(task[2]) - pre;
                pre = Integer.parseInt(task[2]);
               // stack.push(Integer.parseInt(task[0]));
            }else{

                result[Integer.parseInt(task[0])] += Integer.parseInt(task[2]) - pre+1;
                pre = Integer.parseInt(task[2])+1;
              //  stack.pop();
            }
            i++;
        }

        return result;






    }
}
