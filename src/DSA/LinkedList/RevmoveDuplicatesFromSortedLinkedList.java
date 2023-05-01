package DSA.LinkedList;



// class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x){
//        val=x;
//        next=null;
//    }
//}

public class RevmoveDuplicatesFromSortedLinkedList {

    public  ListNode removeDuplicateFromSortedLL(ListNode head){
        ListNode curr=head;
        while(curr!=null){

            if(curr.next!=null && curr.val==curr.next.val){
                ListNode nextNext=curr.next.next;
                ListNode nodeToDelete=curr.next;
                //delete the duplicate node
                curr.next=nextNext;
            }{
                curr=curr.next;
            }


        }


        return head;
    }
   static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }  public static void main(String[] args)
    {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next =new ListNode(6);


        System.out.println("Given Linked list");
        printList(list);
        ListNode head =new RevmoveDuplicatesFromSortedLinkedList().removeDuplicateFromSortedLL(list);
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(head);
    }
}
