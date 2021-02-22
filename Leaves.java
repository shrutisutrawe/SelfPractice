package SelfPractice;

import INFO6205.Assignment_1.BinaryTree;

import java.util.Stack;

class Leaves {
    public void leafNodes(BinaryTree rootNode) {
        BinaryTree tempNode = rootNode;
        Stack<BinaryTree> stack = new Stack<>();
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            if (tempNode.left == null && tempNode.right == null) {
                System.out.print(tempNode.value + ", ");
            }
            tempNode = tempNode.right;
        }
    }
}