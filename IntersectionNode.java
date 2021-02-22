package SelfPractice;
public class IntersectionNode extends LinkedList {
    public LinkedList getIntersectionNode(LinkedList l1, LinkedList l2){
        if(l1 == null || l2 == null){
            return null;
        }
        LinkedList temp1 = l1;
        LinkedList temp2 = l2;
        int N1=0, N2=0;
        while(temp1 != null){
            temp1 = temp1.next;
            N1++;
        }
        while(temp2 != null){
            temp2 = temp2.next;
            N2++;
        }
        temp1 = l1;
        temp2 = l2;
        if(N1 < N2){
            for(int i =0 ; temp2 != null && i < N2-N1 ; i++){
                temp2 = temp2.next;
            }
        }
        if(N2 < N1){
            for (int i =0 ;temp1 != null && i < N1-N2; i++){
                temp1 = temp1.next;
            }
        }
        while(temp1 != null && temp2 != null && temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}
