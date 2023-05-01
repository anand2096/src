package DSA.journey.feb18;

import DSA.CommonFun;

import java.util.ArrayList;

public class MinimumSwaps {

    public static void main(String[] args) {
        int[] A = {5,17,100,11};
        int B = 20;
        System.out.println(new MinimumSwaps().solve(CommonFun.createInput(A), B));
    }

    public int solve(ArrayList<Integer> list, int number) {
        int minSwaps = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int t = 0; t < list.size(); t++) {
            if (list.get(t) <= number)
                k++;
        }
        if(k==0)
            return 0;
        int badElements = 0;
        while (j < list.size()) {

            if (j - i + 1 < k) {
                if (list.get(j) > number) {
                    badElements++;
                }
                j++;
            } else if (j - i + 1 == k) {
                if (list.get(j) > number) {
                    badElements++;
                }
                minSwaps = Math.min(minSwaps, badElements);
                if (list.get(i) > number) {
                    badElements--;
                }
                i++;
                j++;
            }
        }
        return minSwaps;
    }
}
