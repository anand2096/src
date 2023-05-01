package DSA.leetCodeDaily;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(4));

    }
    public int tribonacci(int n) {

        int i=3;
        int first=0;
        int second=1;
        int third=1;
        int sum=0;
        while(i<=n){
            sum=first+second+third;
            first=second;
            second=third;
            third=sum;
            i++;

        }
        return sum;

    }
}
