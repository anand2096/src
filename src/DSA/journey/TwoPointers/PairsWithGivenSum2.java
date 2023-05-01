package DSA.journey.TwoPointers;

import java.util.Arrays;

public class PairsWithGivenSum2 {

    public static void main(String[] args) {

        int arr[]= {  4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666  };
        int b= 9259332;
//        int arr[]= {   1, 2, 6, 6, 7, 9, 9 };
//        int b= 13;
//        int arr[]= { 2, 2, 3, 4, 4, 5, 6, 7, 10 };
//        int b= 8;
        System.out.println(new PairsWithGivenSum2().solve(arr,b));

    }
    public int solve(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        long count =0;
        long mod=(long)Math.pow(10,9)+7;
        long i=0;
        long j=arr.length-1;
        while(i<j){
            if(arr[(int) i]+arr[(int) j]==k) {
                if (j == i + 1) {
                    count++;
                    i++;
                    j--;
                } else {
                    i++;
                    long cnt1 = 1;
                    long cnt2 = 1;
                    while (i<n&&arr[(int) i] == arr[(int) (i - 1)]) {
                        i++;
                        cnt1++;
                    }
                    if(cnt1==n){
                        long n1=n%mod;
                        long n2=(n-1)%mod;
                        long n3=(n1*n2)%mod;
                        if(n3<0){
                            n3=n3+mod;
                            n3=n3%mod;
                        }
                        return (int) ((n3/2)%mod);
                    }
                    while (i < j && arr[(int) j] == arr[(int) (j - 1)]) {
                        j--;
                        cnt2++;
                    }
                    count = (count + (cnt1  * cnt2)%mod)%mod;

                }
            }
            else if(arr[(int) i]+arr[(int) j]<k){
                i++;
            }
            else{
                j--;
            }
        }

        return (int) (count%mod);
    }

//    //public int solve(int[] arr, int k) {
//        int n=arr.length;
//        Arrays.sort(arr);
//        long count =0;
//        long mod=(long)Math.pow(10,9)+7;
//        long i=0;
//        long j=arr.length-1;
//        while(i<j){
//            if(arr[(int) i]+arr[(int) j]==k) {
//                if (j == i + 1) {
//                    count++;
//                    i++;
//                    j--;
//                } else {
//                    i++;
//                    long cnt1 = 1;
//                    long cnt2 = 1;
//                    while (i<n&&arr[(int) i] == arr[(int) (i - 1)]) {
//                        i++;
//                        cnt1++;
//                    }
//                    if(cnt1==n){
//                        long n1=n%mod;
//                        long n2=(n-1)%mod;
//                        long n3=(n1*n2)%mod;
//                        if(n3<0){
//                            n3=n3+mod;
//                            n3=n3%mod;
//                        }
//                        return (int) ((n3/2)%mod);
//                    }
//                    while (i < j && arr[(int) j] == arr[(int) (j - 1)]) {
//                        j--;
//                        cnt2++;
//                    }
//                    count = (count + (cnt1  * cnt2)%mod)%mod;
//
//                }
//            }
//            else if(arr[(int) i]+arr[(int) j]<k){
//                i++;
//            }
//            else{
//                j--;
//            }
//        }
//
//        return (int) (count%mod);
//    }
}
