package DSA.journey.Array1d_1march;

import java.util.ArrayList;

public class FirstMissingInteger {
    public static void main(String[] args) {

        int arr[]={1};
        System.out.println(new FirstMissingInteger().firstMissingPositive(arr));
    }
    public int firstMissingPositive(int[] arr) {
        int nPlus2=arr.length+2;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=0){
                arr[i]=nPlus2;
            }
        }
        for(int i=0;i<arr.length;i++){
            int ind=Math.abs(arr[i]);
            if((ind>=1&&ind<=arr.length) &&arr[ind-1]>0)
            arr[ind-1]=arr[ind-1]*-1;
        }

        for(int i=0;i<arr.length;i++){

            if(arr[i]>0)
                return i+1;
        }
        return arr.length+1;
    }
}
