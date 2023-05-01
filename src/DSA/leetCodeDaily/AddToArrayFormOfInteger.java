package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
       int [] num = {2,1,5};
           int k = 806;
        System.out.println(new AddToArrayFormOfInteger().addToArrayForm(num,k));

    }


    //2 1 5
    //8 0 6
    //    1  sum=11, carry=1

    public  List<Integer> addToArrayForm(int[] num, int k){

        LinkedList<Integer> res=new LinkedList<>();
        int len=num.length-1;
        while(len>=0 || k!=0){

            if(len>=0){
                k=k+num[len];
                len--;
            }
            res.addFirst(k%10);
            k=k/10;

        }
        return  res;
    }
    public  List<Integer> addToArrayFormComplex(int[] num, int k) {
        List<Integer> ans =new ArrayList<>();

        int numLen=num.length-1;
        String kNum=String.valueOf(k);
        int kNumLen=kNum.length()-1;
        int carry=0;
        while(numLen>=0&&kNumLen>=0){
            int sum=num[numLen]+(kNum.charAt(kNumLen)-'0')+carry;
            carry=sum/10;
            ans.add(sum%10);
            numLen--;
            kNumLen--;
        }

        while(kNumLen>=0){
            int sum=(kNum.charAt(kNumLen)-'0')+carry;
            carry=sum/10;
            ans.add(sum%10);
            kNumLen--;
        }
        while(numLen>=0){
            int sum=num[numLen]+carry;
            carry=sum/10;
            ans.add(sum%10);
            numLen--;
        }
        if(carry>0)ans.add(carry);

        Collections.reverse(ans);
     return ans;
    }
}
