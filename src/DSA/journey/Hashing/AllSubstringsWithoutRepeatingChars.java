package DSA.journey.Hashing;

import java.util.HashMap;
import java.util.Map;

public class AllSubstringsWithoutRepeatingChars {
    public static void main(String[] args) {
        String s="abccd";
        System.out.println(new AllSubstringsWithoutRepeatingChars().getSubs(s));
    }

    public  int getSubs(String s) {
        if (s.length() == 0) return 0;
        int ans = 0;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        while (j < n) {
            char ch = s.charAt(j);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                ans=ans+(j-i+1);
                j++;
            } else {

                while (i < n && s.charAt(i) != ch) {
                    map.remove(s.charAt(i));
                    i++;
                }
                map.remove(s.charAt(i));
                i++;
                map.put(ch, 1);
                ans=ans+(j-i+1);
                j++;

            }
        }

        return ans;

    }
}
