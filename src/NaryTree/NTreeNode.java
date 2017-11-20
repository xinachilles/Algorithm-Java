package NaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 4/14/17.
 */
public class NTreeNode {
    int vaule;
    List<NTreeNode> children = new ArrayList<>();

    public NTreeNode(int value){
        this.vaule  = value;
    }
}
