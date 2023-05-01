package DSA.journey.sorting;


import java.util.*;

class MyComparator implements Comparator<Integer>{


    @Override
    public int compare(Integer o1, Integer o2) {
        int a=o1;
        int b=o2;
        int alen=(int)Math.ceil(Math.log10(a));
        int blen=(int)Math.ceil(Math.log10(b));
        int aLastDigit= (int) ((a/Math.pow(10,alen))%10);
        int bLastDigit=(int) ((b/Math.pow(10,blen))%10);
        if(aLastDigit<bLastDigit){
            return 1;
        }
        else if(aLastDigit>bLastDigit)
            return -11;
        else if(a>b)
            return -1;
        else
            return 1;
    }
}
public class LargestNumber {

    public static void main(String[] args) {
   //     int ar[]={472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 };
        int ar[]={12,121 };
        System.out.println(new LargestNumber().largestNumber(ar));
    }

    public String largestNumber(final int[] arr) {
        String ans="";
        List<Integer> blist=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            blist.add(arr[i]);
        }
        Collections.sort(blist,new MyComparator());
        for(int i=0;i<blist.size();i++){
            if(blist.get(i)>0)
            ans=ans+String.valueOf(blist.get(i));
        }
        if(ans.equals(""))
            return "0";
        return ans;
    }


}
