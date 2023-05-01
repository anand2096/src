package DSA.journey.recursion;

public class SumOfDigits {

    public static void main(String[] args) {

        System.out.println(new SumOfDigits().solve(215));
    }
    public int solve(int n) {
        return  sod(n,0);
    }

    public int sod(int n,int sum){
        if(n==0) return sum;
        sum=sum+n%10;
        return sod(n/10,sum);

    }
}
