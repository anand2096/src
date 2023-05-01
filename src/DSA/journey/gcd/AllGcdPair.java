package DSA.journey.gcd;

import java.util.*;

public class AllGcdPair {
    public static void main(String[] args) {
        int arr[]={5,5,5,15};
        ArrayList<Integer> inp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            inp.add(arr[i]);
        }
        System.out.println(new AllGcdPair().solve(inp));
    }
    public ArrayList<Integer> solve(ArrayList<Integer>arr ) {
        ArrayList<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        Collections.sort(arr);
        Collections.reverse(arr);
        for(int i=0;i<arr.size();i++){

            if(map.containsKey(arr.get(i))){
               map.put(arr.get(i),map.get(arr.get(i))-1);
               if(map.get(arr.get(i))==0){
                   map.remove(arr.get(i));
               }
            }
            else{
                for(int num:ans){
                    int g=gcd(num,arr.get(i));
                        map.put(g,map.getOrDefault(g,0)+2);
                }
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
        public int gcd(int a,int b){
            if(a==0)return b;
            return gcd(b%a,a);
        }




}
