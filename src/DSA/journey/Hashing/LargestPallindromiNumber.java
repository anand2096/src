package DSA.journey.Hashing;

import java.util.ArrayList;
import java.util.List;

public class LargestPallindromiNumber {

    public static void main(String[] args) {
    String s="000005";
        System.out.println(new LargestPallindromiNumber().largestPalindromic(s));
    }
//7449447

    public String largestPalindromic(String num) {
        int zeroFreq=0;
        List<Integer> digits=new ArrayList<>();
        int digitFreq[]=new int[10];
        for(int i=0;i<num.length();i++){
            int no=Integer.parseInt(String.valueOf(num.charAt(i)));
            digitFreq[no]++;
        }
        zeroFreq=digitFreq[0];
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        for(int i=9;i>=0;i--){
            if(digitFreq[i]>1){
                int freq=digitFreq[i];
                for(int j=1;j<=freq/2;j++){
                    s1.append(String.valueOf(i));
                    s2.append(String.valueOf(i));
                }
                if(freq%2==0){
                    digitFreq[i]=0;
                }
                else{
                    digitFreq[i]=1;
                }
            }
        }
        for(int i=9;i>=0;i--){
            if(digitFreq[i]!=0){
                s2.append(String.valueOf(i));
                break;
            }
        }
        StringBuilder a=new StringBuilder(s1.toString()+s2.reverse().toString());
        int c=0;
        int i=0;
        while(i<a.length()&&a.charAt(i)=='0'){
            c++;
            i++;
        }
        String ans=a.toString();
        if(c>0){
            ans=ans.substring(c);
            int len=ans.length();
            if(len>0)
            ans=ans.substring(0,len-c);
        }



        if(ans.length()==0){
            if(zeroFreq>0){
                return "0";
            }
        }
        return ans;
    }
}
