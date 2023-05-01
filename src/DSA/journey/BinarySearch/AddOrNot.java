package DSA.journey.BinarySearch;

import java.util.Arrays;

public class AddOrNot {
    int mod=(int)Math.pow(10,9)+7;
    public static void main(String[] args) {
        int[] A = {2, 4, 5};

        int B = 4;

        int ans[]=new AddOrNot().solve(A,B);
        System.out.println(ans[0]+" "+ans[1]);
    }
    public int[] solve(int[] arr, int k) {
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        Arrays.sort(arr);
        int n=arr.length;
        long prefix[]=new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+arr[i];
        }
        for(int i=0;i<n;i++){
            int max=0;
            int low=1;
            int high=i+1;
            while(low<=high){
                int count=(low+(high-low)/2);
                if(check(count,k,arr,i,prefix)){
                    max=count;
                    low=count+1;
                }
                else{
                    high=count-1;
                }
            }
            if(ans[0]<max){
                ans[0]=max;
                ans[1]=arr[i];
            }

        }
        return ans;
    }

    private boolean check(int count, int k, int[] arr, int i,long prefix[]) {

        if((long) arr[i] *count-(prefix[i+1]-prefix[i+1-count])<=k){
            return true;
        }
    return false;

    }


    public int[] solveBrute(int[] arr, int k) {
        int n=arr.length;
        int ans[]=new int[2];
        int maxFreq=Integer.MIN_VALUE;
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            int no=arr[i];//nlogn
            int j=0;
            int c=k;
            int freq=1;
            while(c>0 && j<i){
                int diff=no-arr[j];
                if(diff<=c){
                    freq++;
                    c=c-diff;
                }
                j++;
            }
            if(freq>maxFreq){
                maxFreq=freq;
                ans[0]=maxFreq;
                ans[1]=no;
            }

        }

        return ans;

    }
}
