package DSA.journey.BinarySearch;

public class NthMagicalNumber {

    public static void main(String[] args) {
       int A = 807414236;
        int B =3788;
        int C = 38141;
        System.out.println(new NthMagicalNumber().solve(A,B,C));
    }


    public int solve(int A, int B, int C) {
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        long low=Math.min(B,C);
        long high= (long) A *Math.min(B,C);
        int lcm=B*C/gcd(B,C);
        while(low<=high){
            long mid=(low+(high-low)/2);

            long cnt=(mid/B)+(mid/C)-(mid/lcm);
            if(cnt==A){
                ans=mid;
                high=mid-1;
            }
            else if(cnt<A){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }

    return (int)((ans%mod)%mod);
    }

    public int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
}
