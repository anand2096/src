package DSA.journey.BitManipulation;

public class InterestingArray {
    public static void main(String[] args) {
        int  A []= {1,2,3,4,5,6,7};
        System.out.println(new InterestingArray().solve(A));
    }

    public String solve(int[] a) {
        boolean ans=false;
        int cnt=0;
       // boolean ans=false;
        int num=a[0];
        int xor=a[0];
        for(int i=1;i<a.length;i++){
            xor=xor^a[i];
        }

        if(xor%2==0)
            ans=true;


        //just count number of odd elements, if count of odd elements if even then answer is possible .
//        for(int i=0;i<a.length;i++){
//            if((a[i]%2!=0)){
//                cnt++;
//            }
//        }
//        if(cnt%2==0)
//            ans=true;


        if(ans)
            return "Yes";
        else return "No";
    }

}
