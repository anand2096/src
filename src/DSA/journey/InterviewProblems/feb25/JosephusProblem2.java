package DSA.journey.InterviewProblems.feb25;

public class JosephusProblem2 {

    public static void main(String[] args) {
        int a=5;
        System.out.println(new JosephusProblem2().solve(a));
    }
    public int solve(int n) {
        int ans=0;
        int x=1;
        while(x*2<=n){
            x=x*2;
        }
        int numberOfKills=n-x;

        ans=1+2*numberOfKills;
        return ans;

    }
}
