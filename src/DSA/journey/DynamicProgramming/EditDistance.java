package DSA.journey.DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);
        return rec(n-1,m-1,word1,word2,dp);

    }

    public int rec(int i,int j,String s1,String s2,int dp[][]){

        if(i<0 ||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j))
            dp[i][j] =rec(i-1,j-1,s1,s2,dp);
        else{
            //delete
            int op1=1+rec(i-1,j,s1,s2,dp);
            //insert
            int op2=1+rec(i,j-1,s1,s2,dp);
            //replace
            int op3=1+rec(i-1,j-1,s1,s2,dp);
            dp[i][j]= Math.min(op1,Math.min(op2,op3));

        }
        return dp[i][j];
    }
}
