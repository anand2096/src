package DSA.journey.gcd;

import java.math.BigInteger;

public class EnumeratingGcd {
    public static void main(String[] args) {
         String A = "100";
       String B = "100000";
        System.out.println(new EnumeratingGcd().solve(A,B));
    }
    public String solve(String A, String B) {
        BigInteger a= new BigInteger(A);
        BigInteger  b= new BigInteger(B);

        BigInteger ans=gcd(a,b);
        return String.valueOf(ans);

    }
    public BigInteger gcd(BigInteger a,BigInteger b){
        if(a.equals(new BigInteger("0")))
            return b;
        return gcd(b.mod(a),a);
    }
}
