package DSA.SlidingWindow.variable;

public class CountSubarraysWithScoreLessThanK {

    public static void main(String[] args) {
        int [] nums = {5,2,6,8,9,7};int k = 50;
        System.out.println(new CountSubarraysWithScoreLessThanK().countSubarrays(nums,k));
    }

    public long countSubarrays(int[] A, long k) {
        long res = 0, cur = 0;
        for (int j = 0, i = 0; j < A.length; ++j) {
            cur += A[j];
            while (cur * (j - i + 1) >= k)
                cur -= A[i++];
            res += j - i + 1;
        }
        return res;
    }
}
