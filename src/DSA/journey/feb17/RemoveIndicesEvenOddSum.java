package DSA.journey.feb17;

import DSA.CommonFun;

import java.util.ArrayList;

public class RemoveIndicesEvenOddSum {
    public static void main(String[] args) {

        int arr[] = {1, 1, 1};
        ArrayList<Integer> input = CommonFun.createInput(arr);
        System.out.println(new RemoveIndicesEvenOddSum().solve(input));
    }


    public int solve(ArrayList<Integer> list) {
        int cnt = 0;
        int n = list.size();
        int[] odd = new int[n];
        int[] even = new int[n];
        even[0] = list.get(0);
        for (int i = 1; i < n; i++) {
            odd[i] = odd[i - 1];
            even[i] = even[i - 1];

            if (i % 2 == 0) {
                even[i] += list.get(i);
            } else {
                odd[i] += list.get(i);
            }
        }
        int p = odd[n - 1];
        int q = even[n - 1] - list.get(0);
        if (p == q)
            cnt++;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                p = even[n - 1] - even[i - 1] - list.get(i) + odd[i - 1];
                q = odd[n - 1] - odd[i - 1] + even[i - 1];
            } else {
                q = odd[n - 1] - odd[i - 1] - list.get(i) + even[i - 1];
                p = even[n - 1] - even[i - 1] + odd[i - 1];
            }
            if (p == q)
                cnt++;
        }

            return cnt;
    }
}
