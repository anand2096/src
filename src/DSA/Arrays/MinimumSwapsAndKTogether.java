package DSA.Arrays;

import java.util.ArrayList;

public class MinimumSwapsAndKTogether {

    public static void main(String[] args) {
        int a[]={10,12,20,20,5,19,19,12,1,20,1};
        int no =1;
//        int swaps=0;
//        int i=0,j=a.length-1;
//        while(i<j){
//            while(a[i]<no&&i<a.length)i++;
//            while(a[j]>no&&j>0)j--;
//            if(i<j) {
//                int temp = a[i];
//                a[i] = a[j];
//                a[j] = temp;
//                i++;
//                j--;
//                swaps++;
//            }
//
//
//        }
       // System.out.println("swaps required :: "+swaps);
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
