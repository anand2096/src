package DSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

class PairDist {
    int first;
    int second;

    int distance;

    PairDist(int first, int second, int distance) {
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}

public class DistanceOfNearestCellHavingOne {

    public static void main(String[] args) {

    }



    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result[][] = new int[n][m];
        int vis[][] = new int[n][m];
        Queue<PairDist> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new PairDist(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        while (!queue.isEmpty()) {

            int row = queue.peek().first;
            int col = queue.peek().second;
            int dis = queue.peek().distance;
            queue.remove();
            result[row][col] = dis;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    queue.add(new PairDist(nrow, ncol, dis + 1));
                }
            }
        }
        return result;
    }
}
