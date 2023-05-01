package DSA.LinkedList;

public class ReverseALinkeListInGroupsOfGivenSize {
    int k=3;
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
   public Node reverserInGroup(Node node){
        Node dummy=node;
        Node curr=node;
        Node next,prev=null;

        int len=0;
        Node lenDummy=node;
        while(lenDummy!=null){
            lenDummy=lenDummy.next;
            len++;
        }
        while(len>k){
                int cnt=0;
            while(curr!=null&& cnt<k){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                cnt++;
            }
            prev=dummy;
            prev.next=curr;
            dummy=curr;
            len=len-k;
            printList(prev);

        }
        return node;

    }
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }  public static void main(String[] args)
    {
        ReverseALinkeListInGroupsOfGivenSize list = new ReverseALinkeListInGroupsOfGivenSize();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next= new Node(8);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverserInGroup(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }


}
