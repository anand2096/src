package DSA.journey.DynamicProgramming;

public class WaysToDecode {

    public static void main(String[] args) {

        String s="2611055971756562";
        System.out.println( new WaysToDecode().numDecodings(s));

    }
    public int numDecodings(String s) {
        int mod=(int)Math.pow(10,9)+7;
        int n=s.length();
        int dp[]=new int[n];
        if(s.length()==1){
            if(s.charAt(0)-'0'==0)return 0;
            else return 1;
        }
        dp[0]=0;
        if(((s.charAt(1))-'0' +s.charAt(0)-'0'*10) <=26 ){
            dp[1]=1;
        }
        else{
            dp[1]=0;
        }
        for(int i=2;i<n;i++){
            int a=s.charAt(i-1)-'0';
            int b=s.charAt(i)-'0';

            if(b==0){
                if(a*10+b >26){
                    return 0;
                }
                else{
                    dp[i]=dp[i-1];
                }
            }
            else if(a*10+b<=26){
                dp[i]=(dp[i-1]+dp[i-2])%mod;
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n-1]%mod;
    }
}
