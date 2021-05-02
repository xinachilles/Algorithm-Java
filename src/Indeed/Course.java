package Indeed;

import java.util.*;

public class Course {
    /*
    * You are a developer for a university.
    * Your current project is to develop a system for students to find courses they share with friends.
    *  The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.
Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.
    * */
   Map<String,List<String>> courseOverlaps(List<String[]>studentCoursePair) {
        Map<String, Set<String>> studentsToCourse = new HashMap<>();
        for(String[] students : studentCoursePair){
            String id = students[0];
            String course = students[1];
            studentsToCourse.computeIfAbsent(id,a->new HashSet<>()).add(course);
        }
        List<String> students = new ArrayList<>();
        students.addAll(studentsToCourse.keySet());
        Map<String,List<String>> result = new HashMap<>();

        for(int i =0; i<students.size()-1;i++){
            for(int j = i+1;j<students.size();j++){
                String key = students.get(i)+students.get(j);
                List<String> overLap = new ArrayList<>();
                for(String s1: studentsToCourse.get(students.get(i))){
                    for(String s2:studentsToCourse.get(students.get(j))){
                        if(s1.equals(s2)){
                            overLap.add(s1);
                        }
                    }
                }
                result.put(key,new ArrayList<>(overLap));
            }
        }
                return result;

    }

    /*
Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum.
There may be more than one track that includes the same course, but each student follows a single linear track from a "root" node to a "leaf" node.
In the graph below, their path always moves left to right.

Write a function that takes a list of (source, destination) pairs,
and returns the name of all of the courses that the students could be taking when they are halfway
through their track of courses.

Sample input:
all_courses = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output (in any order):
          ["Data Structures", "Creative Writing", "Databases", "Intro to Computer Science"]

All paths through the curriculum (midpoint *highlighted*):

*Intro to C.S.* -> Graphics
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________
                    |          |
                    | Graphics |
               ---->|__________|
               |                          ______________
____________   |                          |            |
|          |   |    ______________     -->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Complexity analysis variables:

n: number of pairs in the input

*/

   public List<String>findAllMidway(List<String[]>courses){
        Map<String, List<String>> graph = new HashMap<>();

        Map<String,Integer> degree = new HashMap<>();
        for(String[] course: courses){
            String source = course[0];
            String destination = course[1];

            graph.computeIfAbsent(source,a->new ArrayList<>()).add(destination);
            degree.put(destination,degree.getOrDefault(destination,0)+1);
        }
        Queue<String> visiting = new LinkedList<>();
        // find all start course
        for(String key: degree.keySet()){
            if(degree.get(key) == 0){
                visiting.offer(key);
            }
        }
        List<String> result = new ArrayList<>();
        while(!visiting.isEmpty()){
            String course = visiting.poll();
            for(String neighbor: graph.get(course)){
                if(!graph.containsKey(neighbor)|| graph.get(neighbor).size()==0){
                    result.add(course);
                }else{
                    result.add(neighbor);
                }
            }
        }
        return result;
    }

}
