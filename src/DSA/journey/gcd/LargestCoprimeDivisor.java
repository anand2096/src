package DSA.journey.gcd;

public class LargestCoprimeDivisor {

    public static void main(String[] args) {
        int a=40;
        int b=24;
        System.out.println(new LargestCoprimeDivisor().cpFact(a,b));
    }

    public int cpFact(int A, int B) {

        while(gcd(A,B)!=1){

            A=A/(gcd(A,B));
        }
        return A;

    }

    public int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);

    }


}
