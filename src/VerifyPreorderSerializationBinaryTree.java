/**
 * Created by xhu on 2/26/17.
 */
public class VerifyPreorderSerializationBinaryTree {
    //vertify preorder serialize

    public boolean isValidSerializatio(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        String[] values = preorder.split(",");

        int indegree = 0;

        for (int i = 0; i < values.length; i++) {
            if (indegree > 0) {
                return false;
            }
            if (i == 0) {
                indegree = indegree - 2;
            } else if (!values[i].equals("#")) {
                indegree--;
            } else {
                indegree++;
            }
        }

        return indegree == 0;
    }
}
