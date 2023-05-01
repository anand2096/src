package DSA.journey.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Temp {

    public static void main(String[] args) {
        int ans=Integer.MAX_VALUE;
        int arr[]={};
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                if(ans<i-map.get(arr[i])){
                    ans=i-map.get(arr[i]);

                }
                map.put(arr[i],i);
            }
            else{
                map.put(arr[i],i);
            }
        }

    }
}
