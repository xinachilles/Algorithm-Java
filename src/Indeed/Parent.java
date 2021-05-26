package Indeed;


import java.util.*;

public class Parent {
    /*
           输入是int[][] input, input[0]是input[1] 的parent，比如 {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}}会形成上面的图
                   第一问是只有0个parents和只有1个parent的节点

       */
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
/*两个节点是否有公共祖先*/
    public static boolean hasCommonAncestor(int[][]input, int x, int y){
          // build a map of child ->their parents
        Map<Integer,List<Integer>> childToParents = new HashMap<>();
        for(int i=0;i<input.length;i++){
            childToParents.computeIfAbsent(input[i][1],a->new ArrayList<>()).add(input[i][0]);
        }
        // contains all parents for node x
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
// then go through all parents for node y find out if they have common ancestor

        queue.add(y);
        while(!queue.isEmpty()){
            int child = queue.poll();
            //1,3 will return false
            if(parentsSet.contains(child) && (childToParents.containsKey(child) && childToParents.get(child).size()>0) ){
                return true;
            }
            if(childToParents.containsKey(child)){
                queue.addAll(childToParents.get(child));
            }
        }

        return false;

    }

    /*
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
    */
    public static int earliestAncestor(int[][] input, int x){
        Map<Integer,List<Integer>> childToParents = new HashMap<>();
        for(int i=0;i<input.length;i++){
            childToParents.computeIfAbsent(input[i][1],a->new ArrayList<>()).add(input[i][0]);
        }
        List<Integer> previouslevel = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        //go through the graph from bottom to top to find the earliest ancestor
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i<size; i++) {
                int child = queue.poll();

                if (childToParents.containsKey(child)) {
                    temp.addAll(childToParents.get(child));
                }
            }
            queue.addAll(new ArrayList<>(temp));
            if(temp.size()>0){
                previouslevel = new ArrayList<>(temp);
            }
        }


        return previouslevel.size()==0 ?-1:previouslevel.get(0);

    }



    public static void main(String[] args){
     //int[][] input = new int[][]{{1,4}, {1,5}, {2,5}, {3,6}, {6,7}};
     int[][] input = new int[][] { {1, 3}, {2, 3}, {3, 6}, {5, 6},
             {5, 7}, {4, 5}, {4, 8}, {8, 10},{11,2}  };
        List<Integer> result = findNodesWithZeroOrOneParent(input);
     System.out.println("Question 1");
        for(int r: result){
        System.out.print(r);
        System.out.print("|");
     }
     System.out.println("");
     System.out.println("Question 2");
     boolean result2 = hasCommonAncestor(input,1,3);
     System.out.println(result2);

     int result3 = earliestAncestor(input,3);
     System.out.println("Question 3");
     System.out.println(result3);
    }

}
