package DSA.journey.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;


class Dish {
    int fillingCapacity;
    int cost;

    public Dish(int fillingCapacity, int cost) {
        this.fillingCapacity = fillingCapacity;
        this.cost = cost;
    }
}
public class TusharBirthdayParty {

    public static void main(String[] args) {
    int a[]={2, 4, 6};
    int b[]={2, 1, 3};
    int c[]={2,5,3};
    //15
    int ans=new TusharBirthdayParty().solve(a,b,c);
    System.out.println(ans);

    }

    public int solve1(final int[] A, final int[] B, final int[] C) {

        int ans = 0;
        int dp[][];
        int n = B.length;
        Dish[] dishes = new Dish[n];
        for (int i = 0; i < n; i++) {
            dishes[i] = new Dish(B[i], C[i]);
        }
        Arrays.sort(dishes, Comparator.comparingInt(d -> d.fillingCapacity));

        for (int i = 0; i < A.length; i++) {
            dp= new int[n][A[i]+1];
            for(int f=0;f<n;f++)
                Arrays.fill(dp[f], -1);


            int temp=rec(n-1, A[i], B, C, dp,dishes);
//            for(int j=0;j<n;j++){
//                for(int k=0;k<A[i];k++)
//                    System.out.print(dp[j][k]+" ");
//                System.out.println("");
//            }
           // System.out.println("temp -> "+temp);
            ans=ans+temp;
        }

        return ans;
    }
    public int solve(final int[] A, final int[] B, final int[] C) {

        int ans = 0;
        int dp[][];
        int n = B.length;
        Dish[] dishes = new Dish[n];
        int k=0;
        for(int i=0;i<A.length;i++){
            k=Math.max(k,A[i]);
        }
        for (int i = 0; i < n; i++) {
            dishes[i] = new Dish(B[i], C[i]);

        }
        Arrays.sort(dishes, Comparator.comparingInt(d -> d.fillingCapacity));
        dp= new int[n][k+1];
        for(int f=0;f<n;f++)
            Arrays.fill(dp[f], -1);

        int temp=rec(n-1, k, B, C, dp,dishes);
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }

        for(int i=0;i<A.length;i++){
            ans=ans+dp[n-1][A[i]];
        }

        return ans;
    }
    public int rec(int i,int j,  int[] B, int C[], int[][] dp,Dish[] dishes ) {
        if(j<=0)return 0;
        if (i < 0) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int ch1 = rec(i - 1, j, B, C, dp,dishes);
        int ch2 = Integer.MAX_VALUE;
        if (j >= dishes[i].fillingCapacity)
            ch2 = rec(i, j - dishes[i].fillingCapacity, B, C, dp,dishes) + dishes[i].cost;

        dp[i][j] = Math.min(ch1, ch2);
        return dp[i][j];
    }




}
