package DSA.Recursion;

import java.util.ArrayList;

public class Subsequnces {


    public static void main(String[] args) {
        int arr[]={3,1,2};
        int n=3;
        ArrayList<Integer> al=new ArrayList<>();
        new Subsequnces().printSubs(0,arr,n,al);
    }

    public void printSubs(int ind,int arr[],int n,ArrayList al){

        if(ind ==n){
            System.out.println(al);
        return;
        }
        int val=arr[ind];
        al.add(val);
        printSubs(ind+1,arr,n,al);
        al.remove(al.size()-1);
        printSubs(ind+1,arr,n,al);

    }
}
