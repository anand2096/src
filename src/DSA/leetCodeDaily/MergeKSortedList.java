package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedList {
    public static void main(String[] args) {
        List<List<Integer>> inp=new ArrayList<>();

        int arr[]={1,4,5};
        int brr[]={1,3,4};
        int crr[]={2,6};
        List<Integer>a1=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            a1.add(arr[i]);
        }
        List<Integer>b1=new ArrayList<>();
        for(int i=0;i<brr.length;i++){
            b1.add(brr[i]);
        }
        List<Integer>c1=new ArrayList<>();
        for(int i=0;i<crr.length;i++){
            c1.add(crr[i]);
        }
        inp.add(a1);inp.add(b1);
        inp.add(c1);
        ListNode[] list=new ListNode[inp.size()];
        for(int i=0;i<inp.size();i++){

            ListNode dummy=new ListNode(-1);
            ListNode head=dummy;
            List<Integer>a=inp.get(i);
            for(int j=0;j<a.size();j++){
                ListNode temp=new ListNode(a.get(j));
                dummy.next=temp;
                dummy=dummy.next;

            }
            list[i]=head.next;

        }
       ListNode ans= new MergeKSortedList().mergeKLists(list);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans=ans.next;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        int i=0;
        int last= lists.length-1;
        int j;
        while(last!=0){
            i=0;
            j=last;
            while(i<j){
                lists[i]=mergeTwoList(lists[i],lists[j]);
                i++;
                j--;
                if(i>=j){
                    last=j;
                }
            }
        }

        return lists[0];
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
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
