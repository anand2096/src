package DSA.journey.LinkedLists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomListNode {
      int label;
      RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
 };
public class CloneALinkedList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode h1=head;
        RandomListNode t1=h1;

        while(t1!=null){

            RandomListNode newNode=new RandomListNode(t1.label);
            RandomListNode temp=t1.next;
            newNode.next=temp;
            t1.next=newNode;
            t1=temp;
        }
        RandomListNode h2=h1.next;
      //  print(h1);
//initialising random pointers
        RandomListNode T1=h1;
        RandomListNode T2=h2;
        while (T1!=null){
            if(T1.random!=null)
            T2.random=T1.random.next;
            T1= T1.next.next;
            if(T1!=null){
                T2=T2.next.next;
            }
        }
        T1=h1;
        T2=h2;
        while(T1!=null){
            T1.next=T2.next;
            T1=T1.next;
            if(T1!=null){
                T2.next=T1.next;
            }
            T2=T2.next;
        }
      //  print(h1);
     //   print(h2);

        return h2;
    }
    public RandomListNode copyRandomListExtraSpace(RandomListNode head) {

        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode t1=head;
        RandomListNode t2=new RandomListNode(1);
        RandomListNode head2=t2;


        while(t1!=null){
            RandomListNode temp=new RandomListNode(t1.label);
            t2.next=temp;
            t2=t2.next;
            t1=t1.next;
        }
        head2=head2.next;
        print(head);
        System.out.println("second list");
        print(head2);
      RandomListNode T1=head;
      RandomListNode T2=head;
      while(T1!=null){
          map.put(T1,T2);
          T1=T1.next;
          T2=T2.next;
      }
      T1=head;
      T2=head2;
      while(T1!=null){
          T2.random=map.get(T1.random);
          T1=T1.next;
          T2=T2.next;
      }
        System.out.println("");
        print(head2);

        //initializing random pointers



        return head2;
    }




    public static void print(RandomListNode head){
        RandomListNode temp=head;
        while(temp!=null){
            System.out.print(temp.label+" ");
            temp=temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
    //    14 83 188 253 281 254 56 70 3 276 233 280 224 16 173 183 193 44 184 33 213 134 95 213 48 300 62 237 63
        RandomListNode f=new RandomListNode(1);
        f.next=new RandomListNode(2);
        f.next.next=new RandomListNode(3);
        f.next.next.next=new RandomListNode(4);
        f.next.next.next.next=new RandomListNode(5);
       RandomListNode head2= new CloneALinkedList().copyRandomList(f);
       print(head2);
    }
}
