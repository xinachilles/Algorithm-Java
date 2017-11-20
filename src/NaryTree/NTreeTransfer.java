package NaryTree;

import NaryTree.NTreeNode;

import java.util.*;

/**
 * Created by xhu on 6/6/17.
 */
public class NTreeTransfer {
    public NTreeNode Transfer(NTreeNode node, int k){
        List<NTreeNode> visted  = new ArrayList<>();
        Queue<NTreeNode> toVisted = new LinkedList<>();
        toVisted.offer(node);

        while(!toVisted.isEmpty()){
            int size = toVisted.size();

            for(int i = 0; i<size; i++){
                NTreeNode current = toVisted.poll();
                visted.add(current);

                for(NTreeNode c:current.children){
                    toVisted.offer(c);
                }
            }
        }

        // thransfer to complete N tree
        int length = 1;
        NTreeNode root = new NTreeNode(visted.get(0).vaule);
        toVisted.offer(root);
        while(length< visted.size()){
            NTreeNode current = toVisted.poll();
            for(int i = 0;i<k;i++){
                if(length>=visted.size()){
                    return root;
                }

                NTreeNode child = new NTreeNode(visted.get(length).vaule);
                current.children.add(child);
                toVisted.offer(child);

                length++;

            }
        }

        return root;
    }
}
