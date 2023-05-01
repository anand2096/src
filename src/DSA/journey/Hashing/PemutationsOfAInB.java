package DSA.journey.Hashing;


import DSA.Recursion.Permutations;

//SLIDING_WINDOW
public class PemutationsOfAInB {

    public static void main(String[] args) {

        String A = "abc";
        String B = "abcbacabc";
        //ans 5
        System.out.println(new PemutationsOfAInB().solve(A, B));

    }

    public int solve(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int ans = 0;
        int[] hashA = new int[26];
        int[] hashB = new int[26];
        for (int i = 0; i < a.length(); i++) {
            hashA[a.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;
        while (j <= bLen) {
            if (j < aLen) {
                hashB[b.charAt(j) - 'a']++;
                j++;
            } else {
                if (check(hashA, hashB)) {
                    ans++;
                }

                    if(i<bLen)
                    hashB[b.charAt(i) - 'a']--;
                    i++;

                    if(j<bLen)
                    hashB[b.charAt(j) - 'a']++;
                     j++;

            }
        }
//        if (check(hashA, hashB)) {
//            ans++;
//        }
        return ans;


    }

    private boolean check(int[] hashA, int[] hashB) {
        int len = hashA.length;
        for (int i = 0; i < len; i++) {
            if (hashA[i] != hashB[i]) {
                return false;
            }
        }
        return true;

    }
}
