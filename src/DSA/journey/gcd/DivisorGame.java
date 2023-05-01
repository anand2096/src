package DSA.journey.gcd;

public class DivisorGame {
    public static void main(String[] args) {
       int a=904579076;
       int b=1445;
       int c=462;
        System.out.println(new DivisorGame().solve(a,b,c));

    }
    public int solve(int A, int B, int C) {
        int LCM=lcm(B,C);
        return A/LCM;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
}
