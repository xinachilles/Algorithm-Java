package Indeed;

import java.util.*;

public class FriendCycle {
    /*
    * Sample Input:
employees = [
  "1, Bill, Engineer",
  "2, Joe, HR",
  "3, Sally, Engineer",
  "4, Richard, Business",
  "6, Tom, Engineer"
]

friendships = [
  "1, 2",
  "1, 3",
  "3, 4"
]

    * */
    /*
    * Pt 1.Given employees and friendships, find all adjacencies that denote the friendship, A friendship is bi-directional/mutual so if 1 is friends with 2, 2 is also friends with 1


    * */
    public static List<String> friendCycle1(String[] employees, String[] friendships){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildFriendGraph(graph,friendships);
        int total = employees.length;
        List<String> result = new ArrayList<>();
        for(int i =1; i<=total; i++){
            StringBuilder relationship = new StringBuilder();
            relationship.append(String.valueOf(i));
            relationship.append(":");
            if(graph.containsKey(i)){
                for(int j = 0; j<graph.get(i).size();j++){
                    relationship.append(String.valueOf(graph.get(i).get(j)));
                    if(j != graph.get(i).size()-1){
                        relationship.append(",");
                    }
                }
            }else{
                relationship.append("None");
            }
            result.add(relationship.toString());
        }
        return result;

    }
    private static void buildFriendGraph(Map<Integer, List<Integer>> graph,String[] friendships){
        for(String friend: friendships ){
            String[] f = friend.split(",");
            for(int i =1;i<f.length;i++){

                graph.computeIfAbsent(Integer.valueOf(f[0].trim() ),a->new ArrayList<>()).add(Integer.valueOf(f[i].trim() ));
                graph.computeIfAbsent(Integer.valueOf(f[i].trim()),a->new ArrayList<>()).add(Integer.valueOf(f[0].trim() ));
            }
        }
    }
/*
    Pt 2.Now for each department count the number of employees that have a friend in another department
*/
public static List<String> friendCycle2(String[] employees, String[] friendships){
    Map<Integer, List<Integer>> graph = new HashMap<>();
    // deparment-> all empoyee id
    Map<String,List<Integer>> departmentToemployee = new HashMap<>();
    // empoyee id -> deparemnt belong to
    Map<Integer,String> employeeToDepartment = new HashMap<>();
    buildFriendGraph(graph,friendships);
    buildEmployeeGraph(departmentToemployee,employeeToDepartment,employees);

    List<String> result = new ArrayList<>();
    for(String department: departmentToemployee.keySet()){
        // how many employee in this depeartment
        int total = departmentToemployee.get(department).size();
        int anotherDepartment = 0;
        Set<Integer> friendset = new HashSet<>();
        for(int i =0; i<total;i++){
            // all friend for those employee work in this department
            int id = departmentToemployee.get(department).get(i);
            if(!graph.containsKey(id)) continue;
            for(int friend: graph.get(id)){
                friendset.add(friend);
            }
        }
        // all the frined are from differetn department
        for(int id: friendset) {
            if (!employeeToDepartment.get(id).equals(department)) {
                anotherDepartment++;
            }
        }
        result.add(department+":"+String.valueOf(anotherDepartment)+"of"+String.valueOf(total));
    }
    return result;
}
private static void buildEmployeeGraph(Map<String, List<Integer>> departmentToemployee, Map<Integer,String> employeeToDepartment, String[] employees){
    for(String employee: employees){
        String[] e =  employee.split(",");
        departmentToemployee.computeIfAbsent(e[2],a->new ArrayList<>()).add(Integer.valueOf(e[0]));
        employeeToDepartment.put(Integer.valueOf(e[0]),e[2]);
    }
}
    public static void main(String[] args){
       String[] employees = new String[]{
               "1, Bill, Engineer",
               "2, Joe, HR",
               "3, Sally, Engineer",
               "4, Richard, Business",
               "6, Tom, Engineer"
       };

        String[] friendships = {
                "1, 2",
                "1, 3",
                "3, 4"
        };

       List<String>result =  friendCycle1(employees,friendships);
       List<String> result2 = friendCycle2(employees,friendships);
       for(String r : result2){
           System.out.println(r);
       }
    }
}
