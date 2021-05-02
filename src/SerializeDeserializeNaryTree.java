import java.util.*;

public class SerializeDeserializeNaryTree {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public String serialize(Node root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(result,root);
        return result.toString().substring(0,result.length()-1);

    }

    private void serializeHelper(StringBuilder result, Node root){
        if(root == null){
            return;
        }

        result.append(String.valueOf(root.val));
        result.append(",");
        result.append(String.valueOf(root.children.size()));

        for(Node node : root.children){
            serializeHelper(result,root);
        }





    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] ss = data.split(",");
        Queue<String> q=new LinkedList<>(Arrays.asList(ss));
        return deserializeHelper(q);
    }

    private  Node deserializeHelper( Queue<String> q){

        Node root = new Node();
        root.val = Integer.parseInt(q.poll());

        int size = Integer.parseInt(q.poll());
        root.children = new ArrayList<>();
        for(int i = 0; i<size; i++){
            root.children.add(deserializeHelper(q));

        }

        return root;


    }
}
