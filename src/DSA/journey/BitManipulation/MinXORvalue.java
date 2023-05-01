package DSA.journey.BitManipulation;

import java.util.Arrays;

public class MinXORvalue {

    public static void main(String[] args) {
        int arr[]={5,2,0,7};
        System.out.println(new MinXORvalue().findMinXor(arr));
    }
    public int findMinXor(int[] arr) {
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;

        int temp=arr[0];
        for(int i=1;i<arr.length;i++){

            if((temp^arr[i])<ans){
                ans=temp^arr[i];
            }
            temp=arr[i];

        }
        return ans;
    }
}
