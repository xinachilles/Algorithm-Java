import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountsMergeII {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        if (accounts == null || accounts.size() == 0) {
            return null;
        }

        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, String> emailsToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailsToName.put(email, name);
                if (!graph.containsKey(account.get(1))) {
                    graph.put(account.get(1), new ArrayList<>());
                }

                if (!email.equals(account.get(1))) {
                    graph.get(account.get(1)).add(email);
                }
            }
        }

    return null;
    }
}
