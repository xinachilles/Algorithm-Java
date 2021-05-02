package AmazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendedMenue {
    public String[][] RecommendedMenue(String[][] menu, String[][] personPreferences)
    {
        if (menu == null || personPreferences == null)
        {

            return null;
        }

        Map<String, List<String>> maps = new HashMap<>();

        for (String[] m : menu)
        {

            if (m.length != 2)
            {

                continue;

            }



            String dish = m[0];
            String category = m[1];



            if (!maps.containsKey(category))
            {

                maps.put(category, new ArrayList<String>());
            }
            maps.get(category).add(dish);
        }

        List<String[]> list = new ArrayList<>();

        for (String[] p : personPreferences)
        {

            if (p.length != 2)
            {

                continue;

            }

            String person = p[0];
            String preferences = p[1];

            if (p[1].equals("*"))
            {
                for (String keys : maps.keySet())
                {
                    for (String dish : maps.get(keys))
                    {
                        String[] temp = new String[2];

                        temp[0] = person;
                        temp[1] = dish;
                        list.add(temp);
                    }
                }
            }else {

                for (String dish : maps.get(preferences))
                {

                    String[] temp = new String[2];

                    temp[0] = person;
                    temp[1] = dish;
                    list.add(temp);
                }
            }
        }




        String[][] result = new String[list.size()][];

        return list.toArray(result);

    }





}
