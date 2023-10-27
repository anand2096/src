package DSA.journey.DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {

    int ans;
    public int numDistinct(String s1, String s2) {
        ans=0;
        int n=s1.length();
        int dp[]=new int[s1.length()];
        Arrays.fill(dp,0);
        rec(0,s1.length(),"",s1,s2,dp);
        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
        return dp[n-1];


    }
    public int rec(int i,int n,String temp,String s1,String s2,int [] dp){
       System.out.println("temp->"+temp);
        if(i==n){

            if(temp.equals(s2)){
                return 1;
            }
            else
                return 0;
        }
        if(dp[i]!=0)return dp[i];

        int ch1=rec(i+1,n,temp+s1.charAt(i),s1,s2,dp);
        int ch2=rec(i+1,n,temp,s1,s2,dp);
        dp[i]=ch1+ch2;
        return dp[i];

    }
    public static void main(String[] args) {
        String s="aaaababbababbaabbaaababaaabbbaaabbb";
        String t="bbababa";
        int fa=new DistinctSubsequences().numDistinct(s,t);
        System.out.println(fa);

    }

}
