package DSA.journey.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountRightTriangles {

    public static void main(String[] args) {

//        int [] A = {1, 1, 2, 3, 3};
//        int []B = {1, 2, 1, 2, 1};
        int [] A = {1,1,2};
        int []B = {1, 2, 1};
        System.out.println(new CountRightTriangles().solve(A,B));

    }

    public int solve(int[] x, int[] y) {
        int n=x.length;
        int ans=0;
        int mod=(int)Math.pow(10,9)+7;
        Map<Integer,Integer> hmx=new HashMap<>();
        Map<Integer,Integer>hmy=new HashMap<>();
        for(int i=0;i<x.length;i++){

            hmx.put(x[i],hmx.getOrDefault(x[i],0)+1);
        }

        for(int i=0;i<y.length;i++){

            hmy.put(y[i],hmy.getOrDefault(y[i],0)+1);
        }
        for(int i=0;i<n;i++){

            ans=(ans+(((hmx.get(x[i])-1)%mod)*((hmy.get(y[i])-1)%mod))%mod)%mod;
        }
        return ans;

    }
}
