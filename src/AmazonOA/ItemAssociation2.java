package AmazonOA;

import java.util.*;

public class ItemAssociation2 {

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
        Map<String,List<String>> graph = new HashMap<>();

        for (String[] s : ItemAssociation) {

            for(int i =0; i<s.length;i++){

                if (!set.contains(s[i])) {

                    set.add(s[i]);
                }
                if(i<s.length-1){
                    String node = s[i];
                    String neighbor = s[i+1];

                    if(!graph.containsKey(node)){
                        graph.put(node,new ArrayList<String>());
                    }

                    if(!graph.containsKey(neighbor)){
                        graph.put(neighbor,new ArrayList<String>());
                    }


                    graph.get(node).add(neighbor);
                    graph.get(neighbor).add(node);

                }
            }
        }
        Set<String> vistied  = new HashSet<>();
        List<List<String>> values = new ArrayList<>();

        for(String s:set){
            if(!vistied.contains(s)){
                List<String> path = new ArrayList<>();
                DFS(graph,path,vistied,s);

                Collections.sort(path);
                values.add(path);
            }
        }


        Collections.sort(values,new ListComparer());

        String[] result = new String[values.get(0).size()];

        return values.get(0).toArray(result);

    }


    private void DFS( Map<String,List<String>> graph, List<String> path, Set<String> visited, String node){
        visited.add(node);

        if(graph.containsKey(node) && graph.get(node) != null){
            for(String n : graph.get(node)){
                if(!visited.contains(n)){
                    DFS(graph,path,visited,n);
                }
            }
        }

        path.add(node);
    }
}
