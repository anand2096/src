package DSA.journey.LinkedLists;
class ListN {
    public int val;
    public ListN right;
    public ListN down;
    ListN(int x) { val = x; right = null;down=null; }
}
public class FlattenLinkedList {
    public static void print(ListN head){
        ListN temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.right;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ListN head=new ListN(3);
        head.down=new ListN(7);
        head.down.down=new ListN(7);
        head.down.down.down=new ListN(8);
        head.right=new ListN(4);
        head.right.down=new ListN(11);
        head.right.right=new ListN(20);
        head.right.right.down=new ListN(22);
        ListN ans=new FlattenLinkedList().flatten(head);
        print(ans);


    }
   public ListN flatten(ListN root) {

        ListN head=root;
        while(head!=null){

            ListN td=head.down;
            while(td!=null){
             ListN temp=head.right;
             head.right=td;
             td.right=temp;
             td=td.down;
             head.down=null;
             head=head.right;
            }
            head=head.right;

        }
    print(root);
    return merge(root);
    }



    public ListN merge(ListN head){
        if(head==null)return head;
        if(head.right==null)return head;

        ListN c=middleNode(head);
        ListN h2=c.right;
        c.right=null;
        head=merge(head);
        h2=merge(h2);
        return mergeTwoLists(head,h2);


    }
    public ListN middleNode(ListN head){
        ListN slow=head;
        ListN fast=head;
        while(fast.right!=null && fast.right.right!=null){
            slow=slow.right;
            fast=fast.right.right;
        }
        return slow;
    }


    public ListN mergeTwoLists(ListN h1, ListN h2) {
        if(h1==null)return h2;
        if(h2==null)return h1;

        ListN h3=null;

        if(h1.val<h2.val){
            h3=h1;
            h1=h1.right;
        }else{
            h3=h2;
            h2=h2.right;
        }
        ListN head=new ListN(1);
        head.right=h3;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                h3.right=h1;
                h1=h1.right;
                h3=h3.right;
            }
            else{
                h3.right=h2;
                h2=h2.right;
                h3=h3.right;
            }
        }
        if(h1==null){
            h3.right=h2;
        }
        if(h2==null){
            h3.right=h1;
        }

        return head.right;

    }
}
