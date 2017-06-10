package SegmentTree;

import SegmentTree.SegmentTreeNode;

/**
 * Created by xhu on 2/5/17.
 */

class SegmentTreeNode {
    public int start, end, sum;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
        this.sum = max;
    }
}

public class BuildSegmentTree {

    SegmentTreeNode root = null;

    BuildSegmentTree(int[] A) {
        root = build(A);
    }

    private SegmentTreeNode build(int[] A) {
        root = put(0, A.length - 1, A);
        return root;
    }

    private SegmentTreeNode put(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }


        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }


        SegmentTreeNode left = put(start, (start + end) / 2, A);
        SegmentTreeNode right = put((start + end) / 2 + 1, end, A);

        SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum + right.sum);

        root.left = left;
        root.right = right;


        return root;

    }

    public void updae(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (root == null) {
            return;
        }
        if(i>root.end) return;
        if(i< root.start) return;

        if (root.start == i && root.end == i) {
            root.sum = val;
            return;
        }

        int mid = (root.start + root.end) / 2;

        if (i <= mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }

        int left = root.left == null ? 0 : root.left.sum;
        int right = root.right == null ? 0 : root.right.sum;

        root.sum = left + right;


    }

    public int query(int start, int end) {
        // write your code here
        if (root == null) {
            return 0;
        }


        return queryHelper(root, start, end);
    }

    private int queryHelper(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        if(start< root.start) return 0;
        if(end>root.end) return 0;

        start = Math.max(start, root.start);
        end = Math.min(end, root.end);

        if(root.start == start && root.end == end) return root.sum;




        int mid = (root.start + root.end) / 2;

        if (end <= mid) {
            return queryHelper(root.left, start, end);
        } else if (start >= mid + 1) {
            return queryHelper(root.right, start, end);
        } else {

            return queryHelper(root.right, start, end) + queryHelper(root.left, start, end);
        }
    }
}
