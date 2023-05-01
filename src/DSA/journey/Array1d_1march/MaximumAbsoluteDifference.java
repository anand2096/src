package DSA.journey.Array1d_1march;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumAbsoluteDifference {

    public static void main(String[] args) {
       int arr[] = {-100, -100, -83, -78, -95, -98, -87, -73, -71, -68, -65, -65, -64, -61, -58, -60, -51, -50, -43, -42, -41, -38, -35, -23, -7, -4, 17, 12, 12, 9, -3, 22, 30, 36, 40, 42, 41, 43, 81, 82, 56, 47, 61, 67, 44, 59, 84, 85, 87, 97  };
        System.out.println(new MaximumAbsoluteDifference().maxArr(arr));
    }
    public int maxArr(int[] arr) {

        int n=arr.length;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max1=Math.max(max1,(arr[i]+i));
            max2=Math.max(max2,(-arr[i]+i));
            min1=Math.min(min1,arr[i]+i);
            min2=Math.min(min2,(-arr[i]+i));
        }
        int ans=Math.max((max1-min1),(max2-min2));
        return ans;
    }
    public int maxArrTLE(int[] arr) {
        int mod=1000000009;
        int ans=Integer.MIN_VALUE;
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        if(map.size()==1)
            return arr[0];
        Arrays.sort(arr);

       int i=0;

       while(i<arr.length) {
           int j=arr.length-1;
           while (i < j) {
               long diff = Math.abs((arr[i] - arr[j]) % mod);
               long indexDiff = Math.abs(map.get(arr[i]) - map.get(arr[j]));
               ans = Math.max(ans, (int) (diff + indexDiff));

               //  i++;
               j--;
           }
           i++;
       }

//        for(int i=0;i<arr.length-1;i++){
//            for(int j=i+1;j<arr.length;j++){
//                long diff=Math.abs((arr[j]-arr[i])%mod);
//                long indexDiff=Math.abs(i-j);
//                ans=Math.max(ans,(int)(diff+indexDiff));
//
//            }
//        }
        if(ans==Integer.MIN_VALUE)
            return 0;
    return ans;
    }
}
