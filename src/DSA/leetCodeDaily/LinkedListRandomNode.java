package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class LinkedListRandomNode {
    ListNode head;

    public static void main(String[] args) {
        LinkedListRandomNode node=new LinkedListRandomNode(new ListNode(1));
        node.getRandom();

    }


    public LinkedListRandomNode(ListNode head) {
            this.head=head;
            ListNode lenCount=head;

    }

    public int getRandom() {
        ListNode curr = head;
        int index = 1;
        int res = 0;

        while(curr != null){
            if(Math.random() < 1.0 / index){
                // take this value
                res = curr.val;
            }
            index++;
            curr = curr.next;
        }

        return res;
    }
}
