package DSA.journey.feb18;

public class SpecialSubsequences {
    public static void main(String[] args) {
        String s="ABCGAG";
        System.out.println(new SpecialSubsequences().solve(s));
    }

    public int solve(String s) {
        int ans=0;
        int len=s.length()-1;
        int cnt=0;
        for(int i=len;i>=0;i--){

            if(s.charAt(i)=='G'){
                cnt=cnt+1;
            }
            else if(s.charAt(i)=='A'){
                ans=(ans%1000000007)+(cnt%1000000007);
            }
        }

        return (ans%1000000007);
    }
}
