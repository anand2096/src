package DSA.journey.sorting;

import DSA.CommonFun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {
//2 1 4 3 5
    public static void main(String[] args) {
    int []A = {1,2 };
       // System.out.println(new WaveArray().wave(CommonFun.createInput(A)));
        int ans[]=new WaveArray().wave(A);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    // 1 2 3 4 5
    public int[] wave(int[] arr) {
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2){


            swap(arr,i,i-1);
        }
        return arr;

    }
    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //space complex
    public ArrayList<Integer> wave(ArrayList<Integer> list) {
        int n=list.size();
        ArrayList<Integer> ans =new ArrayList<>();

        Collections.sort(list);
        //Collections.reverse(list);
        for(int i=0;i<n;i+=2){
            if(i+1<n)
            ans.add(list.get(i+1));
            ans.add(list.get(i));

        }


     return ans;
    }
}
