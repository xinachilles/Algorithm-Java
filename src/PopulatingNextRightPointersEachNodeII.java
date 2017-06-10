/**
 * Created by xhu on 10/9/16.
 */


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class PopulatingNextRightPointersEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode head = null;
        TreeLinkNode previous = null;

        TreeLinkNode current = root;
        while (current != null) {
            while (current != null) {

                if (current.left != null) {
                    if (previous == null) {
                        head = current.left;
                    } else {
                        previous.next = current.left;
                    }
                    previous = current.left;
                }


                if (current.right != null) {

                    if (previous != null) {
                        previous.next = current.right;
                    } else {
                        head = current.right;
                    }

                    previous = current.right;
                }

                current = current.next;
            }
                current = head;
                head = null;
                previous = null;
            }
        }
    }
