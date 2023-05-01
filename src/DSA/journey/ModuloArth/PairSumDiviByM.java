package DSA.journey.ModuloArth;

public class PairSumDiviByM {

    public static void main(String[] args) {
        int [] A = {1, 2, 3, 4, 5};
        int B = 2;
        System.out.println(new PairSumDiviByM().solve(A, B));
    }
    public int solve(int[] arr, int m) {
        long mod=(int)Math.pow(10,9)+7;
        long ans=0;
        long cnt[]=new long[m];
        for(int i=0;i<arr.length;i++){
            cnt[arr[i]%m]++;
        }
        ans=(ans%mod+(( cnt[0]%mod *(cnt[0]-1)%mod)/2))%mod;
        long a=1;
        long b=m-1;
        while(a<b){
            ans=(ans%mod+ cnt[(int)a]%mod *cnt[(int)b]%mod)%mod;
            a++;
            b--;
        }
        if(a==b){
            long v=cnt[(int)a];
            ans=(ans%mod+(((v)*(v-1))/2)%mod)%mod;
        }
        return (int)(ans%mod);
    }
}
