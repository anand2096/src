package DSA.journey.prime;

public class FindAllPrimes {

    public static void main(String[] args) {
        int a=360;
       int ans[]=new FindAllPrimes().solve(28);
       for(int i=0;i<ans.length;i++)
           System.out.print(ans[i]+ " ");
    }

    public int[] solve(int n) {

        boolean prime []= new boolean[n+1];
       for(int i=0;i<prime.length;i++){
           prime[i]=true;
       }
       prime[0]=false;
       prime[1]=false;
       int falseCount=0;
       for(int i=2;i<=Math.sqrt(n);i++){
           for(int j=i*i;j<=n;j+=i){
               if(prime[j]) {
                   prime[j] = false;
                   falseCount++;
               }
           }
       }
        //System.out.println("falseCOunt "+falseCount);
       int ans[]=new int[n-falseCount-1];
       int j=0;
       for(int i=2;i<=n;i++){
           if(prime[i]){
               ans[j]=i;
               j++;
           }
       }
       return  ans;
    }
}
