package AmazonOA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class SubStringKDist {
    public List<String> subStringKDist(String inputStr, int num) {

        List<String> result = new ArrayList<>();
        if (inputStr == null || inputStr.length() == 0 || inputStr.length() < num)

        {

            return result;

        }


        for (int i = 0; i <= inputStr.length() - num; i++) {
            String temp = inputStr.substring(i, i + num);

            // will need a menthod to determine if there is dulipcated chars
            HashSet<Character> sets = new HashSet<>();
            for (int j = 0; j < temp.length(); j++) {

                sets.add(temp.charAt(j));
            }
            // if set size equals to k, then add the sub string into result
            if (sets.size() == num && !result.contains(temp)) {
                result.add(temp);
            }
        }
        return result;

    }


}
