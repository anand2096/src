package DSA.leetCodeDaily;

import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int []piles = {3,6,7,11};
        int h =8;
        System.out.println( new KokoEatingBananas().minEatingSpeed(piles,h));
    }


    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int low = 1, high = 1000000000, k = 0;
        while (low <= high) {
            k = (low + high) / 2;
            int h = 0;
            for (int i = 0; i < piles.length; i ++)
                h += Math.ceil(1.0 * piles[i] / k);
            if (h > H)
                low = k + 1;
            else
                high = k - 1;
        }
        return low;
    }}

