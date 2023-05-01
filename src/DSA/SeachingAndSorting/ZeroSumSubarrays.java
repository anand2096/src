package DSA.SeachingAndSorting;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarrays {

    public static void main(String[] args) {

        long arr[] = {0,0,5,5,0,0};
        int n=arr.length;
        System.out.println( ZeroSumSubarrays.findSubarray(arr,n));
    }
    public static long findSubarray(long[] arr ,int n)
    {
        //Your code here

        Map<Long,Long> map=new HashMap<>();
        long []prefix=new long[arr.length];
        long sum=0;
        long cnt=0;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(sum==0)cnt++;
            prefix[i]=sum;
            if(map.get(prefix[i])!=null){
                cnt=cnt+map.get(prefix[i]);
                map.put(prefix[i],map.get(prefix[i])+1);
            }
            else{
                map.put(prefix[i],Long.valueOf(1));
            }
        }
        return cnt;
    }
}
