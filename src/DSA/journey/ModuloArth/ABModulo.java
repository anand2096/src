package DSA.journey.ModuloArth;

public class ABModulo {

    public static void main(String[] args) {
int a=106978;
int b=4487506;
        System.out.println(b%a);
        System.out.println(new ABModulo().solve(a,b));
    }

    public int solve(int A, int B)
    {
        int ans=0;
        int a=A<B?A:B;
        int b=A>B?A:B;
        int s=a;
        int big=b;
        int bms=big%s;

        while(bms>=1){
            if(A%bms==B%bms){
                return bms;
            }
            else{
                bms--;
            }
        }
        return 0;
    }
//    public int solve(int A, int B)
//    {
//        int ans=0;
//        int a=A<B?A:B;
//        int b=A>B?A:B;
//
//        while(b>=1){
//            if(A%b==B%b){
//                return b;
//            }
//            else{
//                b--;
//            }
//        }
//        return ans;
//    }
}
