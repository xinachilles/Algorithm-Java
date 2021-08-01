import java.util.*;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       Map<Long,Integer> ids = new HashMap<>();
       Map<Integer,Integer> counts = new HashMap<>();
       List<TreeNode> result = new ArrayList<>();
       getId(root,ids,counts,result);
       return result;

    }

    private int getId(TreeNode root,Map<Long,Integer>ids,Map<Integer,Integer> counts, List<TreeNode> result){
        if(root ==null){
            return 0;
        }
        long key = (long)root.val<<32 | +getId(root.left, ids,counts,result)<<32 | getId(root.right,ids,counts,result);
        if(!ids.containsKey(key)){
            ids.put(key,ids.keySet().size()+1);
        }
        int id = ids.get(key);

        counts.put(id,counts.getOrDefault(id,0)+1);

        if(counts.get(id) ==2){
            result.add(root);
        }
        return id;
    }



}
