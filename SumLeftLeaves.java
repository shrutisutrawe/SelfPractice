package SelfPractice;

import INFO6205.Assignment_1.BinaryTree;

class SumLeftLeaves {
    int lsum = 0;

    public int sumOfLeftLeaves(BinaryTree root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            //System.out.println("1.Sum:"+lsum);
            return 0;
        }
        subTreeSum(root, false);
        //System.out.println("Sum:"+lsum);
        return lsum;
    }

    void subTreeSum(BinaryTree rootnode, boolean flag) {
        if (rootnode == null) {
            return;
        }
        if (rootnode.left == null & rootnode.right == null && flag) {
            lsum += rootnode.value;
        }
        subTreeSum(rootnode.left, true);
        subTreeSum(rootnode.right, false);
    }

}