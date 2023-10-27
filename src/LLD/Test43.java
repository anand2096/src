package LLD;

import java.util.HashMap;
import java.util.Map;


class pos {
    int i;
    int j;

    public pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Test43 {
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 2, 6, 3};
        int[][] mat = {{4, 3, 5}, {1, 2, 6}};
        System.out.println(new Test43().firstCompleteIndex(arr, mat));
    }





    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int ans = -1;
        Map<Integer, Integer> rowC = new HashMap<>();

        Map<Integer, Integer> colC = new HashMap<>();
        Map<Integer, pos> pos = new HashMap<>();
        for (int j = 0; j < mat.length; j++) {
            for (int k = 0; k < mat[0].length; k++) {
                int no = mat[j][k];
                pos.put(no, new pos(j, k));

            }
        }
        for (int i = 0; i < mat.length; i++) {
            rowC.put(i, 0);
        }
        for (int i = 0; i < mat[0].length; i++) {
            colC.put(i, 0);
        }
        for (int i = 0; i < arr.length; i++) {
            int no = arr[i];
            int row = pos.get(no).i;
            int col = pos.get(no).j;

            rowC.put(row, rowC.get(row) + 1);
            colC.put(col, colC.get(col) + 1);
            if (colC.get(col) == mat.length) {
                return i;
            }
            if (rowC.get(row) == mat[0].length) {
                return i;
            }

        }
        return ans;
    }
}
