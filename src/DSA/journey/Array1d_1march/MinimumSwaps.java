package DSA.journey.Array1d_1march;

import DSA.CommonFun;

import java.util.ArrayList;

public class MinimumSwaps {

    public static void main(String[] args) {
        int[] a = { 52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70 };
        int b = 19;
        System.out.println(new MinimumSwaps().solve(CommonFun.createInput(a), b));
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

    //mininum swaps
        public int solveW(int[] a, int number) {
        //  int[] a = { 52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70 };
            //   int b = 19;
            //for this input my answer is failing
            //  output should be 7 ,  my code is giving 9
        int swap = 0;
        int n = a.length - 1;
        int i = 0;
        int j = n;
        while (i <j) {
            if (a[i] > number) {
                if (a[j] <= number) {
                    swap(i, j, a);
                    swap++;
                    i++;
                    j--;
                }
                else{
                    j--;
                }
            }
            else {
                i++;
            }
        }
        return swap;
    }

    private void swap(int i, int j, int[] a) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
