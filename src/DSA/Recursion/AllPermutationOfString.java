package DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Rank{
    char c;
    int index;
    Rank(char c,int index){
        this.c=c;
        this.index=index;
    }


}

public class AllPermutationOfString {


    public static void main(String[] args) {

        String s="gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv";

        System.out.println(new AllPermutationOfString().findRank2(s));

//        int[] fac = new int[n + 1];
//        fac[0] = 1;
//
//        for (int i = 1; i <= n; i++)
//            fac[i] = fac[i - 1] * i % p;

    }

    public int findRank2(String s) {
        int n=s.length();
        long fact[]=new long[52];
        long arr []=new long[256];
        fact[0]=1;
        fact[1]=1;
        for (int i=2;i<52;i++){
            fact[i]=((i%1000003)*(fact[i-1]%1000003))%1000003;
        }
        for(int i=0;i<n;i++){
            arr[s.charAt(i)]++;
        }
        long numberOfLetterSmaller;
        long output=0;
        for(int i=0;i<n;i++){
            numberOfLetterSmaller=0;
            for(int j=0;j<256;j++){
                if(j==s.charAt(i)){
                    break;
                }
                if(arr[j]==1){
                    numberOfLetterSmaller++;
                }
            }
            arr[s.charAt(i)]=0;
            output=((output% 1000003)+(numberOfLetterSmaller% 1000003)*(fact[n-1-i]% 1000003))% 1000003;
        }
        return (int)(output+1)% 1000003;
    }
    public int findRank(String s) {
        List<List<Character>> ans=new ArrayList<>();
        char []arr=s.toCharArray();
        List<Character> temp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            temp.add(arr[i]);
        }
        Arrays.sort(arr);


        int t= rec(arr,0,ans,temp)%1000003;
        System.out.println(t);
        System.out.println(ans);
        return t;
    }

    public int rec(char[]s,int index,List<List<Character>> ans,List<Character> temp1){
        if(index==s.length){
            List<Character> temp=new ArrayList<>();
            for(int j=0;j<s.length;j++){
                temp.add(s[j]);
            }
//            if(temp.equals(temp1))
//            {System.out.println(temp);
//               System.out.println(temp1);
//                System.out.println(ans.size()+1);
//                return ans.size()+1;
//
//            }
            ans.add(new ArrayList<>(temp));
          //  System.out.println(ans);
            return -1;
        }

        for(int i=index;i<s.length;i++){
              swap(index,i,s);
              int a=rec(s,index+1,ans,temp1);
              if(a>0)return  a;
            swap(index,i,s);
        }
        return -1;
    }

    private void swap(int i, int j, char[] s) {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}
