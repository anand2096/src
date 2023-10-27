package DSA.journey.interveiwBit.week1;
import java.util.*;
public class SimpleQueries {

    public static void main(String[] args) {
        int a[]={39,99,70,24,49,13,86,43,88,74,45,92,72,71,90,32,19,76,84,46,63,15,87,1,39,58,17,65,99,43,83,245,9,64,67,100,14,17,100,81,26,45,40,95,94,86,2,89,57,52,91,45};
        int b[]={1221,360,459,651,958,584,345,181,536,116,1310,403,669,1044,1281,711,222,280,1255,257,811,409,698,74,838};
        int ans[]=new SimpleQueries().solve(a,b);
        System.out.println(Arrays.toString(ans));


    }

    public int[] solve(int[] A, int[] B) {
        int mod=(int)Math.pow(10,9)+7;
        Arrays.sort(A);
        List<Integer> list=new ArrayList<>();
        int max=A[A.length-1];
        for(int i=0;i<A.length;i++){
            int times=i+1;
            int no=A[i];
            for(int j=1;j<=times;j++){
                list.add(no);
            }
        }
        long g[]=new long[list.size()];
        Arrays.fill(g,1);
        for(int i=1;i<=max;i++){
            for(int j=0;j<list.size();j++){
                int no=list.get(j);
                if(no>=i){
                    if(no%i==0){
                        g[j]=(g[j]%mod*i%mod)%mod;
                    }
                }

            }
        }
        Arrays.sort(g);
        int ans[]=new int[B.length];
        for(int i=0;i<B.length;i++){
            int index=B[i];
            ans[i]=(int)g[index];

        }
        return ans;

    }

}
