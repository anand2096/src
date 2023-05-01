package DSA.LinkedList;

/**
 * Intuition
 * S=L1+L2
 * f=L1+L2+nC
 *
 * 2(L1+L2)=L1+L2+nC
 * L1+L2=nC
 * L1=nC-L2
 *
 */


class Listnode{
    int data;
    Listnode next;
    Listnode(int x){
        data=x;
        next=null;
    }
}
public class DetectStartingPointOfTheCycle {


    public Listnode startingPointOfLoop(Listnode head){
        if(head==null||head.next==null){
            return null;
        }
        Listnode slow=head;
        Listnode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("loop is founded...now finding starting point of loop");

                slow=head;

                while (slow != fast) {
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;

            }

        }
        return null;

    }

}
