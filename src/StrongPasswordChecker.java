import java.util.*;

/**
 * Created by xhu on 2/27/17.
 */
public class StrongPasswordChecker {

    public int strongPasswordChecker(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Queue<String> visiting = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        visiting.offer(s);
        int count = 0;

        while (!visiting.isEmpty()){
            int size = visiting.size();

            for(int i = 0; i<size;i++){
                String current = visiting.poll();
                if(isValid(current)){
                    return count;
                }

                replace(new StringBuilder(current),visiting,visited);
                if(s.length()>6){
                    delete(new StringBuilder(current),visiting,visited);
                }

                if(s.length()<20){
                    insert(new StringBuilder(current),visiting,visited);
                }
            }

            count++;
        }

        return Integer.MAX_VALUE;
    }

    private boolean isValid(String s){
        if(s == null || s.length() < 6 || s.length()>20){
            return false;
        }

        boolean containsLowCase = false;
        boolean containsUpperCase = false;
        boolean containsDigits =false;
        boolean containsRepeating = false;

        for(int i = 0; i<s.length();i++){
           if(!containsDigits && Character.isDigit(s.charAt(i))){
               containsDigits = true;
            }else if(!containsLowCase && Character.isLowerCase(s.charAt(i))){
               containsLowCase = true;
           }else if(!containsUpperCase && Character.isUpperCase(s.charAt(i))){
               containsUpperCase = true;
           }

           if(i<=s.length()-3 && !containsRepeating){
                if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)){
                    containsRepeating = true;
                }
           }

        }

        return containsLowCase && containsUpperCase && containsDigits && !containsRepeating;
    }

    private void  insert(StringBuilder s, Queue<String> visiting,Set<String> visited){
        for(int i = 0; i<s.length(); i++){

            for(char c1 = 'a'; c1<='z';c1++){
               String s1 =  s.insert(i,c1).toString();
               if(!visited.contains(s1)){
                   visiting.add(s1);
               }

            }

            for(char c2 = 'A'; c2<='Z';c2++){

                String s2 =  s.insert(i,c2).toString();
                if(!visited.contains(s2)){
                    visiting.add(s2);
                }
            }

            for(char c3 = '1';c3<='9';c3++){
                String s3 =  s.insert(i,c3).toString();
                if(!visited.contains(s3)){
                    visiting.add(s3);
                }
            }
        }
    }

    private void  delete(StringBuilder s, Queue<String> visiting,Set<String> visited ){
        for(int i = 0; i<s.length(); i++){
            String s1= s.deleteCharAt(i).toString();
            if(!visited.contains(s1)){
                visiting.offer(s1);

            }

        }
    }

    private void replace(StringBuilder s, Queue<String> visiting,Set<String> visited){
        for(int i = 0; i<s.length(); i++){

            for(char c1 = 'a'; c1<='z';c1++){
                StringBuilder s1 = new StringBuilder(s);
                s1.setCharAt(i,c1);
                if(visited.contains(s1.toString())){
                    visiting.offer(s1.toString());
                }

            }

            for(char c2 = 'A'; c2<='Z';c2++){
                StringBuilder s2 = new StringBuilder(s);
                s2.setCharAt(i,c2);
                if(visited.contains(s2.toString())){
                    visiting.offer(s2.toString());
                }
            }

            for(char c3 = '1';c3<='9';c3++){
                StringBuilder s3 = new StringBuilder(s);
                s3.setCharAt(i,c3);
                if(visited.contains(s3.toString())){
                    visiting.offer(s3.toString());
                }
            }
        }
    }
}
