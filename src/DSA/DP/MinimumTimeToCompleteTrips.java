package DSA.DP;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {

    public static void main(String[] args) {
        int time[] = {3,3,3};
        int totalTrips = 5;
        System.out.println(new MinimumTimeToCompleteTrips().minimumTime(time,totalTrips));
    }

    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long l = 0;
       // long r = 100000000000000L;
        long r = (long)time[time.length-1]*totalTrips;
        long ans = r;
        while (l < r) {
            long mid = (l + r) / 2;
            long count = 0;
            for (int i = 0; i < time.length; i++) {
                count = count + (mid / time[i]);

            }
            if (count >= totalTrips) {
                ans = Math.min(ans, mid);
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
