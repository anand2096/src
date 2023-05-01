package DSA.SlidingWindow.constant;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfAnagrams {

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(new CountOccurencesOfAnagrams().search(pat,txt));
    }
    int search(String pat, String txt) {
        // code here
        int ans=0;
        int k=pat.length();
        Map<Character,Integer> pattern=new HashMap<>();
        Map<Character,Integer> curr=new HashMap<>();
        for(int i=0;i<pat.length();i++)
        {
            if(pattern.containsKey(pat.charAt(i))){
                pattern.put(pat.charAt(i),pattern.get(pat.charAt(i))+1);
            }
            else {
                pattern.put(pat.charAt(i),1);
            }
        }
        int i=0,j=0;
        while(j<txt.length()){

            if(j-i+1<k) {
                if (curr.containsKey(txt.charAt(i))) {
                    curr.put(txt.charAt(j), curr.get(txt.charAt(i)) + 1);
                } else {
                    curr.put(txt.charAt(i), 1);
                }
                j++;
            }
            else if(j-i+1==k){


            }
        }




        return -1;
    }

}
