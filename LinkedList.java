package SelfPractice;

public class LinkedList {
    public int data;
    public LinkedList next;

    public LinkedList() {
    }

    public LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedList addHead(int data, LinkedList head) {
        LinkedList node = new LinkedList(data);
        node.next = head;
        head = node;
        return head;
    }

    public LinkedList createList(int array[]) {
        LinkedList head = new LinkedList(array[0]);
        LinkedList tempNode = head;
        for (int i = 1; i < array.length; i++) {

            LinkedList node = new LinkedList(array[i]);
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        return head;
    }

    public void printList(LinkedList head) {
        LinkedList tempNode = new LinkedList();
        tempNode = head;
        while (tempNode != null) {
//        while(tempNode.next != tempNode){
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
        System.out.println("NULL");
    }

    public LinkedList addTail(int data, LinkedList head) {
        LinkedList node = new LinkedList(data);
        if (head == null) {
            head = node;
            return head;
        }
        LinkedList tempNode = new LinkedList();
        tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = node;
        return head;
    }

    public int sizeOfList(LinkedList head) {
        int count = 0;
        LinkedList tempNode = head;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }

    public LinkedList reverseList(LinkedList head) {
        LinkedList back = null;
        LinkedList front = new LinkedList();
        LinkedList middle = head;
        if (middle != null) {
            if (middle.next == null) {
                return middle;
            } else {
                front = middle.next;
            }
            while (front != null) {
                middle.next = back;
                back = middle;
                middle = front;
                front = front.next;

            }
            middle.next = back;
            head = middle;

        }
        return head;
    }

    public LinkedList findKTerm(LinkedList head, int k) {
        if (head == null) {
            return head;
        }
        LinkedList back = head;
        LinkedList front = head;
        int count = 0;
        while (count != k && front != null) {
            front = front.next;
            count++;
        }
        if (front == null && count != k) {
            return front;
        }
        while (front != null) {
            back = back.next;
            front = front.next;
        }
        return back;
    }

    public boolean isCycle(LinkedList head) {
        if (head == null || head.next == null) {
            return false;
        }
        LinkedList back = head;
        LinkedList front = head;
        while (front.next != null) {
            front = front.next;
            if (front.next == null) {
                return false;
            }
            back = back.next;
            front = front.next;
            if (front == back) {
                return true;
            }
        }
        return false;
    }

    public LinkedList swapNodesInPairs(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList tempNode1 = head;
        LinkedList tempNode2 = head.next;
        head = head.next;

        tempNode1.next = tempNode2.next;
        tempNode2.next = tempNode1;

        tempNode1.next = swapNodesInPairs(tempNode1.next);
        return head;
    }

    public void deleteNode(LinkedList node) {
        node.data = node.next.data;
        node.next = node.next.next;

    }

//    public LinkedList oddEvenList(LinkedList head){
//        if(head == null ||head.next == null){
//            return head;
//        }
//
//    }

    public LinkedList breakList(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList back = head;
        LinkedList front = head.next;
        while (front != null && front.next != null) {
            back = back.next;
            front = front.next;
            if (front.next != null) {
                front = front.next;
            } else {
                break;
            }
        }
        LinkedList secondHalf = back.next;
        back.next = null;
        return secondHalf;
    }

    public LinkedList oddEvenList(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList odd = head;
        LinkedList tempOdd = odd;
        LinkedList oddHead = tempOdd;
        LinkedList even = head.next;
        LinkedList tempEven = even;
        LinkedList evenHead = tempEven;

        while (even.next != null || odd.next != null) {
            tempOdd.next = null;
            if (even.next == null) {
                tempOdd.next = evenHead;
                break;

            }
            odd = even.next;
            tempOdd.next = odd;
            tempOdd = odd;
            tempEven.next = null;
            if (odd.next == null) {
                tempOdd.next = evenHead;
                break;
            }
            even = odd.next;
            tempEven.next = even;
            tempEven = even;

        }
        return oddHead;
    }

    public LinkedList[] splitListToParts(LinkedList head, int k) {
        LinkedList[] finalList = new LinkedList[k];
        if (head == null) {
            return finalList;

        }
        int count = 0;
        LinkedList back = head;
        LinkedList tempNode = back;

        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        tempNode = back;
        int N = count;
        count = 1;
        int subcount = N / k;
        int rem = N % k;
        int sc = 0;
        System.out.println("Total Nodes : " + N);
        for (int i = 0; i < finalList.length; i++) {
            LinkedList backhead = tempNode;
            back = tempNode;
            count = 1;
            if (N < k && sc + 1 <= k) {
//                System.out.println(back.next.data);
                if (back.next != null) {
                    tempNode = back.next;
                    back.next = null;
                    finalList[i] = backhead;
                } else if (i + 1 == N) {
                    finalList[i] = backhead;
                }
                sc++;
            }
            if (N >= k && rem != 0 && sc < rem) {
                while (((count % (subcount + 1) > 0) && back.next != null)) {
                    back = back.next;
                    count++;
                }
                tempNode = back.next;
                back.next = null;
                sc++;
                finalList[i] = backhead;
            } else if (N >= k && sc <= k) {
                while (count % subcount > 0 && back.next != null) {
                    back = back.next;
                    count++;
                }
                tempNode = back.next;
                back.next = null;
                sc++;
                finalList[i] = backhead;
            }
        }
        return finalList;
    }

    public boolean isPalindrome(LinkedList head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        LinkedList back = head;
        LinkedList front = head;
        while (front.next != null && front.next.next != null) {
            back = back.next;
            front = front.next;
            if (front.next != null) {
                front = front.next;
            }
        }
        LinkedList secondhalf = back.next;
        back.next = null;
        back = head;
        secondhalf = reverseList(secondhalf);
        LinkedList temp2 = secondhalf;
        while (back != null && temp2 != null) {
            if (back.data != temp2.data) {
                secondhalf = reverseList(secondhalf);
                printList(secondhalf);
                return false;
            }
            back = back.next;
            temp2 = temp2.next;
        }
        secondhalf = reverseList(secondhalf);
        printList(secondhalf);
        return true;
    }

    public LinkedList insertInCircularList(LinkedList head, int value) {
        if (head == null) {
            LinkedList tempNode = new LinkedList(value);
            tempNode.next = tempNode;
            return tempNode;
        }
        LinkedList node = new LinkedList(value);
        if (head.next == head) {
            node.next = head;
            head.next = node;
            head = node;
            return head;
        }
        LinkedList back = null;
        while (back != head) {
            if (back == null) {
                back = head;
            }
            if (back.data <= value && value <= back.next.data) {
                node.next = back.next;
                back.next = node;
                return head;
            } else if (back.data <= value && back.next.data <= value && back.data > back.next.data) {
                node.next = back.next;
                back.next = node;
                return head;
            } else if (back.data > back.next.data && back.data >= value && back.next.data >= value) {
                node.next = back.next;
                back.next = node;
                return head;
            } else {
                if (back.next == head) {
                    back.next = node;
                    node.next = head;
                    return head;
                }
                back = back.next;
            }
        }
        return head;
    }

    public LinkedList mergeInBetween(LinkedList head, int a, int b, LinkedList list2) {
        if (head == null) {
            return head;
        }
        if (list2 == null) {
            return head;
        }
        if (a > b) {
            System.out.println("First integer should be less than second.");
            return head;
        }
        LinkedList temp1 = head;
        LinkedList temp2 = list2;
        int count = 1;
        while (temp1 != null && count != a) {
            temp1 = temp1.next;
            count++;
        }
        LinkedList secondHalf = temp1.next;
        LinkedList temp3 = secondHalf;
        printList(temp3);
        if (temp2 != null) {
            System.out.println("temp1.next:" + temp1.next.data);
            temp1.next = temp2;
        }
        System.out.println("count:" + count);
        printList(head);
        while ((count >= a && count <= b) && temp3.next != null) {
            System.out.println("temp3:" + temp3.data);
            temp3 = temp3.next;
            count++;
        }
        LinkedList temp4 = temp3;
        printList(temp4);
        temp1 = head;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = temp4;
        printList(head);
        return head;
    }

    public LinkedList swapNodes(LinkedList head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList temp1 = head;
        LinkedList back = head;
        LinkedList front = head;
        int count = 1;
        while (count != k && front != null) {
            front = front.next;
            temp1 = temp1.next;
            count++;
        }
        while (front.next != null) {
            back = back.next;
            front = front.next;
        }
        int tempVal = back.data;
        back.data = temp1.data;
        temp1.data = tempVal;
        return head;
    }

    public LinkedList removeElements(LinkedList head, int val) {
        if (head == null) {
            return head;
        }
        if (head.data == val && head.next == null) {
            return null;
        }
        if (head.data != val && head.next == null) {
            return head;
        }

        while (head != null && head.data == val) {
            head = head.next;
        }
        LinkedList temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.data == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public LinkedList deleteAfterMNodes(LinkedList head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList temp1 = head;
        int count1 = 1;
        while (temp1 != null && count1 != m) {
            temp1 = temp1.next;
            count1++;
        }
        count1 = 0;
        while (temp1 != null && temp1.next != null && count1 != n) {
            temp1.next = temp1.next.next;
            count1++;
        }
        printList(head);
        //System.out.println(temp1.next.data);
        if (temp1 != null && temp1.next != null) {
            temp1.next = deleteAfterMNodes(temp1.next, m, n);
        }
        return head;
    }

    public LinkedList addTwoNumbers(LinkedList list1, LinkedList list2) {
        LinkedList temp1 = list1;
        LinkedList temp2 = list2;
        LinkedList result = null;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }
            if (sum > 9) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            LinkedList tempRes = new LinkedList(sum % 10);
            tempRes.next = result;
            result = tempRes;
            if (temp1 == null && temp2 == null & carry != 0) {
                tempRes = new LinkedList(carry);
                tempRes.next = result;
                result = tempRes;
            }
        }
        result = reverseList(result);
        return result;
    }

    public LinkedList add2NumbersII(LinkedList l1, LinkedList l2) {
        System.out.println("Entry1");
        LinkedList result = new LinkedList();
        result = recursion(l1, l2);
        System.out.println("Entry2");
        System.out.println("result:");
        printList(result);
        return result;
    }

    public LinkedList recursion(LinkedList l1, LinkedList l2) {
        //LinkedList res = result;
        if (l1 == null && l2 == null) {
            return l1;
        }
        LinkedList res;
        if (l1 != null && l2 == null) {
            res = recursion(l1.next, l2);
        } else if (l2 != null && l1 == null) {
            res = recursion(l1, l2.next);
        } else {
            res = recursion(l1.next, l2.next);
        }
        int carry = 0;
        if (res != null && res.data > 9) {
            carry = res.data / 10;
            res.data = res.data % 10;
        }
        int sum = carry;
        if (l1 != null) {
            sum += l1.data;
        }
        if (l2 != null) {
            sum += l2.data;
        }
        LinkedList tempRes = new LinkedList(sum);
        tempRes.next = res;
//        printList(res);
        return tempRes;
    }

    public void PrintRecur(LinkedList l1, LinkedList l2) {
        if (l1 == null && l2 == null) {
            return;
        }
        LinkedList t1 = l1, t2 = l2;
        if (t1 != null) {
            t1 = t1.next;
        }
        if (t2 != null) {
            t2 = t2.next;
        }
        PrintRecur(t1, t2);
        if (l1 != null) {
            System.out.print(l1.data + " ");
        }
        if (l2 != null) {
            System.out.print(l2.data);
        }
        System.out.println("");
    }

    public int getDecimalValue(LinkedList head) {
        if (head == null) {
            return 0;
        }
        int power = 0;
        int sum = 0;
        int[] tempInt = {};
        int i = 0;
        LinkedList temp = head;
//        LinkedList temp = reverseList(head);

//        while(temp != null){
//            sum += temp.data*Math.pow(2,power);
//            power++;
//            temp = temp.next;
//        }
        while (temp != null) {
            tempInt[i] = temp.data;

            temp = temp.next;
        }
        for (int j = 0; j < tempInt.length; j++) {
            sum += tempInt[i] * Math.pow(2, power);
            power++;
        }
        return sum;
    }

    public LinkedList removeDuplicateNodes(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList temp1 = head;
        LinkedList temp2;
        while (temp1 != null) {
            temp2 = temp1.next;
            while (temp2 != null && temp1.data == temp2.data) {
                temp2 = temp2.next;
            }
            temp1.next = temp2;
            temp1 = temp1.next;
        }
        return head;
    }

    public LinkedList rotateRight(LinkedList head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        LinkedList back = head;
        LinkedList front = head;
        //int count =1;
        int N = 0;
        while (back != null) {
            back = back.next;
            N++;
        }
//        if( N == k){
//
//        }
        System.out.println("N:" + N);
        back = head;
        if (k == N) {
            return head;
        }
        k = N - k;
        while (k < 0) {
            k *= -1;
            k = N - k;
        }
//        k = k % N;
        int count = 1;
        while (back != null && count != k) {
            back = back.next;
            count++;
        }
        LinkedList secondHalf = null;
        if (back != null && back.next != null) {
            secondHalf = back.next;
            front = secondHalf;
            printList(secondHalf);
            back.next = null;
            while (front != null && front.next != null) {
                front = front.next;
            }
        }
        printList(head);
        front.next = head;
        head = secondHalf;
        return head;
    }

    public LinkedList merge2SortedList(LinkedList l1, LinkedList l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return l1;
        }
        LinkedList temp1 = l1;
        LinkedList temp2 = l2;
        LinkedList result = null, head = null;
        while (temp1 != null && temp2 != null) {
            while (temp1 != null && temp2 != null && temp1.data <= temp2.data) {
                if (result == null) {
                    result = head = temp1;
                } else {
                    result.next = temp1;
                    result = result.next;
                }
                temp1 = temp1.next;
            }
            while (temp2 != null && temp1 != null && temp2.data < temp1.data) {
                if (result == null) {
                    result = temp2;
                    head = result;
                } else {
                    result.next = temp2;
                    result = result.next;
                }
                temp2 = temp2.next;
            }
        }
        if (temp2 != null) {
            result.next = temp2;
        }
        if (temp1 != null) {
            if (temp1 != null) {
                result.next = temp1;
            }
        }
        return head;
    }
}


