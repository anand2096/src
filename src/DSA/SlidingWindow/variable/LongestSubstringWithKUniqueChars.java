package DSA.SlidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {

    public static void main(String[] args) {
        String s="aabacbebebe";
        int k=3;
        char [] arr=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        int max= Integer.MIN_VALUE;
        while(j<arr.length){

            char c=arr[j];
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
            if(map.size()<k) j++;
            else if(map.size()==k){
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(map.size()>k){
                while(map.size()>k) {
                    char remove = arr[i];
                    map.put(remove, map.get(remove) - 1);
                    if (map.get(remove) == 0)
                        map.remove(remove);
                    i++;
                }
                j++;
            }
        }

        System.out.println(max);
    }


}
