package DSA.Arrays;

import java.util.Arrays;

public class MaximizeSum {

    public static void main(String[] args) {
        long arr[] = {-5 ,-4, -3 ,-1 ,1, 4 ,6};
        int k = 7;
        int n = arr.length;
        System.out.println(maximizeSumF(arr, n, k));

    }

    public static long maximizeSumF(long a[], int n, int k) {
        int c = k;
        Arrays.sort(a);
        long nsum = 0;
        int i = 0;
        while (k > 0&& i<n) {
            if (a[i] > 0) break;
            else {
                long temp = a[i] * -1;
                a[i] = a[i] * -1;
                nsum += a[i];
                k--;
                i++;
            }
        }
        int t = i;
        if ((k % 2 != 0) &&i <n) {

            if (c == k) {
                nsum = nsum - a[0];
                t++;
            } else {
                if (a[i - 1] < a[i]) {
                    nsum = nsum - a[i - 1];
                    t = i;
                } else {
                    nsum = nsum - a[i];
                    t = i + 1;
                }
            }

        }
        if(c>k&&i==n){
            if(k%2!=0){
                nsum=nsum+a[i-1]*-1*2;
            }
        }
        for (int s = t; s < a.length; s++)
            nsum = nsum + a[s];
        return nsum;
    }




    public static long maximizeSum(long a[], int n, int k){

        Arrays.sort(a);


        long sum=0;
        //Fliping the elements
        for(int i=0;i<n;i++){
            if(a[i]<0&& k>0){
                a[i]=a[i]*-1;
                k--;
            }
        }

        long min= Long.MAX_VALUE;
        for(int i=0;i<n;i++){

            sum=sum+(a[(int)i]*i);
            sum=sum+a[i];
            min=Math.min(min,a[i]);
        }

        if(k%2!=0)
            sum=sum-2*min;



    return sum;
    }
}
