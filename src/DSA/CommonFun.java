package DSA;

import java.util.ArrayList;



public class CommonFun {

    public static ArrayList<Integer> createInput(int arr[]){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            al.add(arr[i]);
        }
        return al;
    }

}
