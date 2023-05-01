package DSA.leetCodeDaily;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String s1="horse";
        String s2="ros";
        System.out.println(new EditDistance().minDistance(s1,s2));

    }

    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);
        return rec(n-1,m-1,word1,word2,dp);

    }

    public int rec(int i,int j,String s1,String s2,int dp[][]){
        if(i<0) return j+1;

        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=rec(i-1,j-1,s1,s2,dp);

        return dp[i][j]=1+Math.min(rec(i-1,j,s1,s2,dp),Math.min(rec(i,j-1,s1,s2,dp),rec(i-1,j-1,s1,s2,dp)));

    }
}
