package DSA.SlidingWindow.constant;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubArraysOfSizeK {


    public static void main(String[] args) {
        int arr[]={1,3,-4,-3,-6,3,6,7};
        int k=3;
        int max= Integer.MIN_VALUE;
        int i=0,j=0;
        List<Integer> ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        while(j<arr.length){
            int size=temp.size();
            while(size-1>=0){
                if(temp.get(size-1)<arr[j]){
                    temp.remove(size-1);
                }
                size--;
            }
            temp.add(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){

                if(temp.size()==0)ans.add(-1);
                else{
                    ans.add(temp.get(0));
                    if(temp.get(0)==arr[i]){
                        temp.remove(0);
                    }
                }
                i++;j++;
            }
        }

        System.out.println(ans);
    }
}
