package DSA.journey.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
       int [] A = {5, 17, 100, 11};

        int B = 2;
        System.out.println(new AggressiveCows().solve(A,B));
    }
    public int solve(int[] stalls, int cows) {
        Arrays.sort(stalls);
        long ans=0;
        int n=stalls.length;
        long low=Long.MAX_VALUE;
        long high=stalls[n-1]-stalls[0];
        for(int i=1;i<n;i++){
            if(stalls[i]-stalls[i-1]<low){
                low=stalls[i]-stalls[i-1];
            }
        }
        while(low<=high){
            long mid=(low+(high-low)/2);
            if(check(stalls,cows,mid)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)ans;

    }

    private boolean check(int[] stalls, int cows, long mid) {

        int count=1;
        int lastLoc=stalls[0];
        for(int i=1;i<stalls.length;i++){

            if(stalls[i]-lastLoc>=mid){
                count++;
                lastLoc=stalls[i];
            }
        }
        if(count>=cows){
            return true;
        }
        return false;

    }
}
