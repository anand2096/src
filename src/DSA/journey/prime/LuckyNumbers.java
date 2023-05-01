package DSA.journey.prime;

import java.util.HashSet;
import java.util.Set;

public class LuckyNumbers {

//
//    A lucky number is a number that has exactly 2 distinct prime divisors.
//
//    You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).


    public static void main(String[] args) {
        int num=12;
        System.out.println(new LuckyNumbers().solve(num));
    }
    public int solve(int number) {
        int ans=0;
        int []spf=new int[number+1];
//        for(int i=1;i<spf.length;i++){
//            spf[i]=i;
//        }
        for(int i=2;i<=number;i++){
//            if(spf[i]==0)
//                continue;
            for(int j=i*i;j<=number;j+=i){
//                if(spf[j]==j)
                {spf[j]++;}

            }
        }

        for(int i=1;i<=number;i++){
            int num=i;
            Set<Integer> set=new HashSet<>();
            while(num>1){
                int p=spf[num];
                set.add(p);
                while(num%p==0){
                    num=num/p;
                }
            }
            if(set.size()==2)
                ans++;

        }


        return ans;
    }
}
