//
//
 package DSA.LinkedList;
//
public class MergeTwoSortedList {

    public static void main(String[] args) {

    }
   public ListNode mergeTwoList(ListNode l1,ListNode l2){
   if(l1==null) return l2;
   if(l2==null)return l1;

if(l1.val>l2.val){
    ListNode temp=l1;
    l1=l2;
    l2=temp;
}
   ListNode ans=l1;

   while(l1!=null && l2!=null){
       ListNode temp=null;
       while(l1!=null && l1.val<=l2.val){
           temp=l1;
           l1=l1.next;
       }
       temp.next=l2;
       //swap if l1 is greater then l2;

           ListNode swap=l1;
           l1=l2;
           l2=swap;

   }
 //  l1.next=l2;


   return ans;
   }
}


















//    {
//        if(l1== null)return  l2;
//        if(l2==null)return l1;
//        if(l1.val>l2.val){
//
//            ListNode temp=l1;
//            l1=l2;
//            l2=temp;
//        }
//    ListNode res=l1;
//        while(l1!=null&&l2!=null){
//            ListNode temp=null;
//            while (l1 != null && (l1.val < l2.val)) {
//                temp=l1;
//                l1=l1.next;
//            }
//            temp.next=l2;
//            //swap
//            ListNode tmp=l1;
//            l1=l2;
//            l2=tmp;
//
//
//        }
//        return  res;
//    }
//}
