package DSA.journey.LinkedLists;

public class KReverseList {

    public static void main(String[] args) {
        ListNode f=new ListNode(1);
        f.next=new ListNode(2);
        f.next.next=new ListNode(3);
        f.next.next.next=new ListNode(4);
        f.next.next.next.next=new ListNode(5);
        f.next.next.next.next.next=new ListNode(6);
        f.next.next.next.next.next.next=new ListNode(7);
        ListNode ans=new KReverseList().reverseList(f,2);
        print(ans);
    }
    public ListNode reverseList(ListNode head, int k) {
        ListNode dummy=head;ListNode firstNode= new ListNode(1);

        ListNode ansNode= firstNode;

        while(dummy!=null){
            ListNode h2=null; ListNode h1=dummy;
            ListNode f=h1;
            for(int i=1;i<=k&&h1!=null;i++){
           //     f=f.next;
                ListNode tmp=h1;
                h1=h1.next;
                tmp.next=h2;
                h2=tmp;

            }
            firstNode.next=h2;
            while(firstNode.next!=null){
                firstNode=firstNode.next;
            }
            //firstNode=dummy;
            dummy=h1;


        }
        return ansNode.next;

    }
    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
}
