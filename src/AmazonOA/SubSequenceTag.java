package AmazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubSequenceTag {
    public List<Integer> subSequenceTags(List<String> targetList, List<String> avaliableTagList) {

        if (targetList == null || avaliableTagList == null) {

            return null;
        }


        Map<String, Integer> targetHash = new HashMap<>();


        for (String t : targetList) {

            targetHash.put(t.toLowerCase(), 1);
        }


        int left = 0;

        int right = 0;

        int count = targetHash.size();

        List<Integer> result = new ArrayList<>();

        result.add(0);

        int min = Integer.MAX_VALUE;


        for (; right < avaliableTagList.size(); right++){

            String strRight = avaliableTagList.get(right).toLowerCase();

            if (targetHash.containsKey(strRight)){

                targetHash.put(strRight, targetHash.get(strRight) - 1);

                if (targetHash.get(strRight) == 0){

                    count--;
                }

            }
            while (count == 0){
                if (right - left + 1 < min){

                    min = right - left + 1;

                    result.clear();

                    result.add(left);

                    result.add(right);

                }


                String strLeft = avaliableTagList.get(left).toLowerCase();


                if (targetHash.containsKey(strLeft)){

                    targetHash.put(strLeft, targetHash.get(strLeft) + 1);

                    if (targetHash.get(strLeft) > 0) {

                        count++;

                    }

                }


                left++;

            }

        }


        return result;

    }
}
