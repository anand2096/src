package DSA;

import java.util.Arrays;

public class Solution {
    int mod=1000000009;
    public int solve(int[] a) {
        int n=a.length;
        int max = Arrays.stream(a).max().getAsInt();

        // To store the frequency of each element
        long []cnt=new long[max + 1];

        // Store the frequency of each element
        for (int i = 0; i < n; i++)
            cnt[a[i]]++;

        // To store the required answer
        long ans = 0;

        // For all valid pairs
        for (int i = 1; i <= max; i++)
        {
            for (int j = 1; j <= max; j++)
            {

                // Update the count
                ans = (ans +( (cnt[i]) * (cnt[j] * (i % j)) )%mod  )%mod;
                ans = ans % mod;
            }
        }

        return (int)(ans%mod);
    }




}
