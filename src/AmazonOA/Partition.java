package AmazonOA;

import java.util.*;

public class Partition {
    public List<Integer> partition(List<Character> chars)
    {

        List<Integer> result = new ArrayList<>();

        if (chars == null || chars.size() == 0)
        {

            return result;
        }


        Map<Character, Integer> counts = new HashMap<>();
        for( char c : chars)
        {
            counts.put(c, counts.getOrDefault(c,0 )+1);
        }


        for (int i = 0; i < chars.size(); i++)
        {
            Set<Character> sets = new HashSet<>();

            int targetLength = 0;
            int j = i;

            for (; j < chars.size(); j++)
            {

                if (!sets.contains(chars.get(j)))
                {

                    sets.add(chars.get(j));
                    targetLength += counts.get(chars.get(j));
                }
                if (j - i + 1 == targetLength)
                {

                    result.add(j - i + 1);
                    break;
                }
            }
            i = j;
        }
        return result;
    }
}
