package NaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 6/23/17.
 */
public class Codec {

    final char endMarker  = ')';
    int index = 0;
    public String serialize(NTreeNode root){
        if( root == null){
            return "";
        }

        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.toString();
    }

    private  void serializeHelper(NTreeNode root, StringBuilder result){

        if(root == null){
            result.append(endMarker);
        }

        result.append(String.valueOf(root.vaule));
        if(root.children == null || root.children.size() == 0){
            result.append(endMarker);
        }else {
            for (NTreeNode n : root.children) {
                serializeHelper(n, result);
            }

            result.append(endMarker);
        }
    }

    public NTreeNode deserialize(String code){
        if(code == null || code.length() == 0){
            return null;
        }

        NTreeNode root = deserializeHelper(code);
        return root;
    }


    private NTreeNode deserializeHelper(String code){
        if(index >= code.length() ){
            return null;
        }

        if(code.charAt(index) == endMarker){
            return null;
        }

        NTreeNode root = new NTreeNode(Character.getNumericValue(code.charAt(index)));
        index++;

        for(int i = 0; i<code.length() && index<code.length(); i++){
            if(code.charAt(index) == endMarker){
                break;
            }

            root.children.add(deserializeHelper(code));
            index++;
        }

        return root;

    }
}
