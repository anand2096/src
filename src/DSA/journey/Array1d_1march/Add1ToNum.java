package DSA.journey.Array1d_1march;

import java.util.Arrays;
import java.util.LinkedList;

public class Add1ToNum {
    public static void main(String[] args) {
        int arr[] = {9,9,9};
        int ans[]=new Add1ToNum().plusOne(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public int[] plusOne(int[] arr) {
        int ans[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ans[i+1] = arr[i];
        }
        int carry=1;
        for (int i = ans.length-1; i >= 1; i--) {
            int num = ans[i] + carry;
             ans[i]=num % 10;
            carry = num / 10;
        }
        if(carry==1)
            ans[0]=carry;
        int i=0;
        while(ans[i]==0){
            i++;
        }
        int temp[]=Arrays.copyOfRange(ans, i, ans.length);
return temp;


//        LinkedList<Integer> list=new LinkedList<>();
//        for(int i=0;i<arr.length;i++){
//            list.add(arr[i]);
//        }
//        int carry=1;
//        for(int i=list.size()-1;i>=0;i--){
//            int num=list.get(i)+carry;
//            list.set(i,num%10);
//            carry=num/10;
//
//        }
//        if(carry>0){
//            list.addFirst(carry);
//        }
//        int i=0;
//        while(list.get(i)==0){
//            list.remove(list.get(i));
//        }
//        //list.toArray();
//        return  list.stream().mapToInt(j->j).toArray();
    }
}
