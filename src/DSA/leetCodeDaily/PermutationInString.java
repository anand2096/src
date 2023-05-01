package DSA.leetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
//        String s1 = "ab";
//        String s2 = "eidbaooo";
        boolean ans = new PermutationInString().checkInclusion(s1, s2);
        System.out.println(ans);

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

    private boolean getAllPermutationTLE(int index, char[] s1, String s2) {
        if (index == s1.length) {
            String temp = "";
            for (int t = 0; t < s1.length; t++) {
                temp = temp + s1[t];
            }
            if (s2.contains(temp))
                return true;
            return false;
        }


        for (int i = index; i < s1.length; i++) {
            swap(i, index, s1);
            if (getAllPermutationTLE(index + 1, s1, s2)) return true;
            else {
                swap(i, index, s1);
            }
        }


        return false;
    }

    private void swap(int i, int j, char[] nums) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
