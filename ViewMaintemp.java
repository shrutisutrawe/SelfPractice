package SelfPractice;

import INFO6205.Assignment_1.BinaryTree;

public class ViewMaintemp {
        public static void main (String args[]) {
            BinaryTree node7 = new BinaryTree(7,null,null);
            BinaryTree node8 = new BinaryTree(8,node7,null);
           BinaryTree node4 = new BinaryTree(4,node8,null);
//            BinaryTree node6 = new BinaryTree(6,node8,node7);
//            BinaryTree node5 = new BinaryTree(5,node6,null) ;
//            BinaryTree node3 = new BinaryTree(3,null,node5);
            BinaryTree node2 = new BinaryTree(2,node4,null);
            BinaryTree node1 = new BinaryTree(1,node2,null);

            //node1.preOrder(node1);
            node1.leafNodes(node1);
            //node1.inOrder(node1);
            //node1.postOrder(node1);
            //   node1.levelOrder(node1);
            // node1.depthFirst(node1);
            //node1.leftView(node1);
            //node1.rightView(node1);
            node1.isBalanced(node1);
            //node1.sumLLeaves(node1);
            node1.sumOfLeftLeaves(node1);
            node1.minDepth(node1);
        }
    }


