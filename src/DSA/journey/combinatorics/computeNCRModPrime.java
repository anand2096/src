package DSA.journey.combinatorics;

public class computeNCRModPrime {

    public static void main(String[] args) {
       int A = 8458;
      int  B = 506;
        int C = 540907;

        System.out.println(new computeNCRModPrime().solve(A,B,C));
    }
    public int solve(int n, int r, int m) {
        long ans=1;
        long nFact=getFact(n,m);
        long ncrFact=getFact(n-r,m);
        long rFact=getFact(r,m);
        long ncrFactInverse=getPower(ncrFact,m-2,m);
        long rFactInverse=getPower(rFact,m-2,m);

         ans=((ans)*(nFact))%m;
        ans=((ans)*(ncrFactInverse))%m;
        ans=((ans)*(rFactInverse))%m;

        if(ans<0)
            ans=ans+m;
        return (int)ans%m;


    }
    public int getPower(long num,long power, int mod){
     long ans=1;
     long nn=power;
     if(nn<0) nn=-1*nn;
     while(nn>0){
         if(nn%2==1){
             ans=((ans%mod)*(num%mod))%mod;
             nn=nn-1;
         }
         else{
             num=((num%mod)*(num%mod))%mod;
             nn=nn/2;
         }
     }
     if(num<0)ans=1/ans;
     if(ans<0)ans=ans+mod;
     return (int)ans%mod;

    }

    public long getFact(long num,int mod){
        long fact=1;
        for(int i=1;i<=num;i++){
            fact=((fact%mod)*(i%mod))%mod;
        }
        if(fact<0){
            fact=fact+mod;
        }
        return fact%mod;

    }


}
