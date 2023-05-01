package DSA.SlidingWindow.variable;

//https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        String s ="xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
//        String t = "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";

//String s="0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes";
//String t="rsm2ty04PYPEOPYO5";
//        String s = "AAABC";
//        String t = "ABC";
        String s = "TOTMTAPTAT";
        String t = "TTA";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Input string is null");
        }
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int count = t.length();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < s.length()) {
            char eChar = s.charAt(j);
            if (map.containsKey(eChar)) {
                int temp = map.get(eChar);
                if (temp > 0) {
                    count--;
                }
                map.put(eChar, temp - 1);
            }
            j++;

            while (count == 0) {
                if (minLen > j - i) {
                    minLen = j - i;
                    minStart = i;
                }
                char sChar = s.charAt(i);
                if (map.containsKey(sChar)) {
                    int temp = map.get(sChar);
                    if (temp == 0) {
                        count++;
                    }
                    map.put(sChar, temp + 1);
                }
                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }



    public String minWindow1(String s, String t) {
        String ans = "";
        int min = Integer.MAX_VALUE;
        int minI = -1;
        int minJ = -1;
        if (t.length() == 1) {
            if (s.contains(t)) {
                return t;
            } else {
                return ans;
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = map.size();
        int i = 0;
        int j = 0;
        int n = s.length();
        while (j <= n) {
            char c='-';
//            String s="ADOBECODEBANC";
//            String t="ABC";
            if(j<n)
                 c = s.charAt(j);
            if (!map.containsKey(c)) {
                j++;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                    if (count == 0) {
                        if (j - i + 1 < min) {
                            min = j - i + 1;
                            minI = i;
                            minJ = j;
                        }
                    }
                }
                while (count == 0) {
                    char c1 = s.charAt(i);
                    if (!map.containsKey(c1)) {
                        i++;
                        if (j - i + 1 < min) {
                            min = j - i + 1;
                            minI = i;
                            minJ = j;
                        }
                    } else {
                        map.put(c1, map.get(c1) + 1);
                        if (map.get(c1) == 0 && count == 0) {
                            if (j - i + 1 < min) {
                                min = j - i + 1;
                                minI = i;
                                minJ = j;
                            }

                        } else {
                            if(map.get(c1)==1)
                            count++;
                        }
                        i++;
                    }
                }
                j++;
            }

        }

//        while (i<n) {
//            char c1 = s.charAt(i);
//            if (!map.containsKey(c1)) {
//                if (j - i + 1 < min) {
//                    min = j - i + 1;
//                    minI = i;
//                    minJ = j;
//                }
//                i++;
//            }
//            else{
//                map.put(c1, map.get(c1) - 1);
//            }
//
//        }
//
//        while (i < n) {
//            char c='-';
////            String s="ADOBECODEBANC";
////            String t="ABC";
//            c = s.charAt(i);
//            if (!map.containsKey(c)) {
//                i++;
//                if (count==0 && j - i + 1 < min) {
//                    min = j - i + 1;
//                    minI = i;
//                    minJ = j;
//                }
//
//            } else {
//                map.put(c, map.get(c)+1);
//
//
//            }
//
//        }
        if(minI!=-1&&minJ!=-1)
        ans=s.substring(minI,minJ+1);
        return ans;

    }




}
