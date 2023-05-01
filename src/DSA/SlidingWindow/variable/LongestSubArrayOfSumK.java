package DSA.SlidingWindow.variable;

public class LongestSubArrayOfSumK {
    public static void main(String[] args) {

        int arr[] = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int i = 0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (j < arr.length) {
            sum = sum + arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (sum > k) {

                while (sum > k) {
                    sum = sum - arr[i];
                    i++;

                }
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }

        }
        System.out.printf("max :: " + max);

    }
}
