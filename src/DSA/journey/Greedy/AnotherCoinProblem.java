package DSA.journey.Greedy;

public class AnotherCoinProblem {

    public static void main(String[] args) {
        int n=3125;
        System.out.println(new AnotherCoinProblem().solve(n));
    }

    public int solve(int n) {
        if(n<5)return n;
        int i=0;
        while(true){
            int pow=(int)Math.pow(5,i);
            if(pow<=n){
                i++;
            }
            else{
                break;
            }
        }
        i=i-1;
        int ans=0;
        int p=(int )Math.pow(5,i);
        int div=n/p;
        int rem=n%p;
        ans=ans+div;
        i=i-1;
        while(rem>=5){
            p=(int)Math.pow(5,i);
            div=(rem)/p;
            ans=ans+div;
            rem=rem%p;
            i--;
        }
        return ans+rem;
    }
}
