package DSA.journey.DynamicProgramming;

import java.util.Arrays;

public class LongestPallindromicSubs {

    public static void main(String[] args) {
        String s="aedsead";
        System.out.println(new LongestPallindromicSubs().solve(s));
    }

    public int solve(String s) {

        int n=s.length();
        int dp[]=new int[n];
       Arrays.fill(dp,-1);
        rec(0,"",s,dp);
         for(int i=0;i<n;i++){
             System.out.print(dp[i]+" ");
         }
        return dp[0];
    }

    public int rec(int i, String temp,String s, int[]dp){

        if(i==s.length()){
            if(isValid(temp)){
                System.out.println(temp);
                int len= temp.length();
                return len;
            }
            return Integer.MIN_VALUE;
        }

        if(dp[i]!=-1)return dp[i];

        //pick
        int ch1=rec(i+1,temp+s.charAt(i),s,dp);

        //not pick

        int ch2=rec(i+1,temp,s,dp);

        dp[i]=Math.max(ch1,ch2);
        return dp[i];


    }


    public boolean isValid(String s){

        int i=0;
        int j=s.length()-1;
        boolean flag=true;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                flag=false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
}
