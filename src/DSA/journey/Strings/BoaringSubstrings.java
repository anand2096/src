package DSA.journey.Strings;

import java.util.HashSet;
import java.util.Set;

public class BoaringSubstrings {

    public static void main(String[] args) {
        String s="abcd";
        System.out.println(new BoaringSubstrings().solve(s));
    }
    public int solve(String s) {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c%2==0){
                set.add(c);
            }

        }
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c%2==1){
                int c1=s.charAt(i)-1;
                int c2=s.charAt(i)+1;

                if(set.contains((char)c1) &&set.contains((char)c2)){
                    if(set.size()>2){
                        return 1;
                    }
                }
                else if(set.contains((char)c1)||set.contains((char)c2)){
                    if(set.size()>1){
                        return 1;
                    }
                }
                else{
                    if(set.size()>=1){
                        return 1;
                    }
                }
            }
        }
        return 0;

    }
}
