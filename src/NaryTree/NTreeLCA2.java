package NaryTree;

import java.util.ArrayList;
import java.util.List;

public class NTreeLCA2 {

    public NTreeNode findCommonLCA(NTreeNode root, NTreeNode nodeA, NTreeNode nodeB) {

        List<NTreeNode> pathesForA = new ArrayList<>();
        List<NTreeNode> pathesForB = new ArrayList<>();


        if (!findCommonLCAHelper(root, nodeA, pathesForA) || !findCommonLCAHelper(root, nodeB, pathesForB)) {

            return null;

        }


        int indexA = pathesForA.size() - 1;

        int indexB = pathesForB.size() - 1;


        if (pathesForA.size() > pathesForB.size()) {

            indexA = pathesForA.size() - 1 - (pathesForA.size() - pathesForB.size());

        }


        if (pathesForB.size() > pathesForA.size()) {

            indexB = pathesForB.size() - 1 - (pathesForB.size() - pathesForA.size());

        }


        while (indexA >= 0 && indexB >= 0) {

            if (pathesForA.get(indexA) == pathesForB.get(indexB)) {

                return pathesForA.get(indexA);
            }


            indexA--;
            indexB--;

        }


        return null;

    }

    private boolean findCommonLCAHelper(NTreeNode root, NTreeNode node, List<NTreeNode> pathes) {

        if (root == null) {

            return false;

        }


        if (root.compareTo(node) == 0) {

            pathes.add(node);

            return true;


        }


        for(NTreeNode c : root.children) {

            pathes.add(root);

            if (findCommonLCAHelper(c, node, pathes)) {

                return true;

            }


            pathes.remove(pathes.size() - 1);

        }


        return false;


    }
}
