package DSA.journey.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueElements {

    public static void main(String[] args) {
        int arr[]={ 1,1,3};
        System.out.println(new UniqueElements().solve(arr));
    }

    public int solve(int[] arr) {
        int n=arr.length;
        int ans=0;


        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                continue;
            }
            else{
                int inc=Math.abs(arr[i]-arr[i-1])+1;
                arr[i]=arr[i]+inc;
                ans=ans+(inc);
            }
        }

        return ans;
    }
}
