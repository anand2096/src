package DSA.journey.Strings;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {

    public static void main(String[] args) {
        String s="mlosqnouzokpcabwqgeribqurraqdqhqdyiunwonmaerchnuntlwxdsowsgajosooakbzaqlavcecrysnlqkpkancgnnwfckimoh";
        int k=1;
        System.out.println(new ReplicatingSubstring().solve(k,s));
    }
    public int solve(int k, String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ans=1;
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            if(m.getValue()!=k){
                ans=-1;
                break;
            }
        }
        return ans;

    }
}
