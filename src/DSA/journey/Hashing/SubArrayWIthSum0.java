package DSA.journey.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayWIthSum0 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(new SubArrayWIthSum0().solve(arr));
    }

    public int solve1(int[] arr) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        int ans = 0;
        int mod=(int)Math.pow(10,9)+7;
        long prefix[] = new long[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = (arr[i]+ prefix[i - 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            if(prefix[i]==0){
                return 1;
            }
        }
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < prefix.length; i++) {
            if (map.containsKey(prefix[i])) {
                return 1;
            } else {
                map.put(prefix[i], 1);
            }
        }
        return ans;
        //   return slidingWindow(A);

    }
    public int solve(int arr[]){
        int k=0;
        // Creates an empty hashset hs
        Set<Long> hs = new HashSet<Long>();

        // Initialize sum of elements
        long sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (arr[i] == k || sum == k || hs.contains(sum))
                return 1;

            // Add sum to hash set
            hs.add(sum);
        }

        // We reach here only when there is
        // no subarray with 0 sum
        return 0;
    }





    public int slidingWindow(int arr[]) {
        int k = 0;
        int i = 0;
        int j = 0;
        int n = arr.length;
        int sum = -2147483647;
        while (j < n) {
            sum =sum + arr[j];
            if (sum < k) {
                j++;
            } else if(sum==k){
                return 1;
            }
            else{
                    while (i < n && sum > k) {
                        sum = sum - arr[i];
                        i++;
                    }
                    if (sum == k) {
                        return 1;
                    }
                    j++;

            }
        }


        while (i < n) {
            if (sum == k) {
                return 1;
            }
            sum = sum - arr[i];
            i++;
        }
        if (sum == k) {
            return 1;
        }
        return 0;
    }

}
