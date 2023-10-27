package DSA.journey.Hashing;

import java.util.*;

public class CountGoodMeals {

    public static void main(String[] args) {
    int arr[]={1,3,5,7,9};
        System.out.println(new CountGoodMeals().countPairs(arr));
    }

    public int countPairs(int[] deliciousness) {
        int mod=(int)Math.pow(10,9)+7;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        int x=1;
        list.add(1);
        for(int i=1;i<=21;i++){
            x=x*2;
            list.add(x);
        }
        long ans=0;

        for(int i=0;i<deliciousness.length;i++){

            for(int power:list){
                if(map.containsKey(power- deliciousness[i])) {
                    ans = ans + map.get(power - deliciousness[i]);
                }
            }
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0)+1);
        }
      //  System.out.println(set);
        return (int)ans%mod;
    }
}
