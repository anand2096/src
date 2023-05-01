package DSA.SlidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeatingChars {

    public static void main(String[] args) {
        String s = "abcabcbb";//dvdf
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        while(j<arr.length){
            char c=arr[j];
            if(map.containsKey(c)){
                max=Math.max(max,j-i);
                map.clear();
                map.put(c,1);
                int k=j-1;
                while(c!=arr[k]){
                    map.put(arr[k],1);
                    k--;
                }
                i=k+1;
                j++;

            }else{
                map.put(c,1);
                j++;
            }
        }
        max=Math.max(max,j-i);
        System.out.println(max);
    }
}
