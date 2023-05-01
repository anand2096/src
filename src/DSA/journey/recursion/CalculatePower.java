package DSA.journey.recursion;

public class CalculatePower {
    public static void main(String[] args) {
        int a=71045970;
        int b=41535484;
        int c=64735492;
//        int a=-1;
//        int b=1;
//        int c=20;
        System.out.println(new CalculatePower().powRecursion(a,b,c));
    }
    public int pow(int A, int B, int C) {
        long ans=1;
        long b=B;
        long a=A;
        if(b<0) b=-1*b;
        while(b>0){
            if(b%2==1){
                ans=(ans%C)*(a%C);
                b=b-1;
            }
            else{
                a=(a%C)*(a%C);
                b=b/2;
            }
        }
        if(ans<0){
            ans=ans+C;
        }
        return (int)(ans%C);
    }


    public int powRecursion(int A, int B, int C) {

        if(A==0) return 0;
        if(B==0)return 1;
        long ans=powRecursion(A,B/2,C);
        ans=(ans*ans)%C;
        if(B%2==1)
            ans=ans*A;
        ans=(ans+C)%C;
        return (int)ans;

    }
    public long calculatePower(int number,int power,int count,long ans,int C){
        if(power==count){
            return ans%C;
        }
        if(ans<0)
            ans=(ans+C)%C;
        long temp=((ans%C)*(number%C))%C;
        return calculatePower(number,power,count+1,temp,C);

    }
}
