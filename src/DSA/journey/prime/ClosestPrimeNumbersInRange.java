package DSA.journey.prime;

import java.util.ArrayList;
import java.util.List;

public class ClosestPrimeNumbersInRange {


    public static void main(String[] args) {
        int a=10;
        int b=19;
        int ans[]=new ClosestPrimeNumbersInRange().closestPrimes(a,b);
        System.out.println(ans[0]+" "+ans[1]);
    }
    public int[] closestPrimes(int left, int right) {
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        boolean prime[]=new boolean[right+1];
        for(int i=2;i<prime.length;i++){
            prime[i]=true;
        }
        for(int i=2;i<=Math.sqrt(right);i++){
            for(int j=i*i;j<=right;j+=i){
                if(prime[j]){
                    prime[j]=false;
                }
            }
        }

        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(prime[i]){
                list.add(i);
            }
        }
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            if((list.get(i)-list.get(i-1))<diff)
            {
                diff=list.get(i)-list.get(i-1);
                ans[0]=list.get(i-1);
                ans[1]=list.get(i);
            }
            diff=Math.min(diff,list.get(i)-list.get(i-1));
        }
        return ans;
    }
}
