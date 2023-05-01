package DSA.journey.BitManipulation;

public class SmallestXORSum {

    public static void main(String[] args) {
        int a=6;
        int b=7;
        System.out.println(new SmallestXORSum().solve(a,b));
    }

    public int solve(int a, int b) {
//        if(a==b)return 0;
//        int ans=Integer.MAX_VALUE;
//        int min=0;
//        min=a<b?a:b;
//        for(int i=1;i<=min;i++){
//            int temp=((a^i)+(b^i));
//            if(temp<ans){
//                ans=temp;
//            }
//        }

        if(a==b)return 0;
        int ans= (a^(a&b))+(b^(a&b));
        return ans;


    }
}
