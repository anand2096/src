package DSA.journey.feb18;

import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        int n = 80;
        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        int ans[][] = new SpiralMatrix().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(ans[i][j]);
            }
            op.add(temp);
        }
        System.out.println(op);

    }

    public int[][] generateMatrix(int size) {
        int ans[][] = new int[size][size];
        int k = 0;//starting row index
        int m = size; //ending row index
        int l = 0; // starting col index
        int n = size; // ending col index
        int cnt = 1;

        while (k < m && l < n) {

            for (int i = l; i < n; i++) {
                ans[k][i] = cnt;
                cnt = cnt + 1;
            }
            k++;
            for (int i = k; i < m; i++) {
                ans[i][n - 1] = cnt;
                cnt = cnt + 1;
            }
            n--;
            if (k < m) {
                for (int i = n - 1; i >= l; i--) {
                    ans[m - 1][i] = cnt;
                    cnt = cnt + 1;
                }
                m--;
            }
            if (l < n) {
                for (int i = m - 1; i >= k; i--) {
                    ans[i][l] = cnt;
                    cnt = cnt + 1;
                }
                l++;
            }
        }
        return ans;
    }

}
