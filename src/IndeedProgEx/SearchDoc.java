package IndeedProgEx;

import IndeedOnsite.NormalizedTitle;

import java.util.*;

public class SearchDoc {

    /*给一个doc（空格隔开的词），用户搜索关键词组，比如exotic dancer seattle，如果一个doc里同时出现了这三个词，匹配度为3，选出匹配度最高的几个doc，返回doc id，后面的几个test case和程序性能有关，感觉很好过，HR说很久没人test case全过了，心想HR还挺会说话*/
   /*
   * HackerRank上做的是给定一堆document和一堆query，返回每个query的top10 documents，按match降序，如果有tie就按doc id升序。如果有个query term出现在某个doc里就算一次match，同一个term出现多次只算一个。
   * */
    public  List<Integer> search(String[] docs, String query){
        // get the score for each doc -- normailized title
        // bucket sort return the top 10...

       String[] queryArray = query.split(" ");
       // we assume the max scoure should be queryArray.length
       List<Integer>[] bucket = new ArrayList[queryArray.length+1];

        for(int i = 0; i<docs.length; i++){
          String[] docArray = docs[i].split(" ");

          int score = getScoreWithoutSequence(queryArray,docArray);
          bucket[score].add(i);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length-1; i>=0;i--){
            for(int id: bucket[i]){
                result.add(id);
                if(result.size() == 10){
                    return result;
                }
            }
        }
        return result;
    }

    private int getScoreWithoutSequence(String[]query, String[] doc){
        Set<String> set = new HashSet<>(Arrays.asList(query));
        int score = 0;
        for(String d : doc){
            if(set.contains(d)){
                set.remove(d);
                score++;
            }
        }
        return score;
    }
}
