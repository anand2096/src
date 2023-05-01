package DSA.journey.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeSum {

    public static void main(String[] args) {
    int ans[]=new PrimeSum().primesum(4);
        System.out.println(ans[0]+ " "+ans[1]);
    }

    public int[] primesum(int n) {
        int a[]=new int[2];
        a[0]=Integer.MAX_VALUE;
        a[1]=Integer.MAX_VALUE;
        boolean prime []= new boolean[n+1];
        for(int i=0;i<prime.length;i++){
            prime[i]=true;
        }
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            for(int j=i*i;j<=n;j+=i){
                if(prime[j]) {
                    prime[j] = false;
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(prime[i]){
                list.add(i);
            }
        }

        int i=0;int j=list.size()-1;
        while(i<=j){

            if(list.get(i)+list.get(j)==n){
                if(list.get(i)<a[0]) {
                    a[0] = list.get(i);
                    a[1] = list.get(j);
                }
                j--;
            }
            else if(list.get(i)+list.get(j)>n){
                j--;
            }
            else{
                i++;
            }

        }
        return  a;
    }

    public int[] primesumOptimal(int n) {
        int a[]=new int[2];
        boolean prime []= new boolean[n+1];
        for(int i=0;i<prime.length;i++){
            prime[i]=true;
        }
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            for(int j=i*i;j<=n;j+=i){
                if(prime[j]) {
                    prime[j] = false;
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(prime[i]){
                list.add(i);
            }
        }
        for(int i=0;i<list.size();i++){
            int temp=list.get(i);
            int rem=n-temp;
            if(list.contains(rem)){
                a[0]=temp;
                a[1]=rem;
                return a;
            }
        }
        return  a;
    }

}
