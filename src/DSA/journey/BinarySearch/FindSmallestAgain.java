package DSA.journey.BinarySearch;

import java.util.Arrays;

public class FindSmallestAgain {

    public static void main(String[] args) {
       int [] A = {1, 5, 7, 3, 2};
       int B = 9;
        System.out.println(new FindSmallestAgain().solve(A,B));


    }
    public int solve(int[] arr, int B) {
        int n=arr.length;
        int ans=1;
        Arrays.sort(arr);
        int low=arr[0]+arr[1]+arr[2];
        int high=arr[n-1]+arr[n-2]+arr[n-2];

        while(low<=high){
            int mid=(low+(high-low)/2);
            if(check(arr,mid)<B){
                ans=mid;
                low=mid+1;

            }
            else{
                high=mid-1;
            }
    }
        return ans;
}

    private int check(int[] arr, int mid) {
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
          //  long remSum=mid-arr[i];
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]<mid){
                    count=count+k-j;
                    j++;

                }
                else {
                    k--;
                }
            }
        }
        return count;

    }

}
