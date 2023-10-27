package DSA.journey.combinatorics;

public class NCR_P_NOTPRIME {

    public static void main(String[] args) {
        int n=5;
        int r=1;
        int m=16;
        System.out.println(new NCR_P_NOTPRIME().solve(n,r,m));
    }
    public int solve(int n, int r, int m) {
        long ans=1;
        long nFact=getFact(n,m);
        long ncrFact=getFact(n-r,m);
        long rFact=getFact(r,m);
        boolean isPrime=isPrime(m);
        long ncrFactInverse=0;
        long rFactInverse=0;
        if(isPrime){
            ncrFactInverse=getPower(ncrFact,m-2,m);
            rFactInverse=getPower(rFact,m-2,m);
        }
        else{
            int temp1=1;
            for(temp1=1;temp1<=m;temp1++){
                if((ncrFact*temp1)%m==1){
                    break;
                }
            }
            int temp2=1;
            for(temp2=2;temp2<=m;temp2++){
                if((rFact*temp2)%m==1){
                    break;
                }
            }
            ncrFactInverse=temp1;
            rFactInverse=temp2;
        }

        ans=((ans)*(nFact));
        ans=((ans)*(ncrFactInverse))%m;
        ans=((ans)*(rFactInverse))%m;

        if(ans<0)
            ans=ans+m;
        return (int)ans%m;


    }

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
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
            fact=((fact)*(i));
        }

        return fact;

    }
}
