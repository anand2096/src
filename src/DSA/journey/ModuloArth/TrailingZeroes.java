package DSA.journey.ModuloArth;

public class TrailingZeroes {

    public static void main(String[] args) {
        int n=100;
        System.out.println(new TrailingZeroes().trailingZeroes(n));
    }
    public int trailingZeroes(int number) {
        int zeroCount=0;

        for(int i=5;i<=number;i=i*5){

            zeroCount+=number/i;
        }

        return zeroCount;
    }
}
