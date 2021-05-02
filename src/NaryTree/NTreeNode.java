package NaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 4/14/17.
 */
public class NTreeNode implements Comparable<NTreeNode> {
    Integer vaule;
    List<NTreeNode> children = new ArrayList<>();

    public NTreeNode(int value){
        this.vaule  = value;
    }

    @Override
    public int compareTo(NTreeNode o){
        return this.vaule.compareTo(o.vaule);
    }
}
