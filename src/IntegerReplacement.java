import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IntegerReplacement {
    //If n is even, replace n with n / 2.
    //If n is odd, replace n with either n + 1 or n - 1.
    //Return the minimum number of operations needed for n to become 1.
    public int integerReplacement(int n) {
        if(n <=1){
            return 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int step = 0;
        while(!queue.isEmpty()){
            for(int i = 0; i<queue.size();i++) {
                int num = queue.poll();
                if (num == 1) {
                    return step;
                }
                if (num % 2 == 0 && !visited.contains(num / 2)) {
                    queue.offer(num / 2);
                } else {
                    queue.offer(n + 1);
                    queue.offer(n - 1);
                }
            }
            step++;

        }

        return -1;


    }
}
