package Indeed;

import javafx.scene.shape.LineTo;

import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class Parent {

   private static List<Integer> findNodesWithZeroOrOneParent(int[][] input){
        if(input == null || input.length ==0){
            return null;
        }
        // child - >list of parents
        int max = 0;
        Map<Integer,List<Integer>> parents = new HashMap<>();
        for(int i=0;i<input.length;i++){
            parents.computeIfAbsent(input[i][1],a->new ArrayList<>()).add(input[i][0]);
            parents.computeIfAbsent(input[i][0],a->new ArrayList<>());
        }
        List<Integer> result = new ArrayList<>();
       for(int node : parents.keySet() ){
           if(parents.get(node).size() == 0 || parents.get(node).size() ==1){
               result.add(node);
           }
       }

       return result;
    }

    public static boolean hasCommonAncestor(int[][]input, int x, int y){
          // build a map of child ->their parents
        Map<Integer,List<Integer>> childToParents = new HashMap<>();
        for(int i=0;i<input.length;i++){
            childToParents.computeIfAbsent(input[i][1],a->new ArrayList<>()).add(input[i][0]);
        }
        Set<Integer> parentsSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()){
           int child = queue.poll();
           parentsSet.add(child);
           if(childToParents.containsKey(child)){
               queue.addAll(childToParents.get(child));
           }
        }

        queue.add(y);
        while(!queue.isEmpty()){
            int child = queue.poll();
            if(parentsSet.contains(child)){
                return true;
            }
            if(childToParents.containsKey(child)){
                queue.addAll(childToParents.get(child));
            }
        }

        return false;

    }
    /*
        输入是int[][] input, input[0]是input[1] 的parent，比如 {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}}会形成上面的图
                第一问是只有0个parents和只有1个parent的节点

    */
    public static int earliestAncestor(int[][] input, int x, int y){
        Map<Integer,List<Integer>> childToParents = new HashMap<>();
        for(int i=0;i<input.length;i++){
            childToParents.computeIfAbsent(input[i][1],a->new ArrayList<>()).add(input[i][0]);
        }
        Set<Integer> parentsSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()){
            int child = queue.poll();
            parentsSet.add(child);
            if(childToParents.containsKey(child)){
                queue.addAll(childToParents.get(child));
            }
        }

        queue.add(y);
        int result = -1;
        while(!queue.isEmpty()){

            int child = queue.poll();
            if(parentsSet.contains(child)){
                result = child;
            }
            if(childToParents.containsKey(child)){
                queue.addAll(childToParents.get(child));
            }
        }

        return result;

    }
    public static void main(String[] args){
     int[][] input = new int[][]{{1,4}, {1,5}, {2,5}, {3,6}, {6,7}};
     List<Integer> result = findNodesWithZeroOrOneParent(input);
     for(int r: result){
      //   System.out.println(r);
     }
     boolean result2 = hasCommonAncestor(input,4,6);
     int result3 = earliestAncestor(input,4,5);
     System.out.println(result3);
    }

}
