package DSA.Arrays;

import java.util.*;
public class MedianOfArray {
    public static void main(String[] args) {
  int arr[] = {56,67,30,79};
        System.out.println(find_median(arr));
    }
    public static int find_median(int[] v)
    {
        int ans=0;
        // Code here
        Arrays.sort(v);
        int len=v.length/2;
        if(v.length%2!=0){
            ans=v[len];

        }else{
            ans=(v[len]+v[len-1])/2;

        }
        return ans;
    }
}
