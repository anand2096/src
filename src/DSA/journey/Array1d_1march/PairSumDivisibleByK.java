package DSA.journey.Array1d_1march;

public class PairSumDivisibleByK {

    public static void main(String[] args) {
       int [] arr = {1, 2, 3, 4, 5};

        int B = 2;
    }
    public int solve(int[] arr, int m) {
        int mod=1000000009;
        long ans=0;
        int cnt[]=new int[m];
        for(int i=0;i<arr.length;i++){
            cnt[arr[i]%m]++;
        }
        ans=(ans+(((long) cnt[0] *(cnt[0]-1))/2))%mod;
        int a=1;
        int b=m-1;
        while(a<b){
            ans=(ans+ (long) cnt[a] *cnt[b])%mod;
            a++;
            b--;
        }
        if(a==b){
            ans=(ans+(((long) cnt[a] *(cnt[a]-1))/2))%mod;
        }
    return (int)(ans%mod);
    }
}
