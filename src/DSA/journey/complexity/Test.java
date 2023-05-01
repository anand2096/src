package DSA.journey.complexity;

public class Test {
    public static void main(String[] args) {
        int N=36;
        int cnt=0;
        for(int i=1;i<=Math.sqrt(N);i++){

            if(N%i==0){
                if(i==N/i) cnt++;
                else cnt=cnt+2;
                System.out.println(i+" "+N/i);
            }
        }
        System.out.println();
        System.out.println(cnt);
    }

}
