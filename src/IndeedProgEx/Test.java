package IndeedProgEx;

import java.util.*;

public class Test {

    static Map<String, Set<Integer>> map = new HashMap<>();
    static int totalNumberOfDoc = 0;
    public static void storeDocument(final String document, final int documentNumber) {
        // TODO implement
        String[] array = document.split("\\s+");
        for(String a : array){
            map.computeIfAbsent(a,b->new HashSet<>()).add(documentNumber);
        }
        totalNumberOfDoc++;
    }

    public static String performSearch(final String search) {
        // TODO implement
        // it is for the score for the query
        System.out.println(search);
        String[] searchArray = search.split("\\s+");
        int[] score = new int[totalNumberOfDoc];

        for(String s: searchArray){
            if(map.containsKey(s)){
                for(int i : map.get(s)){
                    score[i]++;
                }
            }
        }
        Queue<Integer>[] bucket = new LinkedList[searchArray.length+1];

        for(int i = 0; i<score.length;i++){
            if(bucket[score[i]] == null){
                bucket[score[i]] = new LinkedList<>();
            }

            bucket[score[i]].add(i);
        }

        int total = 0;
        StringBuilder result = new StringBuilder();
        for(int i = bucket.length-1;i>=0;i--) {
            if(bucket[i] == null) continue;
            while(bucket[i] != null && !bucket[i].isEmpty()){
                result.append(String.valueOf(bucket[i].poll()));
                result.append(" ");
                total++;
                if(total == 10){
                    return result.substring(0,result.length()-1);
                }
            }
        }
        System.out.println(result);
        return result.toString();




    }



    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        storeDocument( "experienced software developer python",0);
        storeDocument( " experienced developer javascript css html react",1);
        storeDocument("technical recruiter junior software",2);

        performSearch("software");


    }
}
