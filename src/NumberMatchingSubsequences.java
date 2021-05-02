import java.util.*;

public class NumberMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        Map<Character, List<Integer>> indexOfchars = new HashMap<>();
        for(int i = 0; i<S.length();i++){
            indexOfchars.computeIfAbsent(S.charAt(i),k->new ArrayList<>()).add(i);
        }

        for(String word: words){

            if(set.contains(word) || isSubsequence(word,indexOfchars)){
                count++;
                if(!set.contains(word)){
                    set.add(word);
                }
            }

        }

        return count;
    }

    public boolean isSubsequence(String word,Map<Character, List<Integer>> indexOfchars) {

        int previous = -1;
        for(int i = 0; i<word.length();i++){
            // find the smallest index great than previous index
            if(indexOfchars.containsKey(word.charAt(i))){
                previous = binarySearch(indexOfchars.get(word.charAt(i)),previous);
                if(previous == -1) return false;
            }else{
                return false;
            }
        }
        return true;
    }

    private int binarySearch(List<Integer> list,int target){
        int begin = 0;
        int end = list.size()-1;
        while (begin+1 <end){
            int mid = begin+ (end-begin)/2;
            if(list.get(mid)<=target){
                begin = mid;
            }else{
                end = mid;
            }

        }

        if(list.get(begin)>target){
            return list.get(begin);
        }

        if(list.get(end)>target){
            return list.get(end);
        }
        return -1;
    }
}
