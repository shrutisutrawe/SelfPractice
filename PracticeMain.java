package SelfPractice;

import INFO6205.Assignment_1.BinaryTree;

public class PracticeMain {
    public static void main (String args[]) {
        //BinaryTree node8 = new BinaryTree(8,null,null);
        BinaryTree node9 = new BinaryTree(9,null,null);
        BinaryTree node10 = new BinaryTree(10,null,null);
        BinaryTree node12 = new BinaryTree(12,null,null);
        BinaryTree node11 = new BinaryTree(11,node12,null);
        BinaryTree node5 = new BinaryTree(5,node9,null);
        BinaryTree node6 = new BinaryTree(6,null,node10);
        BinaryTree node4 = new BinaryTree(4,null,null);
        BinaryTree node7 = new BinaryTree(7,node11,null) ;
        BinaryTree node2 = new BinaryTree(2,node4,node5);
        BinaryTree node3 = new BinaryTree(3,node6,node7);
        BinaryTree node1 = new BinaryTree(1,node2,node3);

        //node1.preOrder(node1);
        //node1.inOrder(node1);
        //node1.postOrder(node1);
        //   node1.levelOrder(node1);
       // node1.depthFirst(node1);
        //node1.leftView(node1);
        //node1.zigzagView(node1);
        //node1.sizeofTree(node8);
        //node1.heightofTree(node1);
        //node1.leafNodes(node1);
        //node1.sumOfLeftLeaves(node1);
        //node1.miniDepth(node1);
        //node1.heightofTree(node1);
        //node1.balanceTree(node1);
//        node1.miniDepth(node1);
//        node1.sumLLeaves(node1);
//        node1.sumOfLeftLeaves(node1);
    }
}
