package DSA.journey.sorting;

import DSA.CommonFun;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumandMinimumMagic {

    public static void main(String[] args) {
       int [] A = {2,2};
        int ans[]=new MaximumandMinimumMagic().solve(A);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public int[] solve(int[] a) {
        int mod=(int)Math.pow(10,9)+7;
        int ans[]=new int[2];
        Arrays.sort(a);
        int len=a.length;
        int l2=len/2;
        int max=0;
        int min=0;
        for(int i=0;i<l2;i++){
            max=((max%mod)+(Math.abs(a[i+l2]-a[i]))%mod)%mod;
        }
        for(int i=0;i<len-1;i+=2){
            min=((min%mod)+(Math.abs(a[i]-a[i+1]))%mod)%mod;
        }

        ans[0]=max%mod;
        ans[1]=min%mod;
        return ans;

    }

}
