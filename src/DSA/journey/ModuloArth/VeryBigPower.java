package DSA.journey.ModuloArth;

public class VeryBigPower {

    public static void main(String[] args) {
        int a=2;
        int b=27;
        System.out.println(new VeryBigPower().solve(a,b));
    }

    public int solve(int A, int B) {
        long mod=(long)(1e9 + 7);
//        int fact=getFact(B,mod);
//        if(fact<0){
//            fact=(fact+mod);
//        }
//        int factMod=fact%mod;

        int f=FindFactorialRecursively(B);
       int powerVal= ComputePowerFnRecursively(A,f,mod);
        return  powerVal;
//        int t=factMod%2;
//        int pow=((int)Math.pow(A,factMod));
//        if(pow<0){
//            pow=pow+mod;
//        }
//        int ans=( pow%mod)%mod;
//        if(ans<0){
//            ans=ans+mod;
//        }
//        return ((ans%mod)*t)%mod;


    }
    private static int FindFactorialRecursively(int num){
        long mod = (long)1e9 + 7;
        //Sanity Case
        if(num < 0){
            return Integer.MIN_VALUE;
        }

        //Base Case
        if(num == 1){
            return 1;
        }

        //Recurrence Relation Logic
        return (int)(num % (mod - 1) * FindFactorialRecursively(num - 1) % (mod - 1));
    }
    public static int ComputePowerFnRecursively(int A, int B, double C){
        long answer = 0;
        /*Base Case*/
        if(A == 0) return 0;

        if(B == 0) return 1;

        /*Recurrence Logic */
        if(B % 2 == 0){
            answer = ComputePowerFnRecursively(A, (B / 2), C) % (long)C;
            answer = (answer * answer) % (long)C;
        }else{
            answer = A % (long)C;
            answer = (answer * ComputePowerFnRecursively(A, (B - 1), C) % (long)C) % (long)C;
        }
        return (int)((answer + C) % C);
    }



    public int getFact(int b,int m){
        int fact=1;
        int i=1;
        while(i<=b){
            fact=(fact%m*i%m)%m;
            i++;
        }
        return fact%m;

    }
}
