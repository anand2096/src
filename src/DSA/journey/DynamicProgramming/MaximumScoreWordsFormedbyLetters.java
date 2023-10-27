package DSA.journey.DynamicProgramming;
import java.util.*;
public class MaximumScoreWordsFormedbyLetters {


    public static void main(String[] args) {
          String [] words = {"azb","ax","awb","ayb","bpppp"};
          char [] letters ={'z','a','w','x','y','b','p','p','p'};
          int []score = {10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,3,2,3,3};
        System.out.println( new MaximumScoreWordsFormedbyLetters().maxScoreWords(words,letters,score));
    }


    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //frequency aray
        int[]freq=new int[26];
        for(int i=0;i<letters.length;i++){
            char c=letters[i];
            freq[c-97]++;
        }
        if(words.length==1){
            int sum=0;
            for(int i=0;i<words[0].length();i++){
                char ch=words[0].charAt(i);
                if(freq[ch-97]==0)return 0;
                freq[ch-97]--;
                sum=sum+score[ch-97];
            }
            return sum;
        }
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);


        int ans= rec(n-1,words,freq,score,dp);
        return ans;
    }

    public int rec(int ind, String [] words, int[]freq,int []score,int[]dp){

        if(ind<0)return 0;

        int val=calculate(words[ind],freq,score);
        //pick
        int ch1=rec(ind-1,words,freq,score,dp)+val;
        if(val>0){
            addFreqAgain(words[ind],freq);
        }
        //not pick
        int ch2=rec(ind-1,words,freq,score,dp);

        return dp[ind]=Math.max(ch1,ch2);

    }

    public void addFreqAgain(String word,int []freq){
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            freq[ch-97]++;
        }
    }
    public int calculate(String word,int freq[],int []score){

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(freq[ch-97]==0){
                return 0;
            }

        }

        int sum=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            freq[ch-97]--;
            sum=sum+score[ch-97];
        }
        return sum;

    }
}
