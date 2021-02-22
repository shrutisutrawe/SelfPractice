package SelfPractice;

import INFO6205.Assignment_1.BinaryTree;

class MinDepth {
    int depth = Integer.MAX_VALUE;

    public int minDepth(BinaryTree root) {
        int i = 1;
        if (root == null) {
            return 0;
        }
        subTreeDepth(root, i);
        System.out.println("Minimum depth of the tree : " + depth);
        return depth;
    }

    void subTreeDepth(BinaryTree rootnode, int i) {
        if (rootnode == null) {
            return;
        }
        subTreeDepth(rootnode.left, i + 1);
        subTreeDepth(rootnode.right, i + 1);
        if (rootnode.left == null && rootnode.right == null) {
            depth = Math.min(depth, i);
        }
    }
}