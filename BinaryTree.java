package SelfPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;
    int depth = Integer.MAX_VALUE;
    int lsum =0;

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void preOrder(BinaryTree rootNode) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree tempNode = rootNode;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                System.out.print(tempNode.value + ", ");
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            tempNode = tempNode.right;

        }
    }

    public void inOrder(BinaryTree rootNode) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree tempNode = rootNode;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            System.out.print(tempNode.value + ", ");
            tempNode = tempNode.right;

        }
    }

    public void postOrder(BinaryTree rootNode) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree tempNode = rootNode;
        BinaryTree previousNode = null;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.peek();
            if (tempNode.right == null || tempNode.right == previousNode) {
                System.out.print(tempNode.value + ", ");
                stack.pop();
                previousNode = tempNode;
                tempNode = null;
            } else {
                tempNode = tempNode.right;
            }

        }
    }

    public void levelOrder(BinaryTree rootNode) {
        Queue<BinaryTree> q = new LinkedList<>();
        BinaryTree tempNode = rootNode;
        if (tempNode != null) {
            q.add(tempNode);
            q.add(null);
        }
        while (!q.isEmpty()) {
            tempNode = q.remove();
            if (tempNode == null) {
                if (q.isEmpty()) {
                    return;
                } else {
                    q.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(tempNode.value + ", ");
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    q.add(tempNode.right);
                }

            }
        }
    }

    public void depthFirst(BinaryTree rootNode) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree tempNode = rootNode;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.add(tempNode);
                System.out.print(tempNode.value + ", ");
                if (tempNode.right != null) {
                    tempNode = tempNode.right;
                } else tempNode = null;
            }
            tempNode = stack.pop();
            tempNode = tempNode.left;

        }

    }

    public void leftView(BinaryTree rootNode) {
        Queue<BinaryTree> q = new LinkedList<>();
        BinaryTree tempNode = rootNode;
        if (tempNode != null) {
            q.add(tempNode);
            q.add(null);
            System.out.print(tempNode.value + ", ");
        }
        while (!q.isEmpty()) {
            tempNode = q.remove();
            if (tempNode == null) {
                if (q.isEmpty()) {
                    return;
                } else {
                    q.add(null);
                    tempNode = q.peek();
                    System.out.print(tempNode.value + ", ");
                }
            } else {
                //System.out.print(tempNode.value);
                if (tempNode.left != null)
                    q.add(tempNode.left);
                if (tempNode.right != null)
                    q.add(tempNode.right);
            }
        }

    }

    public void rightView(BinaryTree rootNode) {
        BinaryTree tempNode = rootNode;
        Queue<BinaryTree> q = new LinkedList();
        if (tempNode != null) {
            System.out.print(tempNode.value + ", ");
            q.add(tempNode);
            q.add(null);
        }
        while (!q.isEmpty()) {
            tempNode = q.remove();
            if (tempNode == null) {
                if (q.isEmpty()) {
                    return;
                } else {
                    q.add(null);
                    tempNode = q.peek();
                    System.out.print(tempNode.value + ", ");
                }
            } else {
                if (tempNode.right != null) {
                    q.add(tempNode.right);
                }
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                }
            }
        }
    }

    public void zigzagView(BinaryTree rootNode) {
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        BinaryTree tempNode = rootNode;
        if (tempNode != null) {
            System.out.println(tempNode.value + ", ");
            if (tempNode.left != null) {
                stack1.push(tempNode.left);
            }
            if (tempNode.right != null) {
                stack1.push(tempNode.right);
            }
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                tempNode = stack1.pop();
                System.out.print(tempNode.value + ", ");
                if (tempNode.right != null) {
                    stack2.push(tempNode.right);
                }
                if (tempNode.left != null) {
                    stack2.push(tempNode.left);
                }
            }
            System.out.println();
            while (!stack2.isEmpty()) {
                tempNode = stack2.pop();
                System.out.print(tempNode.value + ", ");
                if (tempNode.left != null) {
                    stack1.push(tempNode.left);
                }
                if (tempNode.right != null) {
                    stack1.push(tempNode.right);
                }
            }
            System.out.println();
        }
    }

    public void sizeofTree(BinaryTree rootNode) {
        int size = 0;
        size = subTreeSize(rootNode.left) + 1 + subTreeSize(rootNode.right);
        System.out.println("Size of Node " + rootNode.value + " is : " + size);

    }

    int subTreeSize(BinaryTree rootnode) {
        int l, r = 0;
        if (rootnode == null) {
            return 0;
        }
        l = subTreeSize(rootnode.left);
        r = subTreeSize(rootnode.right);
        return l + r + 1;

    }

    public void heightofTree(BinaryTree rootNode) {
        int height = 0;
        height = Math.max(subTreeHeight(rootNode.left), subTreeHeight(rootNode.right));
        System.out.println("Height of the tree is : " + height);
    }

    int subTreeHeight(BinaryTree rootnode) {
        int l, r = 0;
        if (rootnode == null) {
            return 0;
        }
        l = subTreeHeight(rootnode.left);
        r = subTreeHeight(rootnode.right);
        System.out.println("l=" + l);
        System.out.println("r=" + r);
        int max = Math.max(l, r);
        return max + 1;
    }

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

    public void sumLLeaves(BinaryTree rootnode){
        if(rootnode == null){
            return;
        }
        if(rootnode.left == null && rootnode.right == null){
            System.out.println("1.Sum:"+lsum);
            return ;
        }
        subTreeSum(rootnode,false);
        System.out.println("Sum:"+lsum);
    }
    void subTreeSum(BinaryTree rootnode, boolean flag) {
        if (rootnode == null) {
            return ;
        }
        if (rootnode.left == null & rootnode.right == null && flag) {
            lsum += rootnode.value;
        }
        subTreeSum(rootnode.left,true);
        subTreeSum(rootnode.right, false);
    }

    public void sumOfLeftLeaves(BinaryTree rootNode) {
        BinaryTree tempNode = rootNode;
        BinaryTree previousNode;
        int sum = 0;
        Stack<BinaryTree> stack = new Stack<>();
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            // if(tempNode.left == null && tempNode.right==null ){
            //  sum+=tempNode.value;
            //}
            if (tempNode.left != null && tempNode.right == null) {
                previousNode = tempNode.left;
                if (previousNode.left == null && previousNode.right == null) {
                    sum += previousNode.value;
                }
            }
            tempNode = tempNode.right;
        }
        System.out.println("Sum of all Left Leaves is : " + sum);
    }

    public void miniDepth(BinaryTree rootNode) {
        int i = 1;
        subTreeDepth(rootNode, i);
        System.out.println("Minimum depth of the tree : " + depth);
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

    public void balanceTree(BinaryTree rootNode) {
        int result;
        result = subTreeBalance(rootNode);
        if (result == -1) {
            System.out.println("The tree is not balanced." + result);
        } else {
            System.out.println("The tree is balanced." + result);
        }
    }

    int subTreeBalance(BinaryTree rootnode) {
        int res = 0;
        int l, r, h = 0;
        if (rootnode == null) {
            return 0;
        }
        l = subTreeBalance(rootnode.left);
        r = subTreeBalance(rootnode.right);
        if (l == -1 || r == -1) {
            return -1;
        }
        res = Math.abs(l - r);
        if (res > 1) {
            return -1;
        }
        return (Math.max(l, r) + 1);
    }


}

