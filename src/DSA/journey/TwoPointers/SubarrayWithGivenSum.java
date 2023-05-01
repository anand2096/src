package DSA.journey.TwoPointers;

import java.util.Arrays;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        int []A = { 1, 1000000000 };
       int  B = 1000000000;
       int ans[]=new SubarrayWithGivenSum().solve(A,B);
       for(int i=0;i<ans.length;i++){
           System.out.print(ans[i]+" ");
       }
    }

    public int[] solve(int[] arr, int k) {

        int i=0;
        int j=0;
        int n=arr.length;
        int sum=0;
        while(j<n){
            if(sum<k){
                sum=sum+arr[j];
                j++;
            }
           else {
                if(sum==k) {
                    return Arrays.copyOfRange(arr, i, j);
                }
                else{
                    while(i<n&& sum>k){
                        sum=sum-arr[i];
                        i++;
                    }
                    if(sum==k) {
                        return Arrays.copyOfRange(arr, i, j);
                    }
                }
            }
        }
        while(i<n&& sum>k){
            sum=sum-arr[i];
            i++;
        }
        if(sum==k) {
            return Arrays.copyOfRange(arr, i, j);
        }
        int [] ans=new int[1];
        ans[0]=-1;
        return ans;
    }
}
