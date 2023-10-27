package DSA.journey.Heap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class ListNode {
      public int val;
     public ListNode next;
 ListNode(int x) { val = x; next = null; }
  }
public class MergeKSortedLists {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ArrayList<ListNode> list) {
        if(list.size()==1) return list.get(0);
        ListNode ans=new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((c,b) -> c.val-b.val);
        for(int i=0;i<list.size();i++){
            pq.add(list.get(i));
        }
        while(pq.size()>0){
            ListNode peek=pq.remove();
            if(peek.next!=null){
                pq.add(peek.next);
            }
            ans.next=peek;


        }
        return ans;
    }
}
