package SelfPractice;

public class MergeSortedList {
    public LinkedList mergeTwoLists(LinkedList l1, LinkedList l2) {
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
            result.next = temp1;
        }
        return head;

    }
}
