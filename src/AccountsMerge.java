import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AccountsMerge {

    private  class UnionFind{
       int[]  parents  = null;
        public  UnionFind(int size){
            parents = new int[size];

            for(int i = 0; i<size; i++){
                parents[i] = i;
            }
        }

        public int Find(int n){
            while (n != parents[n]){
                n = parents[n];
            }

            return parents[n];
        }

        public void Union(int a, int b){
            int parentA = Find(a);
            int parentB = Find(b);

            parents[parentA] = parentB;
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        if(accounts == null || accounts.size() == 0){
            return null;
        }

        HashMap<String, String > emailsToName = new HashMap<>();
        HashMap<String, Integer> emailsToID = new HashMap<>();
        UnionFind un = new UnionFind(10001);

        int id = 0;
        for(List<String> account :accounts){
            String name = "";
            for(String a : account){
                if(name == ""){
                    name = a;
                    continue;
                }

                if(!emailsToName.containsKey(a)){
                    emailsToName.put(a,name);
                }

                if(!emailsToID.containsKey(a)){
                    emailsToID.put(a,id++);
                }

                un.Union(emailsToID.get(account.get(1)),emailsToID.get(a)) ;
            }
        }

        HashMap<Integer, List<String>> ans = new HashMap<>();
        for(String email : emailsToID.keySet()){
            int index = un.Find(emailsToID.get(email) );
            if(ans.containsKey(index)){
                ans.get(index).add(email);
            }else{
                ans.put(index, new ArrayList<>());
            }
        }

        for(List<String> compoents : ans.values()){
            Collections.sort(compoents);
            compoents.add(0, emailsToName.get(compoents.get(0)));

        }
        return new ArrayList<>(ans.values());



    }

    public static class LongestPalindromicSubsequence {
    }
}
