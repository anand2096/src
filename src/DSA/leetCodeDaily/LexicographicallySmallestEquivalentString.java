package DSA.leetCodeDaily;

import java.util.*;

public class LexicographicallySmallestEquivalentString {


    public static void main(String[] args) {
        ///   String s1="parker"; String s2="morris"; String baseStr="parser";

        String s1 = "hello";
        String s2 = "world";
        String baseStr = "hold";

        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString(s1, s2, baseStr));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, TreeSet<Character>> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            boolean c1Present = map.containsKey(c1);
            boolean c2Present = map.containsKey(c2);
            if (c1Present && c2Present) {
                map.get(c1).addAll(map.get(c2));
                map.get(c2).forEach(oldC2Match -> map.put(oldC2Match, map.get(c1)));
            } else if (c1Present) {
                map.get(c1).add(c2);
                map.put(c2, map.get(c1));

            } else if (c2Present) {
                map.get(c2).add(c1);
                map.put(c1, map.get(c2));

            } else {

                TreeSet<Character> set = new TreeSet<>();
                set.add(c1);
                set.add(c2);
                map.put(c1, set);
                map.put(c2, set);
            }
        }
        String ans="";
        for(char c:baseStr.toCharArray()){
            ans+=map.containsKey(c)?map.get(c).first():c;
        }
        return ans;
    }
}
