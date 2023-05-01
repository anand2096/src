package DSA.journey.TwoPointers;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] A = { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8};
        int B = -1;
        System.out.println(new ThreeSum().threeSumClosest(A, B));
    }

    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] == target) {
                    return target;
                } else if (arr[i] + arr[j] + arr[k] < target) {
                    int d = Math.abs(target - (arr[i] + arr[j] + arr[k]));
                    if (d < diff) {
                        diff = d;
                        ans = arr[i] + arr[j] + arr[k];
                    }
                    j++;
                } else {
                    int d = Math.abs(target - (arr[i] + arr[j] + arr[k]));
                    if (d < diff) {
                        diff = d;
                        ans = arr[i] + arr[j] + arr[k];
                    }
                    k--;
                }
            }
        }
        return ans;
    }
}
