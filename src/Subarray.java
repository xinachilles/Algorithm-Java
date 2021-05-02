import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

public class Subarray {


    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    // input the paragraph and keywords set
    // out put the indices of the starting and ending index of a shortest subarray of the given array that covers the set
    // base on the book, it is better use a class indcate the starting and ending index
    // the strage forward way is find all starting and ending index and first then figuare out the shortest subarray
    // if the there are n key words and the length of paragraph is m
    // the time complex will be n*m + l ( l will be all starting and ending index covers the keywords
    // another solution is using start point and end point,
    // 1. start point and end point point to the begining of paragrah first
    //  2. move the end point until cover all key words,
    // 3. then move the start point unitl find the first word in the keywords
    //  4. go the 2 again to find another subset over all key words

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph, Set<String> keywords) {
        if (paragraph == null || keywords == null) {
            return null;
        }

        int smallest = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        Subarray result = new Subarray(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Set<String> temp = new HashSet<String>(keywords);

        for (; end < paragraph.size(); end++) {
            String word = paragraph.get(end);
            if (keywords.contains(word)) {

                temp.remove(word);
            }

            while (temp.size() == 0) {
                if (end - start + 1 < smallest) {
                    result.start = start;
                    result.end = end;
                    smallest = end - start + 1;
                }

                start++;
                String startWord = paragraph.get(start);
                if (keywords.contains(startWord)) {
                    temp.add(startWord);
                }

            }


        }

        return result;


    }

// the problem for above solution is the key word in keywords could be appear more than once, so we need a hashtable to remember how many times
// the word in the keywords set
     public static Subarray findSmallestSubarrayCoveringSet2(List<String> paragraph, Set<String> keywords){
    if(paragraph == null || keywords == null){
        return null;
    }

   // int smallest = Integer.MAX_VALUE;

    Subarray result = new Subarray(-1,-1);
    Map<String , Integer> keywordsToCover = new HashMap<>();
    for(String keyword : keywords){
        keywordsToCover.put(keyword, keywordsToCover.containsKey(keyword) ? keywordsToCover.get(keyword) + 1
                : 1);
    }
    int remainingToCover = keywords.size();

    for(int left =0,right =0; right<paragraph.size();right ++){


        Integer keywordCount = keywordsToCover.get(paragraph.get(right));

        if(keywordCount != null){
            keywordsToCover.put(paragraph.get(right), --keywordCount);

            if (keywordCount >= 0) {
                --remainingToCover ;
            }

        }

        while (remainingToCover == 0) {
            if ((result.start == -1 && result.end == -1)
                    || right - left < result.end - result.start){
                result.start = left;
                result.end = right;
            }
            keywordCount = keywordsToCover.get(paragraph.get(left));
            if (keywordCount != null) {
                keywordsToCover.put(paragraph.get(left), ++keywordCount);

                if (keywordCount > 0) {
                    ++remainingToCover ;
                }
            }
            ++left ;
        }


    }

    return result;


}



}