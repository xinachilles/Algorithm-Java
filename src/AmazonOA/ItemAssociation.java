package AmazonOA;

import java.util.*;

public class ItemAssociation {
    class UnionFind {
        public Map<String, String> itemToParents;

        public UnionFind(Set<String> items) {
            itemToParents = new HashMap<>();
            for (String item : items) {
                itemToParents.put(item, item);
            }
        }

        public void union(String s1, String s2) {

            String parent1 = find(s1);
            String parent2 = find(s2);
            itemToParents.put(parent1, parent2);
        }

        public String find(String s) {

            String ans = s;
            while (!ans.equals(itemToParents.get(ans))) {
                ans = itemToParents.get(ans);
            }

            while (!s.equals(itemToParents.get(s))) {

                String temp = itemToParents.get(s);
                itemToParents.put(s, ans);
                s = temp;
            }
            return ans;
        }
    }


    class ListComparer implements Comparator<List<String>> {
        @Override
        public int compare(List<String> a, List<String> b)

        {

            if (a.size() == b.size()) {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i).compareTo(b.get(i));
                    }
                }
            } else {

                return b.size() - a.size();
            }
            return 0;
        }
    }


    public String[] ItemAssociation(String[][] ItemAssociation)

    {

        if (ItemAssociation == null || ItemAssociation.length == 0) {

            return null;
        }
        Set<String> set = new HashSet<String>();

        for (String[] s : ItemAssociation) {

            for (String s1 : s) {

                if (!set.contains(s1)) {

                    set.add(s1);

                }
            }
        }

        UnionFind union = new UnionFind(set);
        for (String[] s : ItemAssociation) {

            String s1 = s[0];
            for (int i = 1; i < s.length; i++) {
                String s2 = s[i];
                if (!union.find(s1).equals(union.find(s2))) {

                    union.union(s1, s2);
                }
            }
        }


        Map<String, List<String>> parentsToItem = new HashMap<>();

        for(String item : set)
        {
            String parent = union.find(item);
            if (!parentsToItem.containsKey(parent))
            {

                parentsToItem.put(parent, new ArrayList<String>());

            }


            parentsToItem.get(parent).add(item);
        }


        List<List<String>> values = new ArrayList<>();

        for(String key : parentsToItem.keySet())
        {
            Collections.sort(parentsToItem.get(key));
            values.add(parentsToItem.get(key));

        }


        Collections.sort(values,new ListComparer());

        String[] result = new String[values.get(0).size()];

        return values.get(0).toArray(result);

    }


}
