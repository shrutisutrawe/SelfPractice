package SelfPractice;
//import INFO6205.Assignment_2;
public class LinkedMain {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        int[] array = {0};
        int[] array2 = {0};
//        int[] array = {};
        //list.addHead(2);
        //list.addHead(1);
        //list.printList();
        //list.addTail(3);
        //list.printList();


        LinkedList head = list.createList(array);
        list.printList(head);
        LinkedList list2 = list.createList(array2);
        list.printList(list2);
        LinkedList node = list.merge2SortedList(head,list2);
//        LinkedList node = list.rotateRight(head,5);
        list.printList(node);
//        LinkedList node = list.removeDuplicateNodes(head);
//        list.printList(node);
//        int result = list.getDecimalValue(head);
//        System.out.println("result is : "+result);
//        list.printList(list2);
//        LinkedList result = list.add2NumbersII(head, list2);
//        list.printList(result);
//        list.PrintRecur(head,list2);
//        LinkedList result = list.addTwoNumbers(head,list2);
//        list.printList(result);
//        int[] array2 = {1001,1002,1003};
//        LinkedList list2 = list.createList(array2);
//         LinkedList node = list2.mergeInBetween(head,3,4,list2);
//        list.printList(node);
//        System.out.println("head:"+head.data);
//        LinkedList swap = list.swapNodes(head);
//        list.printList(head);
//        LinkedList node1 = head.next.next;
//        System.out.println("in " + node1.data);
//        list.deleteNode(node1);
//        System.out.println("out " + node1.data);
//        head.next.next = node1;
//        LinkedList node = list.breakList(head);
//        list.printList(head);
//        list.printList(node);
//        LinkedList updated = list.oddEvenList(head);
//        list.printList(updated);
//        LinkedList[] finalList = list.splitListToParts(head, 3);
//        for(int i=0; i<finalList.length; i++){
//            list.printList(finalList[i]);
//        }

        //list.addTail(8,head);
//        head.next.next.next=head;
//        head.next.next.next.next.next.next.next.next = head.next.next.next.next;
//        head.next.next.next.next.next.next.next.next = head;
//        int count = list.sizeOfList(head);
//        System.out.println("Size of LinkedList is : "+count);
//        head = list.reverseList(head);
//        list.printList(swap);
//        int k =3;
//        LinkedList findNode = list.findKTerm(head,k);
//        LinkedList node = list.swapNodes(head,k);
//        LinkedList node = list.removeElements(head, 3);
//        LinkedList node = list.deleteAfterMNodes(head, 3,5);
//        list.printList(node);
//        System.out.println("Found Node : "+findNode.data);
//        boolean result = list.isCycle(head);
//        System.out.println("isCycle :"+result);
//        LinkedList node = list.insertInCircularList(head,2);
//        list.printList(node);
//        list.printList(head);
//        boolean result = list.isPalindrome(head);
//        System.out.println("Is palindrome : "+result);


    }
}
