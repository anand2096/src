package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    List<Integer> ans=new ArrayList<>();

    public static void main(String[] args) {
        String s = "abab";
        String p= "ab";
//        String s1 = "ab";
//        String s2 = "eidbaooo";
        List<Integer> ans = new FindAllAnagramsInAString().findAnagrams(s, p);
        System.out.println(ans);

    }
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        Map<Character, Integer> pattern = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (pattern.containsKey(p.charAt(i))) {
                pattern.put(p.charAt(i), pattern.get(p.charAt(i)) + 1);
            } else {
                pattern.put(p.charAt(i), 1);
            }
        }
        int count = pattern.size();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (j - i + 1 < k) {
                if (pattern.containsKey(s.charAt(j))) {
                    pattern.put(s.charAt(j), pattern.get(s.charAt(j)) - 1);
                    if (pattern.get(s.charAt(j)) == 0) {
                        count--;
                    }
                }
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    ans.add(i);
                } else {
                    if (pattern.containsKey(s.charAt(j))) {
                        pattern.put(s.charAt(j), pattern.get(s.charAt(j)) - 1);
                        if (pattern.get(s.charAt(j)) == 0) {
                            count--;
                        }
                        if (count == 0)
                            ans.add(i);
                    }
                    if (pattern.containsKey(s.charAt(i))) {
                        pattern.put(s.charAt(i), pattern.get(s.charAt(i)) + 1);
                        if(pattern.get(s.charAt(i))==1)
                            count++;

                    }
                    i++;
                    j++;
                }
            }
        }
        return ans;
    }


    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()==1){
            s2.contains(s1);
            return  true;
        }
        boolean ans = false;
        int k = s1.length();
        Map<Character, Integer> pattern = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (pattern.containsKey(s1.charAt(i))) {
                pattern.put(s1.charAt(i), pattern.get(s1.charAt(i)) + 1);
            } else {
                pattern.put(s1.charAt(i), 1);
            }
        }
        int count = pattern.size();
        int i = 0, j = 0;
        while (j < s2.length()) {
            if (j - i + 1 < k) {
                if (pattern.containsKey(s2.charAt(j))) {
                    pattern.put(s2.charAt(j), pattern.get(s2.charAt(j)) - 1);
                    if (pattern.get(s2.charAt(j)) == 0) {
                        count--;
                    }
                }
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    return true;
                } else {
                    if (pattern.containsKey(s2.charAt(j))) {
                        pattern.put(s2.charAt(j), pattern.get(s2.charAt(j)) - 1);
                        if (pattern.get(s2.charAt(j)) == 0) {
                            count--;
                        }
                        if (count == 0)
                            return true;
                    }
                    if (pattern.containsKey(s2.charAt(i))) {
                        pattern.put(s2.charAt(i), pattern.get(s2.charAt(i)) + 1);
                        if(pattern.get(s2.charAt(i))==1)
                            count++;

                    }
                    i++;
                    j++;
                }
            }
        }


        return ans;

    }
}
