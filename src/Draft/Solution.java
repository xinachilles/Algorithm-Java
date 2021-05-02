package Draft;


import java.util.*;

public class Solution {

    static class Company {

        Map<Integer, List<Integer>> managerMap = new HashMap<>();
        Map<Integer,Employee> employeeMap = new HashMap<>();
        Set<Integer> manager = new HashSet<>();

        public void add(int id, String name, int managerId) {
            Employee emp = new Employee(id, name, managerId);
            employeeMap.put(id,emp);
            managerMap.computeIfAbsent(managerId,x->new ArrayList<>()).add(id);

            if(manager.contains(id)){
                manager.remove(id);
            }
            if(managerId == -1){
                manager.add(id);
            }
        }

        public void remove(int id) {
            if(!employeeMap.containsKey(id)) return;
            if(manager.contains(id)){
                manager.remove(id);
            }
            managerMap.get(employeeMap.get(id).managerId).remove(id);
            employeeMap.remove(id);
        }

        public void move(int id, int managerId) {

            int previous = employeeMap.get(id).managerId;
            managerMap.get(previous).remove(id);
            managerMap.computeIfAbsent(managerId,x->new ArrayList<>()).add(id);
        }

        public int count(int managerId) {
           int count = 0;
           if(!managerMap.containsKey(managerId)){
               return count;
           }
           for(Integer id: managerMap.get(managerId)){
               count++;
               count+= count(id);
           }
           return count;

        }



        public void print() {
            // print the manager first
            Set<Integer> visited = new HashSet<>();


            for(Integer m: manager){
               print(m,0,visited);
            }

            }




        private void print(int id, int numberOfspace, Set<Integer> visited){
           if(!employeeMap.containsKey(id) || visited.contains(id)) return;
            visited.add(id);

            String emptyString = "";
            for(int i = 0; i<numberOfspace;i++){
                emptyString = emptyString+" ";
            }
            System.out.println(emptyString + employeeMap.get(id).toString());
            if(!managerMap.containsKey(id)) return;

            for(int e: managerMap.get(id)){
                print(e,numberOfspace+1,visited);
            }
        }


    }

    static class Employee {
        int id;
        String name;
        int managerId;

        public Employee(int id, String name, int managerId) {
            super();
            this.id = id;
            this.name = name;
            this.managerId = managerId;
        }

        @Override
        public String toString() {
            return name + "[" + id + "]";
        }
    }

    public static void main(String[] args) {
        Company company = new Company();
    /*  company.add(1,"Sharilyn Gruber",-1);
        company.add(2,"Denice Mattice",1);

        company.add(3,"Lawana Futrell",-1);
        company.add(4,"Lissette Gorney",1);
        company.add(5,"Lan Puls",3);*/
        company.add(1,"Johnson Drye",-1);
        company.add(2,"Cristy Sprow",-1);
        company.add(3,"Natacha Seligman",-1);
        company.add(4,"Brittny Wicks",-1);
        company.add(5,"Crissy Carden",-1);
        company.add(6,"Maribel Lettieri",-1);
        company.add(7,"Patrice Seawood",-1);
        company.add(8,"Audrea Deshazo",-1);
        company.add(9,"Emely Skoglund",-1);
        company.add(10,"Krista Dugan",-1);
        company.add(11,"Marilu Foos",-1);
        company.add(12,"Cherilyn Brinegar",-1);
        company.add(13,"Linn Caroll",-1);
        company.add(14,"Sang Coffer",-1);
        company.add(15,"Hilma Mehan",-1);
        company.move(4,2);
        company.print();
    }





}


