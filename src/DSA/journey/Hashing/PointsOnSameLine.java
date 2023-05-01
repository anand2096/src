package DSA.journey.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PointsOnSameLine {

    public static void main(String[] args) {
        int [] A = {2, 1, -7, 4, 1, -2, -7, 5 };
     int[]   B ={-6, -7, 3, -10, 7, -10, 1, 2  };
        System.out.println(new PointsOnSameLine().solve(A,B));

    }
    public int solve(int[] a, int[] b) {
        int n=a.length;
        if(n<2)return n;
        int max=1;
        for(int i=0;i<n;i++){
            int same=0;
            int localMax=0;
            int x1=a[i];
            int y1=b[i];
            Map<String,Integer> map =new HashMap<>();

            for(int j=i+1;j<n;j++){
                int x2=a[j];
                int y2=b[j];
                if(isSame(x1,y1,x2,y2)){
                    same++;
                    continue;
                }
                int x2_x1=x2-x1;
                int y2_y1=y2-y1;
                int g=gcd(x2_x1,y2_y1);
                x2_x1/=g;
                y2_y1/=g;
                map.put(x2_x1+"_"+y2_y1,map.getOrDefault(x2_x1+"_"+y2_y1,0)+1);
                localMax=Math.max(localMax,map.get(x2_x1+"_"+y2_y1));
            }
            map.clear();
            max=Math.max(max,localMax+same+1);
        }
        return max;
    }




    private boolean isSame(int x1, int y1, int x2, int y2) {
        return x1==x2 && y1==y2;
    }



    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
